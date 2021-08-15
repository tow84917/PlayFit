package com.java016.playfit.service;

import java.util.List;

import com.java016.playfit.model.PersonalGoal;

public interface PersonalGoalService {

	// 找特定User所有目標紀錄
	List<PersonalGoal> findByUserId(Integer userId);

	// 找特定User最新目標紀錄
	PersonalGoal findLastDateByUserId(Integer userId);

}