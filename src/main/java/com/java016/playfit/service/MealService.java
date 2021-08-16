package com.java016.playfit.service;

import com.java016.playfit.model.Meal;

public interface MealService {
	void saveMeal(Meal meal);
	void deleteMeal(int id,String username);
}
