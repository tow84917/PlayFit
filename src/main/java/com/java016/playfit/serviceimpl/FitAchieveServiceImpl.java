package com.java016.playfit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.FitAchieveRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.service.FitAchieveService;

@Service
public class FitAchieveServiceImpl implements FitAchieveService{

	@Autowired
	FitAchieveRepository FitAchieveRepo;
	
	@Override
	public List<FitAchieve> getAllFitAchieveByDailyRecordAndStatus(DailyRecord dailyRecord,String status) {

		return FitAchieveRepo.findAllByDailyRecordAndStatus(dailyRecord, status);
	}

}
