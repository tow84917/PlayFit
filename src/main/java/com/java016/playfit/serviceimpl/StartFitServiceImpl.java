package com.java016.playfit.serviceimpl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.FitAchieveRepository;
import com.java016.playfit.dao.FitActivityRepository;
import com.java016.playfit.dao.MonthlyRecordRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.model.MonthlyRecord;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.model.User;
import com.java016.playfit.service.DailyRecordService;
import com.java016.playfit.service.PersonalGoalService;
import com.java016.playfit.service.StartFitService;

import javassist.NotFoundException;

@Service
public class StartFitServiceImpl implements StartFitService{

	@Autowired
	FitActivityRepository fitActivityRepo;
	@Autowired
	FitAchieveRepository fitAchieveRepo;
	@Autowired
	DailyRecordService dailyRecordService;
	@Autowired
	PersonalGoalService personalGoalService;
	@Autowired
	MonthlyRecordRepository monthlyRecordRepo;
	
	@Override
	public List<FitActivity> getAllFitActivities() {
		return fitActivityRepo.findAll();
	}
	
	@Override
	public FitActivity getFitActivityById(Integer id) throws NotFoundException {

		Optional<FitActivity> entityOptional = fitActivityRepo.findById(id);
		if(entityOptional.isPresent()) {
			return entityOptional.get();
		}else {
			throw new NotFoundException("fitActivity id not founded");
		}
	}
	
	@Override
	public FitAchieve getFitAchieveById(Integer id) throws NotFoundException {
		
		Optional<FitAchieve> entityOptional = fitAchieveRepo.findById(id);
		if(entityOptional.isPresent()) {
			return entityOptional.get();
		}else {
			throw new NotFoundException("fitAchieve id not founded");
		}
		
	}
	
	@Override
	public void saveFitAchieveWithExecuteDirectly(User user,Integer fitActivityId) throws NotFoundException {
		
		//抓出今天的日期
		java.util.Date utilDate = new java.util.Date();
		//把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		//時間戳記型態的日期
		Timestamp timestamp = new Timestamp(utilDate.getTime());
		//執行的健身動作
		FitActivity fitActivity = getFitActivityById(fitActivityId);
		//
		DailyRecord dailyRecord = dailyRecordService.getDailyRecordByUserAndDate(user, sqlDate);
		
		
		if(dailyRecord == null) {
			dailyRecord = new DailyRecord();
			dailyRecord.setUser(user);
			dailyRecord.setKcalBurned((int)fitActivity.getKcalBurn());
			dailyRecord.setKcalIntake(0);
			dailyRecord.setStatus(0);
			dailyRecord.setCreatedDate(sqlDate);
			dailyRecordService.saveDailyRecord(dailyRecord);
			
			FitAchieve fitAchieve = new FitAchieve();
			fitAchieve.setDailyRecord(dailyRecord);
			fitAchieve.setFitActivity(fitActivity);
			fitAchieve.setNumberGroups(1);
			fitAchieve.setTotalKcal((int)fitActivity.getKcalBurn());
			fitAchieve.setExecutionDate(sqlDate);
			fitAchieve.setEndTime(timestamp);
			fitAchieve.setStatus("直接執行");
			fitAchieveRepo.save(fitAchieve);
		}else {
			List<FitAchieve> toDoFitAchieve = fitAchieveRepo.findAllByDailyRecordAndFitActivityAndStatus(dailyRecord, fitActivity, "未執行");
			System.out.println(toDoFitAchieve);

			if(!toDoFitAchieve.isEmpty()) {
				FitAchieve fitAchieve = toDoFitAchieve.get(0);
				fitAchieve.setEndTime(timestamp);
				fitAchieve.setStatus("按計畫執行");
				fitAchieveRepo.save(fitAchieve);	
			}else {
				FitAchieve fitAchieve = new FitAchieve();
				fitAchieve.setDailyRecord(dailyRecord);
				fitAchieve.setFitActivity(fitActivity);
				fitAchieve.setNumberGroups(1);
				fitAchieve.setTotalKcal((int)fitActivity.getKcalBurn());
				fitAchieve.setExecutionDate(sqlDate);
				fitAchieve.setEndTime(timestamp);
				fitAchieve.setStatus("直接執行");
				fitAchieveRepo.save(fitAchieve);
			}
			
			int tempKcalBurned = 0;
			if(dailyRecord.getKcalBurned() != null) {
				tempKcalBurned = dailyRecord.getKcalBurned();
			}
			
			dailyRecord.setKcalBurned(tempKcalBurned + (int)fitActivity.getKcalBurn());
			dailyRecordService.saveDailyRecord(dailyRecord);

			
			//更新個人目標的消耗量
			PersonalGoal personalGoal = personalGoalService.findLastDateByUserId(user.getId());
			personalGoal.setTotalLost(personalGoal.getTotalLost() + (int)fitActivity.getKcalBurn());
			personalGoalService.savePersonalGoal(personalGoal);
			
			//更新月紀錄
			Calendar calender = Calendar.getInstance();
			calender.setTime(sqlDate);
			System.out.println("calender = " + calender.getTime());
			
			MonthlyRecord monthlyRecord = monthlyRecordRepo.findByUserIdAndMonthly(user.getId(), calender.get(Calendar.MONTH)+1, calender.get(Calendar.YEAR));
			
			if(monthlyRecord == null) {
				monthlyRecord = new MonthlyRecord(user, calender, 0, 0, 0);
			}
			System.out.println("monthlyRecord = " + monthlyRecord.getMonthly());
			monthlyRecord.setFinish(monthlyRecord.getFinish()+1);
			monthlyRecord.setMonthlyKcal(monthlyRecord.getMonthlyKcal() + (int)fitActivity.getKcalBurn());
			
			Calendar activityTime = Calendar.getInstance();
			activityTime.setTime(fitActivity.getTime());
			monthlyRecord.setMonthlyTime(monthlyRecord.getMonthlyTime() + activityTime.get(Calendar.MINUTE));
			System.out.println("activityTime = " + activityTime.get(Calendar.MINUTE));
			
			monthlyRecordRepo.save(monthlyRecord);

		}
		
		PersonalGoal personalGoal = personalGoalService.findLastDateByUserId(user.getId());
//		personalGoal.setTotalLost(personalGoal.getTotalLost() + (int)fitActivity.getKcalBurn());
//		personalGoalService.savePersonalGoal(personalGoal);
		personalGoalService.updateTotalLost(personalGoal, fitActivity.getKcalBurn());
		
	}
	
