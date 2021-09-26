package com.java016.playfit.serviceimpl;

import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.OrderRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.security.CustomUserDetails;
import com.java016.playfit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserService userService;

	
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
	@Transactional
	@Override
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	/**
	 * 更新使用者密碼
	 * @param id
	 * @param password
	 */
	@Transactional
	@Override
	public void updateUserPassword(Integer id, String password) {
		String encodedPassword = passwordEncoder.encode(password); // 加密
		userRepo.updateUserPassword(id, encodedPassword);
	}
	
	/**
	 * 更新使用者啟用狀態
	 * @param id
	 * @param certificationStatus
	 */
	@Transactional
	@Override
	public void updateUserCertificationStatus(Integer id, Integer certificationStatus) {
		userRepo.updateUserCertificationStatus(id, certificationStatus);
	}
	
	/**
	 * 更新使用者名稱
	 * @param id
	 * @param fullName
	 */
	@Transactional
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
		CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
		return user.getUser();
	}

	/**
	 * 獲取登入id
	 * 
	 * @return user id
	 */
	@Override
	public Integer getLoginUserId() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		Object principal = authentication.getPrincipal();
		CustomUserDetails customUserDetails = (CustomUserDetails) principal;
		return customUserDetails.getUser().getId();
	}

	/**
	 * 獲取登入名
	 * 
	 * @return username
	 */
	@Override
	public String getLoginUserName() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUserDetails = 
				(CustomUserDetails) authentication.getPrincipal();
		return customUserDetails.getUser().getFullName();
	}
	
	/**
	 * 獲取登入Email
	 * 
	 * @return Email
	 */
	@Override
	public String getLoginUserEmail() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUserDetails = 
				(CustomUserDetails) authentication.getPrincipal();
		return customUserDetails.getUser().getEmail();
	}
	
	/**
	 * 確認登入者是否啟用
	 * @return isEnabled
	 */
	@Override
	public boolean isLoginUserEnable() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUserDetails = 
				(CustomUserDetails) authentication.getPrincipal();
		
		return customUserDetails.isEnabled();
	}

	@Override
	public void updateUserRole(Integer userId, String role) {
		userRepo.updateUserRole(userId, role);
	}

	@Override
	public void updateUserDateline(HttpSession session, Integer userId, OrderRecord record) {
		System.out.println("updateDateline ->> ");
		String execTimes = (String) session.getAttribute("execTimes");
		System.out.println(execTimes);
		Integer i = Integer.parseInt(execTimes);
		String itemName = (String) session.getAttribute("itemName");
		System.out.println(itemName);
		User loginUser = userService.getLoginUser();

		Calendar paymentDate;
		if (loginUser.getDateline() == null){
			paymentDate = record.getPaymentDate();
		}else {
			paymentDate = loginUser.getDateline();
		}

		if (itemName.equals("年付")){
			int year = paymentDate.get(Calendar.YEAR) + i;
			paymentDate.set(Calendar.YEAR, year);
		} else if (itemName.equals("月付")){
			int month = paymentDate.get(Calendar.MONTH) + i;
			paymentDate.set(Calendar.MONTH, month);
		}

		userRepo.updateUserDateline(userId,paymentDate);
	}

}












