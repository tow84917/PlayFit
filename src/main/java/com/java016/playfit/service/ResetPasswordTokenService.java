package com.java016.playfit.service;

import java.sql.Date;
import java.util.List;

import com.java016.playfit.model.ResetPasswordToken;

public interface ResetPasswordTokenService {

	/**
	 * 找 Token 
	 * @param resetToken
	 * @return ResetPasswordToken
	 */
	ResetPasswordToken findByResetToken(String resetToken);
	
	/**
	 * 儲存 ResetPasswordToken
	 * @param resetPasswordToken
	 */
	void saveResetPasswordToken(ResetPasswordToken resetPasswordToken);
	
	/**
	 * 找特定User、日期的 token
	 * @param userId
	 * @param date
	 * @return List<ResetPasswordToken>
	 */
	List<ResetPasswordToken> findByUserIdAndDate(Integer userId, Date date);
	
	/**
	 * 找特定日期的 token
	 * @param date
	 * @return List<ResetPasswordToken>
	 */
	List<ResetPasswordToken> findByDate(Date date);
	
	/**
	 * 刪除 Token
	 * @param token
	 */
	void deleteToken(ResetPasswordToken token);

}













