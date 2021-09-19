package com.java016.playfit.controller;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java016.playfit.model.ResetPasswordToken;
import com.java016.playfit.model.User;
import com.java016.playfit.service.EmailService;
import com.java016.playfit.service.ResetPasswordTokenService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.EmailTool;

@Controller
public class ForgotPasswordController {
	
	UserService userService;
	
	EmailService emailService;
	
	ResetPasswordTokenService resetPasswordTokenService;
	
	EmailTool emailTool ;
	
	@Autowired
	public ForgotPasswordController(UserService userService, EmailService emailService,
			ResetPasswordTokenService resetPasswordTokenService, EmailTool emailTool) {
		this.userService = userService;
		this.emailService = emailService;
		this.resetPasswordTokenService = resetPasswordTokenService;
		this.emailTool = emailTool;
	}

	// 給忘記密碼輸入Email
	@GetMapping("/forgotPassword")
	public String forgotPasswordSendEmail() {
		return "forgotPwdSendEmail";
	}
	
	// 寄重設密碼信
	@PostMapping(value = "/sendForgotPwdEmail", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String sendForgotPwdEmail (@RequestBody String email, HttpServletRequest request) {
		
		// 寄給誰
		String to = email; 
		
//		System.out.println(to);
		
		// 用輸入之Email 找忘記密碼之會員
		User forgotUser = userService.findByEmail(email);
		
		// 輸入之Email 無效
		if (forgotUser == null) {
			return "{\"forgetEmailResult\" : \"notFound\"}";
		}	
		
		// 取出今天的日期
		java.util.Date date = new java.util.Date();
		
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		List<ResetPasswordToken> tokens = 
				resetPasswordTokenService.findByUserIdAndDate(forgotUser.getId(), sqlDate);
		
		// 今日請求達到上限
		if (tokens.size() > 5) {
			return "{\"forgetEmailResult\" : \"requestsLimit\"}";
		}

		String filePath = ""; // 目前沒用(無附件)
		
		// Email 標題
		String subject = "Play-Fit Reset Password Email";
		
		// 忘記密碼用戶名
		String userName = forgotUser.getFullName();
		
		// 產生Token
		String resetToken = emailTool.generateResetPasswordToken();
		
		// 產生連結 (取請求路徑, 刪除Servlet路徑)
		String resetPasswordLink = 
				request.getRequestURL().toString().replace(request.getServletPath(), "") 
				+ "/resetPassword?token=" + resetToken;
		
//		System.out.println(resetPasswordLink);
		
		// 產生已格式化信件
		String text = emailTool.generateResetPasswordText(userName, resetPasswordLink);
				
		// 寄出
		try {
			emailService.sendRichMail(to, subject, text, filePath);
		} catch (MessagingException e) {
			System.out.println("寄出失敗");
			e.printStackTrace();
			return "{\"emailResult\" : \"tryLater\"}";
		}
		
		// 設定寄出時間(現在時間)
		Date sendTime = new Date();
		
		// 儲存更改 Token, 對照User
		ResetPasswordToken resetPasswordToken = new ResetPasswordToken();
		resetPasswordToken.setUser(forgotUser);
		resetPasswordToken.setResetToken(resetToken);
		resetPasswordToken.setMailCreate(sendTime);
		resetPasswordTokenService.saveResetPasswordToken(resetPasswordToken);
		
		return "{\"forgetEmailResult\" : \"sendSuccess\"}";
	}
	
}















