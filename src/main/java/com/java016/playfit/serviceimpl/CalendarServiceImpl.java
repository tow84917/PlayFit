package com.java016.playfit.serviceimpl;

import com.java016.playfit.converter.LocalDateCalendarAttributeConverter;
import com.java016.playfit.dao.*;
import com.java016.playfit.model.*;
import com.java016.playfit.service.CalendarService;
import com.java016.playfit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CalendarServiceImpl implements CalendarService {
	@Autowired
	FitAchieveRepository fitAchieveRepository;
	@Autowired
	MonthlyRecordRepository monthlyRecordRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DailyRecordRepository dailyRecordRepository;
	@Autowired
	FitActivityRepository fitActivityRepository;
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
		MonthlyRecord monthlyRecord = monthlyRecordRepository.findByUserIdAndMonthly(userId,  monthly , year);
		System.out.println("CalendarServiceImpl---");
//		如果沒有當月紀錄，則建一筆新的空紀錄
		if( monthlyRecord == null) {
			Calendar calendar = new Calendar.Builder().build();
			calendar.set(year, monthly-1, 1);
			User user = userRepository.getById(userId);
			monthlyRecord = new MonthlyRecord( user, calendar, 0, 0, 0);
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
//		List<DailyRecord> byCreatedDate = dailyRecordRepository.findByCreatedDate(date , userId);
		DailyRecord byCreatedDate = dailyRecordRepository.findByUserIdAndDate(userId , date);
		List<FitAchieve> fitAchieveList = new ArrayList<>();
//		for (DailyRecord d :
//				byCreatedDate) {
//			System.out.println(d.getFitAchieves());
			List<FitAchieve> fitAchieves = byCreatedDate.getFitAchieves();
			for (FitAchieve fitAchieve :
					fitAchieves) {
				fitAchieveList.add(fitAchieve);
			}
//		}
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
		List<Integer> list = new ArrayList<>();
		System.out.println("findMonthlyFitDays--------");
		int userId = userService.getLoginUserId();
		System.out.println("userId: " + userId);
		List<Date> monthlyDays = fitAchieveRepository.findByMonthAndYearGroup(userId, month, year);
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
	/**
	 * 找user當月哪幾天有排健身  如果當天有紀錄，但沒健身，或是直接執行沒預先排程？
	 * @param month
	 * @param year
	 * @return List<Integer>
	 */
	@Override
	public List<Integer> findUserMonthlyFitDays(int month, int year) {
		System.out.println("findUserMonthlyFitDays###############");
		List<Integer> list = new ArrayList<>();
		List<Integer> set =new LinkedList<Integer>();

		System.out.println("findUserMonthlyFitDays--------");
		int userId = userService.getLoginUserId();
		System.out.println("userId: " + userId);
		List<DailyRecord> monthlyRecords = dailyRecordRepository.findByCreatedDateMonthly(userId, month, year);

		for (DailyRecord dailyRecord : monthlyRecords) {
			boolean flag = false;
			List<FitAchieve> fitAchieves = dailyRecord.getFitAchieves(); // 當天所做、排的健身
			if (fitAchieves != null){									// 如果健身記錄不為空
				for (FitAchieve fitAchieve : fitAchieves) {
					String status = fitAchieve.getStatus();
					if ("按計畫執行".equals(status) || "直接執行".equals(status) || "未執行".equals(status)){ // 如果有排計畫
						Date createdDate = (Date) dailyRecord.getCreatedDate();
						Calendar createdCalender = converter.convertToEntityAttribute(createdDate);
						int i = createdCalender.get(Calendar.DAY_OF_MONTH);
//						System.out.println("排程日期: " + i);
						set.add(i);
					} // 直接執行
				}
			} else { // 如果健身記錄為空
			}
		}

		System.out.println("findUserMonthlyFitDays###############");
		return set;
	}

	/**
	 * 找某部位的健身動作
	 * @param bodyPartSelect
	 * @return
	 */
	@Override
	public List<FitActivity> findActivities(String bodyPartSelect) {
		System.out.println("calendarService in");
		List<FitActivity> allByBodyPart = fitActivityRepository.findAllByBodyPart(bodyPartSelect);


		return allByBodyPart;
	}

	/**
	 * 依user增加一筆健身計畫
	 * @param day
	 * @param activities
	 */
	@Override
	@Transactional
	public void addActivities( String day, List<String> activities) throws ParseException {
		System.out.println("addActivities in");
		int loginUserId = this.userService.getLoginUserId();
		// 2021/8/20 日期字串轉 sql.Date
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date(df.parse(day).getTime());
		for (String activityId : activities) {
			System.out.println(activityId);

			// 依user、日期，找出當天日記的id
			DailyRecord dailyRecord = dailyRecordRepository.findByUserIdAndDate(loginUserId, date);
			// 如果沒日記，新增一筆
			if (dailyRecord == null ) {
				dailyRecord = new DailyRecord(userService.getUserById(loginUserId) , 0 , date);
				dailyRecordRepository.save(dailyRecord);
			}

			// 依健身Id，找出健身項目
			int id = Integer.parseInt(activityId);

			FitActivity activity = fitActivityRepository.findById(id).get();

			FitAchieve fitAchieve = new FitAchieve("未執行", 1, activity.getKcalBurn(), dailyRecord , activity);
			System.out.println(fitAchieve);

			fitAchieveRepository.save(fitAchieve);
		}
		System.out.println("addActivities out");
//		fitAchieveRepository.saveAll();
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
