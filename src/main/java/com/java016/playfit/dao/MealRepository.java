package com.java016.playfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java016.playfit.model.Meal;

public interface MealRepository extends JpaRepository<Meal,Integer>{
	
}
