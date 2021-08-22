package com.java016.playfit.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}









