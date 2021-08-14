package com.java016.playfit.dao;

import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.DailyRecord;

@Repository
public interface DailyRecordRepository extends JpaRepository<DailyRecord, Integer>{
	
	public List<DailyRecord> findByUserId(Integer userId);
	
//	nativeQuery = true 原生sql 語法
//	@Transactional
//	@Query(value = "SELECT * FROM Daily_Record dr WHERE dr.user_id = :userId AND (dr.created_date BETWEEN :startDate AND :endDate)"
//	, nativeQuery=true)
//	public List<DailyRecord> findAllDateBetween(
//			@Param("userId")Integer userId,
//			@Param("startDate") Date startDate, 
//			@Param("endDate") Date endDate);
	
	//Hql
	@Query(value = "FROM DailyRecord dr "
	+ "WHERE dr.userId = :userId AND (dr.date BETWEEN :startDate AND :endDate)")
	public List<DailyRecord> findAllDateBetween(
			@Param("userId")Integer userId,
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);

	@Query(value = "SELECT * FROM Daily_Record where created_date = :createdDate and user_id = :userId" , nativeQuery = true)
	public List<DailyRecord> findByCreatedDate(Date createdDate, int userId);
}













