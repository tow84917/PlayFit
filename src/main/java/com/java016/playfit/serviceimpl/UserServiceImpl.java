package com.java016.playfit.serviceimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.User;
import com.java016.playfit.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void saveUser(User user) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
//		user.setAccount(user.getEmail());
		user.setGender("Male");
		user.setPhone("0900000000");	
		user.setBirthday(new Date());
		user.setCreatedAt(new Timestamp(1627833600));
		user.setCertificationStatus(0);
		userRepo.save(user);
		
	}

	@Override
	public User getUserById(int id) {
		Optional<User> optional = userRepo.findById(id);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}else {
			throw new RuntimeException("User not found for id :: " + id);
		}
		return user;
	}

	@Override
	public void updateUserName(int id, String fullName) {
		userRepo.updateUserName(id, fullName);
	}
	
	
}
