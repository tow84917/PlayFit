package com.java016.playfit.service;

import java.util.List;

import com.java016.playfit.model.TimePeriod;

public interface TimePeriodService {
	List<TimePeriod> getAllTimePeriod();
	TimePeriod getTimePeriodById(int id);
}
