package com.java016.playfit.service;

import java.util.List;

import com.java016.playfit.model.Food;

public interface FoodService {
	List<Food> getAllFood();
	Food getFoodById(int id);
}
