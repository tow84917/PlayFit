package com.java016.playfit.service;

import java.util.List;

import com.java016.playfit.model.HealthRecord;

public interface HealthRecordService {

	// 找特定User所有健康紀錄
	List<HealthRecord> findByUserId(Integer userId);

	// 找特定User最新健康紀錄
	HealthRecord findLastDateByUserId(Integer userId);

}