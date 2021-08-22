package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.HealthRecordRepository;
import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.service.HealthRecordService;
import com.java016.playfit.tool.BodyCalculator;

@Service
@Transactional
public class HealthRecordServiceImpl implements HealthRecordService {

	@Autowired
	HealthRecordRepository healthRecordRepo;

	@Autowired
	BodyCalculator bodyCalculator;

	// 找特定User所有健康紀錄
	@Override
	public List<HealthRecord> findByUserId(Integer userId) {
		return healthRecordRepo.findByUserId(userId);
	};

	// 找特定User最新健康紀錄
	@Override
	public HealthRecord findLastDateByUserId(Integer userId) {
		return healthRecordRepo.findLastDateByUserId(userId);
	};

	// 找特定User、日期健康紀錄
	@Override
	public HealthRecord findByUserIdAndDate(Integer userId, Date date) {
		HealthRecord healthRecord = healthRecordRepo.findByUserIdAndDate(userId, date);
		return healthRecord;
	}
	
	// 儲存健康紀錄
	@Override
	public void saveHealthRecord(HealthRecord healthRecord) {
		healthRecordRepo.save(healthRecord);
	}

	// 更新或儲存健康紀錄
	@Override
	public void updateHealthRecord(User user, HealthRecord healthRecord) {

		// 今天的日期
		java.util.Date utilDate = new java.util.Date();
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		// 找今天是否已經有紀錄
		HealthRecord healthRecordToday = healthRecordRepo.findByUserIdAndDate(user.getId(), sqlDate);

		// 每天限創一個健康紀錄
		if (healthRecordToday == null) { // 新的
			healthRecordToday = new HealthRecord();
			healthRecordToday.setHeight(healthRecord.getHeight());
			healthRecordToday.setWeight(healthRecord.getWeight());
			healthRecordToday.setAge(bodyCalculator.calAge(user.getBirthday()));
			healthRecordToday.setExerciseFrequency(healthRecord.getExerciseFrequency());
			healthRecordToday.setCalorieDeficit(healthRecord.getCalorieDeficit());
			healthRecordToday.setDate(sqlDate);
			healthRecordToday.setUser(user);
			healthRecordToday = bodyCalculator.calAll(healthRecordToday, user);
			healthRecordRepo.save(healthRecordToday);
		} else if (healthRecordToday != null) { // 舊的修改
			healthRecordToday = bodyCalculator.calAll(healthRecordToday, user);
			healthRecordToday.setCalorieDeficit(healthRecord.getCalorieDeficit());
			healthRecordRepo.save(healthRecordToday);
		}
	}

}












