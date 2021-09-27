package com.java016.playfit.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.DiaryPhoto;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.User;

public interface DailyRecordService {

	// 找特定User所有日記紀錄
	List<DailyRecord> findAllByUser(User user);

	// 找User日期區間日記紀錄
	List<DailyRecord> findAllDateBetween(Integer userId, Date startDate, Date endDate);

	// 找特定User、日期日記紀錄
	DailyRecord findByUserIdAndDate(Integer userId, Date date);
	
	// 找特定日期所有日記紀錄
	List<DailyRecord> findByCreatedDate(Date date);
	List<DailyRecord> findAllByCreatedYearAndMonthAndStatus(User user,int year,int month,int status);
	//以下陳以文
	//以下陳以文
	//以下陳以文
	Page<DailyRecord> getAllDailyRecordByUserAndPage(User user,int pageNumber);
	DailyRecord getDailyRecordByUserAndDate(User user,Date date);
	void saveDailyRecord(DailyRecord dailyRecord);
	DailyRecord getDailyRecordByIdWithUserCheck(int id, String username);
	void updateDailyRecordKcalIntake(DailyRecord dailyRecord);
	void updateDailyRecordAndMeal(DailyRecord dailyRecord,String[] timePeriodIdsFoodIdsForUpdate,
									String[] mealIdsForDelete,String username);
	void updateDailyRecordKcalBurned(DailyRecord dailyRecord,FitAchieve fitAchieve);
	boolean isDailyRecordBecomeDairy(DailyRecord dailyRecord);
	void saveDiaryPhoto(DiaryPhoto diaryPhoto);
	//以上陳以文
	//以上陳以文
	//以上陳以文
	//以上陳以文
}