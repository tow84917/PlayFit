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
	@Transactional
	@Override
	public void saveHealthRecord(HealthRecord healthRecord) {
		healthRecordRepo.save(healthRecord);
	}

	// 創建新的健康紀錄(無今日紀錄時)
	@Transactional
	@Override
	public void createNewRecord(HealthRecord lastRecord, User user, Date date) {
		
		// 用舊的紀錄給欄位缺少的值
		HealthRecord healthRecordToday = new HealthRecord();
		healthRecordToday.setHeight(lastRecord.getHeight());
		healthRecordToday.setWeight(lastRecord.getWeight());
		healthRecordToday.setAge(bodyCalculator.calAge(user.getBirthday()));
		healthRecordToday.setExerciseFrequency(lastRecord.getExerciseFrequency());
		healthRecordToday.setCalorieDeficit(lastRecord.getCalorieDeficit());
		healthRecordToday.setDate(date);
		healthRecordToday.setUser(user);
		healthRecordToday = bodyCalculator.calAll(healthRecordToday, user);
		healthRecordRepo.save(healthRecordToday);
	}

	// 更新健康紀錄(有今日紀錄時)
	@Transactional
	@Override
	public void updateHealthRecord(User user, HealthRecord healthRecordToday) {
		
		healthRecordToday = bodyCalculator.calAll(healthRecordToday, user);
		healthRecordRepo.save(healthRecordToday);
	}
	
	// 更新熱量赤字
	@Override
	public void updateCalorieDeficit(Integer id, Double calorieDeficit) {
		healthRecordRepo.updateCalorieDeficit(id, calorieDeficit);
	}
	
	//找所有該日期紀錄
	@Override
	public List<HealthRecord> findByDate(Date date) {
		return healthRecordRepo.findByDate(date);
	}

}









