package com.java016.playfit.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.AvatarRepository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.User;
import com.java016.playfit.service.CalenderService;
import com.java016.playfit.service.UserService;

@Service
public class CalenderServiceImpl implements CalenderService{

	@Autowired
	AvatarRepository avatarRepo;

	
	public byte[] findImage(int id) {
		 Optional<Avatar> optional = avatarRepo.findById(id);
		 Avatar avatar = null;
			if(optional.isPresent()) {
				avatar = optional.get();
			}else {
				throw new RuntimeException("User not found for id :: " + id);
		}
			
		byte[] image = avatar.getImage();
		
		
		return image;
	}
	
	
}
