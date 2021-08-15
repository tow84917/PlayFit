package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.DailyRecordRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.service.DailyRecordService;

@Service
public class DailyRecordServiceImpl implements DailyRecordService  {

	@Autowired
	DailyRecordRepository dailyRecordRepo;

	// 找特定User所有日記紀錄
	@Override
	public List<DailyRecord> findAllByUser(User user) {
		return dailyRecordRepo.findAllByUser(user);
	};

	// 找User日期區間日記紀錄
	@Override
	public List<DailyRecord> findAllDateBetween(Integer userId, Date startDate, Date endDate) {
		return dailyRecordRepo.findByUserIdAndDateBetween(userId, startDate, endDate);
	};

	// 找特定User、日期日記紀錄
	@Override
	public DailyRecord findByUserIdAndDate(Integer userId, Date date) {
		DailyRecord dailyRecord = dailyRecordRepo.findByUserIdAndDate(userId, date);
		return dailyRecord;
	}
}













