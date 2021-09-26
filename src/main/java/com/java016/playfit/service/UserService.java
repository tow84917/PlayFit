package com.java016.playfit.service;

import java.util.List;

import com.java016.playfit.model.OrderRecord;
import com.java016.playfit.model.User;

import javax.servlet.http.HttpSession;

public interface UserService {

	List<User> findAll();

	// Id 找會員
	User getUserById(Integer id);

	// email 找會員
	User findByEmail(String email);

	// 註冊用
	void saveUser(User user);
	
	/**
	 * 更新使用者密碼
	 * @param id
	 * @param password
	 */
	void updateUserPassword(Integer id, String password);
	
	/**
	 * 更新使用者啟用狀態
	 * @param id
	 * @param password
	 */
	void updateUserCertificationStatus(Integer id, Integer certificationStatus);
	
	/**
	 * 更新使用者名稱
	 * @param id
	 * @param fullName
	 */
	void updateUserName(Integer id, String fullName);

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

	/**
	 * 獲取登入Email
	 * 
	 * @return Email
	 */
	String getLoginUserEmail();
	
	/**
	 * 確認登入者是否啟用
	 * @return isEnabled
	 */
	boolean isLoginUserEnable();

    void updateUserRole(Integer userId, String role_prime);

	void updateUserDateline(HttpSession session, Integer userId, OrderRecord record);
}






