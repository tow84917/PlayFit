package com.java016.playfit.service;

import com.java016.playfit.model.BodyType;

public interface BodyTypeService {

	// 找特定體型
	BodyType findByName(String name);

}