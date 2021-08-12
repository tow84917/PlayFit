package com.java016.playfit.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.java016.playfit.model.DailyRecord;

public interface DailyRecordService {

	// 找特定User所有日記紀錄
	List<DailyRecord> findByUserId(Integer userId);

	// 找User日期區間日記紀錄s
	List<DailyRecord> findAllDateBetween(Integer userId, Date startDate, Date endDate);

	// response 自訂格式化
	String[] formatDataForResponse(String day, Integer kcal);

	// 回傳日期區間運動卡洛里資料(*之後會變更區間)
	Map<Integer, String[]> weekExerciseData(Integer userId) throws InterruptedException;

}