package com.java016.playfit.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.User;

@Repository
public interface DailyRecordRepository extends JpaRepository<DailyRecord, Integer>{
	
	public List<DailyRecord> findAllByUser(User user);
	
//	nativeQuery = true 原生sql 語法
	@Query(value = "SELECT * FROM Daily_Record dr WHERE dr.user_id = :userId AND (dr.created_date BETWEEN :startDate AND :endDate)"
	, nativeQuery=true)
	public List<DailyRecord> findByUserIdAndDateBetween(
			@Param("userId")Integer userId,
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);
	
	@Query(value = "SELECT * FROM Daily_Record where created_date = "
			+ ":createdDate and user_id = :userId" , nativeQuery = true)
	public List<DailyRecord> findByCreatedDate(Date createdDate, int userId);
	
	@Query(value = "SELECT * FROM Daily_Record d WHERE d.created_date = "
			+ ":date AND d.user_id = :userId", nativeQuery=true)
	DailyRecord findByUserIdAndDate(@Param("userId")Integer userId,@Param("date")Date date);
}













