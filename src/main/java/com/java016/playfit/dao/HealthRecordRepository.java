package com.java016.playfit.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java016.playfit.model.HealthRecord;

@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {
	
	/**
	 * 找最新健康紀錄
	 * @param userId
	 * @return HealthRecord
	 */
	@Query(value = "SELECT * FROM Health_Record hr WHERE hr.user_id = :userId "
			+ "order by hr.date desc limit 1"
	, nativeQuery=true)
	public HealthRecord findLastDateByUserId(
			@Param("userId")Integer userId);
	
	/**
	 * 找USER 所有健康紀錄
	 * @param userId
	 * @return List<HealthRecord>
	 */
	public List<HealthRecord> findByUserId(Integer userId);
	
	/**
	 * 找USER某日期健康紀錄
	 * @param userId
	 * @param date
	 * @return PersonalGoal
	 */
	@Query(value = "SELECT * FROM Health_Record hr WHERE hr.date = "
			+ ":date AND hr.user_id = :userId", nativeQuery=true)
	public HealthRecord findByUserIdAndDate(@Param("userId")Integer userId,
			@Param("date")Date date);
	
	/**
	 * 更新熱量赤字
	 * @param id
	 * @param password
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	@Modifying
	@Query(value = "UPDATE Health_Record hr SET hr.calorie_deficit = :calorieDeficit "
			+ "WHERE hr.id = :id"
	, nativeQuery=true)
	public void updateCalorieDeficit(
			@Param(value = "id") Integer id, 
			@Param(value="calorieDeficit") Double calorieDeficit) ;
	
	/**
	 * 找所有該日期紀錄
	 * @param createdDate
	 * @return List<HealthRecord>
	 */
	public List<HealthRecord> findByDate(Date date);
}









