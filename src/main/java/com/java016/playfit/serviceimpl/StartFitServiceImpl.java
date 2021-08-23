package com.java016.playfit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.FitActivityRepository;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.service.StartFitService;

@Service
public class StartFitServiceImpl implements StartFitService{

	@Autowired
	FitActivityRepository fitActivityRepo;
	@Override
	public List<FitActivity> getAllFitActivities() {
		return fitActivityRepo.findAll();
	}

}
