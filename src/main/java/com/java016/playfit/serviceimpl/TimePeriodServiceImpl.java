package com.java016.playfit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.TimePeriodRepository;
import com.java016.playfit.model.TimePeriod;
import com.java016.playfit.service.TimePeriodService;


@Service
public class TimePeriodServiceImpl implements TimePeriodService{

	@Autowired
	TimePeriodRepository timePeriodRepo;

	@Override
	public List<TimePeriod> getAllTimePeriod() {
		List<TimePeriod> timePeriodList = timePeriodRepo.findAll();
		return timePeriodList;
	}

	@Override
	public TimePeriod getTimePeriodById(int id) {
		TimePeriod timePeriod = timePeriodRepo.findById(id);
		if(timePeriod!=null) {
			return timePeriod;
		}else {
			throw new RuntimeException("TimePeriod not found for id :: " + id);
		}
	}

}
