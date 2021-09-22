package com.java016.playfit.service;

import java.sql.Date;
import java.util.List;

import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.User;

public interface HealthRecordService {

	// 找特定User所有健康紀錄
	List<HealthRecord> findByUserId(Integer userId);

	// 找特定User最新健康紀錄
	HealthRecord findLastDateByUserId(Integer userId);

	// 找特定User、日期健康紀錄
	HealthRecord findByUserIdAndDate(Integer userId, Date date);

	// 儲存健康紀錄
	void saveHealthRecord(HealthRecord healthRecord);

	// 創建新的健康紀錄(無今日紀錄時)
	void createNewRecord(HealthRecord lastRecord, User user, Date date);

	// 更新健康紀錄(無今日紀錄時)
	void updateHealthRecord(User user, HealthRecord healthRecordToday);
	
	// 更新熱量赤字
	void updateCalorieDeficit(Integer id, Double calorieDeficit);
	
	//找所有該日期紀錄
	List<HealthRecord> findByDate(Date date);
}






