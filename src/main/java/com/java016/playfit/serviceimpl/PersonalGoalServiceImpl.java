package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.PersonalGoalRepository;
import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.model.User;
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
		PersonalGoal personalGoal = personalGoalRepo.findByUserIdAndDate(userId, date);
		return personalGoal;
	}

	// 儲存目標
	@Transactional
	@Override
	public void savePersonalGoal(PersonalGoal personalGoal) {
		personalGoalRepo.save(personalGoal);
	}
	
	// 更新或儲存目標
	@Transactional
	@Override
	public void updatePersonalGoal(Double newGoal, User user, HealthRecord healthRecord) {
		
		// 今天的日期
		java.util.Date utilDate = new java.util.Date();
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		// 找今天是否已經有紀錄
		PersonalGoal personalGoalToday = personalGoalRepo.findByUserIdAndDate(user.getId(), sqlDate);

		// 每天限創一個目標
		if (personalGoalToday == null) { // 新的
			personalGoalToday = new PersonalGoal();
			personalGoalToday.setUser(user);
			personalGoalToday.setStartWeight(healthRecord.getWeight());
			personalGoalToday.setGoalWeight(newGoal); // 相等不會 Update
			personalGoalToday.setTotalLost(0);
			personalGoalToday.setCreateDate(sqlDate);
			personalGoalRepo.save(personalGoalToday);
		} else if (personalGoalToday != null) { // 舊的修改
			personalGoalToday.setGoalWeight(newGoal);
			personalGoalRepo.save(personalGoalToday);
		}
	}

	// 修改目標總消耗量
	@Transactional
	@Override
	public void updateTotalLost(PersonalGoal personalGoal, Integer kcalBurned) {
		
		Integer newTotalKcalBurned = personalGoal.getTotalLost() + kcalBurned;
		
		personalGoalRepo.updateTotalLost(personalGoal.getId(), newTotalKcalBurned);
	}
}











