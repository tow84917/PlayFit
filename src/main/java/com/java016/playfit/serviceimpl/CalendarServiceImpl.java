package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.*;

import com.java016.playfit.dao.*;
import com.java016.playfit.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.converter.LocalDateCalendarAttributeConverter;
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
	DailyRecordRepository dailyRecordRepository;
	@Autowired
	LocalDateCalendarAttributeConverter converter;
	@Autowired
	UserService userService;

	/**
	 * 找user當月的紀錄
	 * @param monthly
	 * @param year
	 * @return
	 */
	@Override
	public MonthlyRecord findByUserIdAndMonthly(int monthly , int year){
		int userId = userService.getLoginUserId();
		System.out.println("userId: " + userId);
		MonthlyRecord monthlyRecord = monthlyRecordRepository.findByUserIdAndMonthly(41,  monthly , year);
		System.out.println("CalendarServiceImpl---");
//		如果沒有當月紀錄，則建一筆新的空紀錄
		if( monthlyRecord == null) {
			Calendar c = new Calendar.Builder().build();
			c.set(year, monthly-1, 1);
			User user = userRepository.getById(41);			// userId待改
			monthlyRecord = new MonthlyRecord( user, c, 0, 0, 0);
			monthlyRecordRepository.save(monthlyRecord);
		}
		System.out.println(monthlyRecord);

		return monthlyRecord;
	}

	/**
	 * user當日所排程的健身動作
	 * @param date
	 * @return
	 */
	@Override
	public List<FitAchieve> findByCreatedDate(Date date) {
		System.out.println("findByCreatedDate");
		int userId = userService.getLoginUserId();
		System.out.println("userId: " + userId);
		List<DailyRecord> byCreatedDate = dailyRecordRepository.findByCreatedDate(date , 41);
		List<FitAchieve> fitAchieveList = new ArrayList<>();
		for (DailyRecord d :
				byCreatedDate) {
//			System.out.println(d.getFitAchieves());
			Set<FitAchieve> fitAchieves = d.getFitAchieves();
			for (FitAchieve fitAchieve :
					fitAchieves) {
				fitAchieveList.add(fitAchieve);
			}
		}
//		System.out.println(byCreatedDate);
//		System.out.println("------------");
//		System.out.println(fitAchieveList);
		return fitAchieveList;
	}

	/**
	 * 找user當月哪幾天有排健身  如果當天有紀錄，但沒健身，或是直接執行沒預先排程？
	 * @param month
	 * @param year
	 * @return List<Integer>
	 */
	@Override
	public List<Integer> findMonthlyFitDays(int month, int year){
		int[] ints = new int[] {};
		List<Integer> list = new ArrayList<>();
		System.out.println("findMonthlyFitDays--------");
		int userId = userService.getLoginUserId();
		System.out.println("userId: " + userId);
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
