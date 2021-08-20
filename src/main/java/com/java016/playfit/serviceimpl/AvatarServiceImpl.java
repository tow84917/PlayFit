package com.java016.playfit.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.java016.playfit.dao.AvatarRepository;
import com.java016.playfit.model.Avatar;
import com.java016.playfit.service.AvatarService;

public class AvatarServiceImpl implements AvatarService {
	
	@Autowired
	AvatarRepository avatarRepo;

	@Override
	public Avatar getAvatarById(Integer id) {
		return avatarRepo.getById(id);
	}
}
