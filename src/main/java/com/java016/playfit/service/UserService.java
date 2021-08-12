package com.java016.playfit.service;

import java.util.List;

import com.java016.playfit.model.User;

public interface UserService {

	List<User> findAll();

	// Id 找會員
	User findById(Integer id);

	// email 找會員
	User findByEmail(String email);

	void saveUser(User user);

	User getUserById(int id);

	void updateUserName(int id, String fullName);

	/**
	 * 獲取登入使用者
	 * 
	 * @return user
	 */
	User getLoginUser();

	/**
	 * 獲取登入id
	 * 
	 * @return user id
	 */
	int getLoginUserId();

	/**
	 * 獲取登入名
	 * 
	 * @return username
	 */
	String getLoginUserName();

}