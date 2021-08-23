package com.java016.playfit.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.User;
import com.java016.playfit.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	// Id 找會員
	@Override
	public User getUserById(Integer id) {
		return userRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("User " + id + " not found."));
	}

	// email 找會員
	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	// 註冊用
	@Override
	public void saveUser(User user) {

//		String encodedPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//		user.setGender("Male");
//		user.setPhone("0900000000");
//		user.setBirthday(new Date());
//		user.setCreatedAt(new Timestamp(1627833600));
//		user.setCertificationStatus(0);
		System.out.println(user);
		userRepo.save(user);

	}
	
	/**
	 * 更新使用者密碼
	 * @param id
	 * @param password
	 */
	@Override
	public void updateUserPassword(Integer id, String password) {
		String encodedPassword = passwordEncoder.encode(password); // 加密
		userRepo.updateUserPassword(id, encodedPassword);
	}
	
	/**
	 * 更新使用者名稱
	 * @param id
	 * @param fullName
	 */
	@Override
	public void updateUserName(Integer id, String fullName) {
		userRepo.updateUserName(id, fullName);
	}

	/**
	 * 獲取登入使用者
	 * 
	 * @return user
	 */
	@Override
	public User getLoginUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		return user;
	}

	/**
	 * 獲取登入id
	 * 
	 * @return user id
	 */
	@Override
	public int getLoginUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		return user.getId();
	}

	/**
	 * 獲取登入名
	 * 
	 * @return username
	 */
	@Override
	public String getLoginUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		return user.getFullName();
	}
	
	/**
	 * 獲取登入Email
	 * 
	 * @return Email
	 */
	@Override
	public String getLoginUserEmail() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		return user.getEmail();
	}

}
