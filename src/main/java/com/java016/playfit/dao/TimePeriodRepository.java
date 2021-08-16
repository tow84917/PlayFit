package com.java016.playfit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java016.playfit.model.TimePeriod;

public interface TimePeriodRepository extends JpaRepository<TimePeriod, Integer>{
	List<TimePeriod> findAll();
	TimePeriod findById(int id);
}
