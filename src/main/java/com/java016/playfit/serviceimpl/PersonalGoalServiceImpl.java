package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.PersonalGoalRepository;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.service.PersonalGoalService;

@Service
public class PersonalGoalServiceImpl implements PersonalGoalService {
	@Autowired
	PersonalGoalRepository personalGoalRepo;

	// 找特定User所有目標紀錄
	@Override
	public List<PersonalGoal> findByUserId(Integer userId) {
		return personalGoalRepo.findByUserId(userId);
	}

	// 找特定User最新目標紀錄
	@Override
	public PersonalGoal findLastDateByUserId(Integer userId) {
		return personalGoalRepo.findLastDateByUserId(userId);
	}

	// 找特定User、日期目標紀錄
	@Override
	public PersonalGoal findByUserIdAndDate(Integer userId, Date date) {
		PersonalGoal personalGoal = personalGoalRepo.findByUserIdAndDate(userId, date) ;
		return personalGoal ;
	}
	
	// 儲存新目標
	@Override
	public void savePersonalGoal(PersonalGoal personalGoal) {
		personalGoalRepo.save(personalGoal);
	}
}









