package com.java016.playfit.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java016.playfit.model.ResetPasswordToken;

@Repository
public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken ,Integer> {
	
	/**
	 * 找特定 Token
	 * @param resetToken
	 * @return ResetPasswordToken
	 */
	public ResetPasswordToken findByResetToken(String resetToken);
	
	/**
	 * 找特定User、日期的 token
	 * @param userId
	 * @param date
	 * @return List<ResetPasswordToken>
	 */
	@Query(value = "SELECT * FROM reset_password_token rpt "
			+ "WHERE DATE_FORMAT(mail_create, \"%Y-%m-%d\") = :date " // 日期格式化
			+ "AND rpt.user_id = :userId", nativeQuery=true)
	public List<ResetPasswordToken> findByUserIdAndDate(
			@Param("userId") Integer userId, @Param("date") Date date);
	
	/**
	 * 找特定日期的 token
	 * @param date
	 * @return List<ResetPasswordToken>
	 */
	@Query(value = "SELECT * FROM reset_password_token rpt "
			+ "WHERE DATE_FORMAT(mail_create, \"%Y-%m-%d\") = :date " // 日期格式化
			, nativeQuery=true)
	public List<ResetPasswordToken> findByDate(
			@Param("date") Date date);
}









