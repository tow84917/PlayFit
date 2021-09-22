package com.java016.playfit.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.BodyTypeRepository;
import com.java016.playfit.model.BodyType;
import com.java016.playfit.service.BodyTypeService;

@Service
public class BodyTypeServiceImpl implements BodyTypeService {

	@Autowired
	BodyTypeRepository bodyTypeRepo;
	
	// 找特定體型
	@Override
	public BodyType findByName(String name) {
		return bodyTypeRepo.findByName(name);
	}
}





