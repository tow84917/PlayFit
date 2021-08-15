package com.java016.playfit.service;

import java.sql.Date;
import java.util.List;

import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.User;

public interface DailyRecordService {

	// 找特定User所有日記紀錄
	List<DailyRecord> findAllByUser(User user);

	// 找User日期區間日記紀錄
	List<DailyRecord> findAllDateBetween(Integer userId, Date startDate, Date endDate);

	// 找特定User、日期日記紀錄
	DailyRecord findByUserIdAndDate(Integer userId, Date date);

}