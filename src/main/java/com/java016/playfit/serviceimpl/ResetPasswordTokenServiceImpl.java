package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.ResetPasswordTokenRepository;
import com.java016.playfit.model.ResetPasswordToken;
import com.java016.playfit.service.ResetPasswordTokenService;

@Service
public class ResetPasswordTokenServiceImpl implements ResetPasswordTokenService {
	
	@Autowired
	ResetPasswordTokenRepository resetPasswordTokenRepo;
	
	/**
	 * 找 Token 
	 * @param resetToken
	 * @return ResetPasswordToken
	 */
	@Override
	public ResetPasswordToken findByResetToken(String resetToken) {
		return resetPasswordTokenRepo.findByResetToken(resetToken);
	}
	
	/**
	 * 儲存 ResetPasswordToken
	 * @param resetPasswordToken
	 */
	@Transactional
	@Override
	public void saveResetPasswordToken(ResetPasswordToken resetPasswordToken) {
		resetPasswordTokenRepo.save(resetPasswordToken);
	}
	
	/**
	 * 找特定User、日期的 token
	 * @param userId
	 * @param date
	 * @return List<ResetPasswordToken>
	 */
	@Override
	public List<ResetPasswordToken> findByUserIdAndDate(Integer userId, Date date) {
		return resetPasswordTokenRepo.findByUserIdAndDate(userId, date);
	}
	
	/**
	 * 找特定日期的 token
	 * @param date
	 * @return List<ResetPasswordToken>
	 */
	@Override
	public List<ResetPasswordToken> findByDate(Date date) {
		return resetPasswordTokenRepo.findByDate(date);
	}
	
	/**
	 * 刪除 Token
	 * @param token
	 */
	@Override
	public void deleteToken(ResetPasswordToken token) {
		resetPasswordTokenRepo.delete(token);
	}
	
	
}



















