package com.java016.playfit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.FoodRepository;
import com.java016.playfit.model.Food;
import com.java016.playfit.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	FoodRepository foodRepo;

	@Override
	public List<Food> getAllFood() {
		return foodRepo.findAll();
	}

	@Override
	public Food getFoodById(int id) {
		Food food = foodRepo.findById(id);
		if(food!=null) {
			return food;
		}else {
			throw new RuntimeException("TimePeriod not found for id :: " + id);
		}
	}

}
