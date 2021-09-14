package com.java016.playfit.service;

import java.util.List;

import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.model.User;

import javassist.NotFoundException;

public interface StartFitService {
	List<FitActivity> getAllFitActivities();
	
	FitActivity getFitActivityById(Integer id) throws NotFoundException;
	
	FitAchieve getFitAchieveById(Integer id) throws NotFoundException;
	
	boolean checkFitAchieveIdIsBelongTo(FitAchieve fitAchieve,User user);
	
	void saveFitAchieveWithExecuteDirectly(User user,Integer fitActivityId) throws NotFoundException;
	
	void saveFitAchieveWithExecutionPlan(FitAchieve fitAchieve,User user) throws NotFoundException;
}
