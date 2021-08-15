package com.java016.playfit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.HealthRecord;

@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {
	
	@Query(value = "SELECT * FROM Health_Record hr WHERE hr.user_id = :userId "
			+ "order by hr.date desc limit 1"
	, nativeQuery=true)
	public HealthRecord findLastDateByUserId(
			@Param("userId")Integer userId);
	
	public List<HealthRecord> findByUserId(Integer userId);
}
