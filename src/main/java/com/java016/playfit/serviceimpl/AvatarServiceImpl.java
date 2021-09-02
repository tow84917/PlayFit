package com.java016.playfit.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.AvatarRepository;
import com.java016.playfit.model.Avatar;
import com.java016.playfit.service.AvatarService;

@Service
public class AvatarServiceImpl implements AvatarService {
	
	@Autowired
	AvatarRepository avatarRepo;

	@Override
	public Avatar getAvatarById(Integer id) {
		return avatarRepo.getById(id);
	}
	
	@Transactional
	@Override
	public Avatar saveAvatar(Avatar avatar) {
		return avatarRepo.save(avatar);
	}
}















