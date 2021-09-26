package com.java016.playfit.service;

import java.sql.Date;
import java.util.List;

import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.model.User;

public interface PersonalGoalService {

	// 找特定User所有目標紀錄
	List<PersonalGoal> findByUserId(Integer userId);

	// 找特定User最新目標紀錄
	PersonalGoal findLastDateByUserId(Integer userId);

	// 找特定User、日期目標紀錄
	PersonalGoal findByUserIdAndDate(Integer userId, Date date);

	// 儲存目標
	void savePersonalGoal(PersonalGoal personalGoal);

	// 更新或儲存目標
	void updatePersonalGoal(Double newGoal, User user, HealthRecord healthRecord);
	
	// 修改目標總消耗量
	void updateTotalLost(PersonalGoal personalGoal, Integer kcalBurned);
}







