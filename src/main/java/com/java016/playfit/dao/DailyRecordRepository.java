package com.java016.playfit.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	/**
	 * 找User日期區間日記紀錄
	 * @param userId
	 * @return List<DailyRecord>
	 */
	@Query(value = "SELECT * FROM Daily_Record dr WHERE dr.user_id = :userId AND (dr.created_date BETWEEN :startDate AND :endDate)"
	, nativeQuery=true)
	public List<DailyRecord> findByUserIdAndDateBetween(
			@Param("userId")Integer userId,
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);
	
	/**
	 * 找特定User、日期的日記紀錄
	 * @param userId
	 * @param date
	 * @return DailyRecord
	 */
	@Query(value = "SELECT * FROM Daily_Record d WHERE d.created_date = "
			+ ":date AND d.user_id = :userId", nativeQuery=true)
	public DailyRecord findByUserIdAndDate(@Param("userId")Integer userId, @Param("date")Date date);

	/**
	 * 找user當月的紀錄
	 * @param userId
	 * @param monthly
	 * @param year
	 * @return List<DailyRecord>
	 */
	@Query(value = "select * from Daily_Record where user_id = :userId and  month(created_date) = :monthly and year(created_date) = :year" , nativeQuery = true)
	List<DailyRecord> findByCreatedDateMonthly( int userId, int monthly, int year);
	
//	DailyRecord 一天只有一個 可刪?
//	public List<DailyRecord> findByCreatedDate(Date createdDate, int userId);
	
	/**
	 * 找所有該日期紀錄
	 * @param createdDate
	 * @return List<DailyRecord>
	 */
	public List<DailyRecord> findByCreatedDate(Date createdDate);
	
	
	// 以分頁方式回傳日常紀錄
	Page<DailyRecord> findAllByUser(User user,Pageable pageable);
	
	Page<DailyRecord> findAllByUserAndStatus(User user,Integer status,Pageable pageable);
	
	@Query(value = "select * from Daily_Record where user_id = :userId and  month(created_date) = :month and year(created_date) = :year and status = :status ORDER BY created_date DESC" , nativeQuery = true)
	List<DailyRecord> findByCreatedYearAndMonthAndStatus( @Param("userId")Integer userId, @Param("month")Integer  month, @Param("year")Integer year, @Param("status")Integer status);
}













