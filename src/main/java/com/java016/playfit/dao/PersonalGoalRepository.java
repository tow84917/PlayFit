package com.java016.playfit.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.PersonalGoal;

@Repository
public interface PersonalGoalRepository extends JpaRepository<PersonalGoal, Integer> {
	
	/**
	 * 找USER 所有目標紀錄
	 * @param userId
	 * @return List<PersonalGoal>
	 */
	public List<PersonalGoal> findByUserId(Integer userId);
	
	/**
	 * 找最新目標紀錄
	 * @param userId
	 * @return PersonalGoal
	 */
	@Query(value = "SELECT * FROM Personal_Goal pg WHERE pg.user_id = :userId "
			+ "order by pg.created_date desc limit 1"
	, nativeQuery=true)
	public PersonalGoal findLastDateByUserId(
			@Param("userId")Integer userId);
	
	/**
	 * 找USER某日期目標紀錄
	 * @param userId
	 * @param date
	 * @return PersonalGoal
	 */
	@Query(value = "SELECT * FROM Personal_Goal p WHERE p.created_date = "
			+ ":date AND p.user_id = :userId", nativeQuery=true)
	public PersonalGoal findByUserIdAndDate(@Param("userId")Integer userId,
			@Param("date")Date date);
	
	/**
	 * updateTotalLost
	 * @param id
	 * @param password
	 */
	@Modifying
	@Query(
	  value = "update Personal_Goal pg set pg.total_lost = :totalKcalBurned where pg.id = :id"
	, nativeQuery=true)
	public void updateTotalLost(
			@Param(value = "id") Integer id, 
			@Param(value="totalKcalBurned") Integer kcalBurned) ;

}