	@Override
	public boolean checkFitAchieveIdIsBelongTo(FitAchieve fitAchieve, User user){
		DailyRecord dailyRecord = fitAchieve.getDailyRecord();
		if(dailyRecord.getUser().getId() == user.getId()) {
			return true;
		}
		return false;
	}

	@Override
	public void saveFitAchieveWithExecutionPlan(FitAchieve fitAchieve,User user) throws NotFoundException {
		
		//抓出今天的日期
		java.util.Date utilDate = new java.util.Date();
		//把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		//時間戳記型態的日期
		Timestamp timestamp = new Timestamp(utilDate.getTime());
		
		boolean isFitAchieveBelongToCurrentUser = checkFitAchieveIdIsBelongTo(fitAchieve, user);
		if(!isFitAchieveBelongToCurrentUser) throw new NotFoundException("Current User Try To Modify Other Users FitAchieve");
		
		if(!fitAchieve.getStatus().equals("未執行")) throw new NotFoundException("Current User Try To Modify Unexpected Status Of FitAchiece");
		fitAchieve.setEndTime(timestamp);
		fitAchieve.setStatus("按計畫執行");
		fitAchieveRepo.save(fitAchieve);
		DailyRecord dailyRecord = fitAchieve.getDailyRecord();
		int tempKcalBurned = 0;
		if(dailyRecord.getKcalBurned() != null) {
			tempKcalBurned = dailyRecord.getKcalBurned();
		}
		dailyRecord.setKcalBurned(tempKcalBurned + fitAchieve.getTotalKcal());
		
		fitAchieveRepo.save(fitAchieve);
		dailyRecordService.saveDailyRecord(dailyRecord);
		
		//更新個人目標的消耗量
		PersonalGoal personalGoal = personalGoalService.findLastDateByUserId(user.getId());
		personalGoal.setTotalLost(personalGoal.getTotalLost() + fitAchieve.getTotalKcal());
		personalGoalService.savePersonalGoal(personalGoal);
		
		//更新月紀錄
		Calendar calender = Calendar.getInstance();
		calender.setTime(sqlDate);
		System.out.println("calender = " + calender.getTime());
		
		MonthlyRecord monthlyRecord = monthlyRecordRepo.findByUserIdAndMonthly(user.getId(), calender.get(Calendar.MONTH)+1, calender.get(Calendar.YEAR));
		
		if(monthlyRecord == null) {
			monthlyRecord = new MonthlyRecord(user, calender, 0, 0, 0);
		}
		System.out.println("monthlyRecord = " + monthlyRecord.getMonthly());
		monthlyRecord.setFinish(monthlyRecord.getFinish()+1);
		monthlyRecord.setMonthlyKcal(monthlyRecord.getMonthlyKcal() + fitAchieve.getFitActivity().getKcalBurn());
		
		Calendar activityTime = Calendar.getInstance();
		activityTime.setTime(fitAchieve.getFitActivity().getTime());
		monthlyRecord.setMonthlyTime(monthlyRecord.getMonthlyTime() + activityTime.get(Calendar.MINUTE));
		System.out.println("activityTime = " + activityTime.get(Calendar.MINUTE));
		
		monthlyRecordRepo.save(monthlyRecord);
		
	}

}
