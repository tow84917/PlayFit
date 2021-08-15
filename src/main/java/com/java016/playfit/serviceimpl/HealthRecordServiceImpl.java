package com.java016.playfit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.HealthRecordRepository;
import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.service.HealthRecordService;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {
	
	@Autowired
	HealthRecordRepository healthRecordRepo;
	
	// 找特定User所有健康紀錄
	@Override
	public List<HealthRecord> findByUserId(Integer userId){
		return healthRecordRepo.findByUserId(userId);
	};
	
	// 找特定User最新健康紀錄
	@Override
	public HealthRecord findLastDateByUserId(Integer userId) {
		return healthRecordRepo.findLastDateByUserId(userId);
	};
	
}













