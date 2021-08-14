package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.converter.LocalDateCalendarAttributeConverter;
import com.java016.playfit.dao.AvatarRepository;
import com.java016.playfit.dao.Fit_achieve_Repository;
import com.java016.playfit.dao.Monthly_record_Repository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.MonthlyRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.service.CalendarService;
import com.java016.playfit.service.UserService;

@Service
public class CalendarServiceImpl implements CalendarService {
	@Autowired
	Fit_achieve_Repository achieve_repository;
	@Autowired
	Monthly_record_Repository monthlyRecordRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	LocalDateCalendarAttributeConverter converter;
	@Autowired
	UserService userService;

	public MonthlyRecord findByUser_idAndMonthly(int user_id, int monthly , int year){
		MonthlyRecord monthlyRecord = monthlyRecordRepository.findByUserIdAndMonthly(user_id,  monthly , year);
		System.out.println("CalendarServiceImpl---");


		if( monthlyRecord == null) {
			Calendar c = new Calendar.Builder().build();
			c.set(year, monthly-1, 1);
			User user = userRepository.getById(41);
			monthlyRecord = new MonthlyRecord( user, c, 0, 0, 0);
			monthlyRecordRepository.save(monthlyRecord);
		}
		System.out.println(monthlyRecord);

		return monthlyRecord;
	}

	public List<Integer> findMonthlyFitDays(int month, int year){
		int[] ints = new int[] {};
		List<Integer> list = new ArrayList<>();
		System.out.println("findMonthlyFitDays--------");
//		int userId = userService.getUserId();				// 為登入測試時關閉
		List<Date> monthlyDays = achieve_repository.findByMonthAndYearGroup(41, month, year);
		System.out.println(monthlyDays);
		for (Date c :
				monthlyDays) {
			System.out.println(c);
			if (c instanceof Date) {
				Calendar calendar = converter.convertToEntityAttribute( c);
				System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
				list.add(calendar.get(Calendar.DAY_OF_MONTH));
			}

		}



		/*
		System.out.println("findMonthlyFitDays--------");
		Set<Fit_achieve> days = achieve_repository.findByMonthAndYear(month, year);
		Set<Integer> daysOfMonth = new HashSet<>();
		for (Fit_achieve d :
				days) {
//			System.out.println(d.getExecution_date());
			Calendar calendar = d.getExecution_date();
			int i = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println("Day: > " + i);
			daysOfMonth.add(i);
		}
		Integer[] intArray =  daysOfMonth.toArray(new Integer[daysOfMonth.size()]);

		int[] ints = daysOfMonth.stream().mapToInt(Number::intValue).toArray();

		 */

		return list;
	}

	@Autowired
	AvatarRepository avatarRepo;

	public byte[] findImage(int id) {
		 Optional<Avatar> optional = avatarRepo.findById(id);
		 Avatar avatar = null;
			if(optional.isPresent()) {
				avatar = optional.get();
			}else {
				throw new RuntimeException("User not found for id :: " + id);
		}
			
		byte[] image = avatar.getImage();
		return image;
	}
	
	
}
