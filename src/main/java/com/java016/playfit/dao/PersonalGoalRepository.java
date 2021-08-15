package com.java016.playfit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.PersonalGoal;

@Repository
public interface PersonalGoalRepository extends JpaRepository<PersonalGoal, Integer> {
	
	@Query(value = "SELECT * FROM Personal_Goal pg WHERE pg.user_id = :userId "
			+ "order by pg.created_date desc limit 1"
	, nativeQuery=true)
	public PersonalGoal findLastDateByUserId(
			@Param("userId")Integer userId);
	
	public List<PersonalGoal> findByUserId(Integer userId);
}















