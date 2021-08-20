package com.java016.playfit.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.MealRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.Meal;
import com.java016.playfit.service.DailyRecordService;
import com.java016.playfit.service.MealService;

@Service
public class MealServiceImpl implements MealService{

	@Autowired
	MealRepository mealRepo;
	@Autowired
	DailyRecordService dailyRecordService;
	
	@Override
	public void saveMeal(Meal meal) {
		mealRepo.save(meal);
	}

	@Override
	public void deleteMeal(int id, String username) {
		Meal meal = mealRepo.getById(id);
		DailyRecord dailyRecord =  meal.getDailyRecord();
		if(meal.getDailyRecord().getUser().getEmail().equals(username)) {
			mealRepo.delete(meal);
		}else {
			throw new AccessDeniedException("user attempted to modify another user's meal.");
		}
//		dailyRecordService.updateDailyRecordKcalIntakeById(id);
	}

}
