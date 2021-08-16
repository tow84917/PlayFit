package com.java016.playfit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java016.playfit.model.Food;


public interface FoodRepository extends JpaRepository<Food, Integer>{
	List<Food> findAll();
	Food findById(int id);
}
