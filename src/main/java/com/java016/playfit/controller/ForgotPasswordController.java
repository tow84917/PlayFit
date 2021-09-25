package com.java016.playfit.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.java016.playfit.model.ResetPasswordToken;
import com.java016.playfit.model.User;
import com.java016.playfit.service.EmailService;
import com.java016.playfit.service.ResetPasswordTokenService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.EmailTool;

@Controller
@SessionAttributes(Constants.KAPTCHA_SESSION_KEY) // default "KAPTCHA_SESSION_KEY"
public class ForgotPasswordController {
	
	UserService userService;
	
	EmailService emailService;
	
	ResetPasswordTokenService resetPasswordTokenService;
	
	EmailTool emailTool;
	
	BCryptPasswordEncoder passwordEncoder;
	
    DefaultKaptcha defaultKaptcha;
	
	@Autowired
	public ForgotPasswordController(
			UserService userService, EmailService emailService,
			ResetPasswordTokenService resetPasswordTokenService, 
			EmailTool emailTool, BCryptPasswordEncoder passwordEncoder, 
			DefaultKaptcha defaultKaptcha
			) {
		this.userService = userService;
		this.emailService = emailService;
		this.resetPasswordTokenService = resetPasswordTokenService;
		this.emailTool = emailTool;
		this.passwordEncoder = passwordEncoder;
		this.defaultKaptcha = defaultKaptcha;
	}

	// 給忘記密碼輸入Email
	@GetMapping("/forgotPassword")
	public String forgotPasswordSendEmail() {
		return "forgotPwdSendEmail";
	}

	// 給驗證碼圖片
	@GetMapping("/getCaptchaImage")
	public void getCaptchaImage(
			HttpServletRequest request, HttpServletResponse response, Model model) {
		
		// 建立驗證碼文本(驗證碼)
        String capText = defaultKaptcha.createText();
        // 建立驗證碼圖片
        BufferedImage image = defaultKaptcha.createImage(capText);
        
        System.out.println(capText);
        
        // Session 存驗證碼
        model.addAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        // return 驗證碼圖片 ，禁止驗證碼圖片緩存(避免抓到舊的)
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        
        // 寫出
        try {
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	
	}

	// 寄重設密碼信
	@PostMapping(value = "/sendForgotPwdEmail", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String sendForgotPwdEmail (
			@RequestBody Map<String, String> sendForgotPwdEmailInfo,
			HttpServletRequest request, Model model, SessionStatus status) {
		
		String email = sendForgotPwdEmailInfo.get("inputEmail");
		String captcha = sendForgotPwdEmailInfo.get("inputCaptcha");
		String sessionCaptcha = 
				String.valueOf(model.getAttribute(Constants.KAPTCHA_SESSION_KEY));
		
		// 驗證碼錯誤或失效
		if (sessionCaptcha == null || !captcha.equalsIgnoreCase(sessionCaptcha)) {
			return "{\"forgetEmailResult\" : \"captchaInvaild\"}";
		}
		
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
		
		// 寄出成功移除驗證碼 SessionAttributes
		status.setComplete();
		
		return "{\"forgetEmailResult\" : \"sendSuccess\"}";
	}
	
	// 給改密碼頁面
	@GetMapping("/resetPassword")
	public String resetPasswordPage(@RequestParam("token") String token, Model model) {
		
		// 找token
		ResetPasswordToken resetPasswordToken = 
				resetPasswordTokenService.findByResetToken(token);
		
		// 檢查該連結是否已使用過
		boolean isUsed = false;
		if (resetPasswordToken.getMailModify() != null) {
			isUsed = true;
		}
		
		// 檢查是否過期(24hr)
		boolean isExpired = false;
		
		int dayMillis = 86400000;
		// 取過期時間
		Date createDate = resetPasswordToken.getMailCreate();
		Date ExpiredDate = new Date(createDate.getTime() + dayMillis);
		
		// 現在時間
		Date now = new Date();
		
		// 比較
		if (now.after(ExpiredDate)) {
			isExpired = true;
		}
		
		// token 已失效 (ScheduledTasks 定期刪除, 已經使用過, over 24hr)
		// 有效則傳遞給前端,processResetPassword 接回
		if (resetPasswordToken != null && !isUsed && !isExpired) {
			model.addAttribute("token", token);
		}
		
		return "forgotPwdReset" ;
	}
	
	// 處理修改密碼
	@PostMapping("/resetPassword")
	@ResponseBody
	public String processResetPassword(
			@RequestBody Map<String, String> resetPasswordInfo) {
		
		String token = resetPasswordInfo.get("token");
		String newPwd = resetPasswordInfo.get("newPwd");
		String confimPwd = resetPasswordInfo.get("confimPwd");
		
		// 找token
		ResetPasswordToken resetPasswordToken = 
				resetPasswordTokenService.findByResetToken(token);
		
		String originPwd = resetPasswordToken.getUser().getPassword();
		
		// 密碼最少7位
		if (newPwd.length() < 7) {
			return "{\"resetPasswordResult\" : \"passwordSizeError\"}";
		}

		// 輸入密碼與再次確認密碼不符
		if (!(newPwd.equals(confimPwd))) {
			return "{\"resetPasswordResult\" : \"confimPwdError\"}";
		}
				
		// 新舊密碼相同(提醒不需要改)
		if (passwordEncoder.matches(newPwd, originPwd)) {
			return "{\"resetPasswordResult\" : \"isOriginPassword\"}";
		}	
		
		// 更新密碼
		userService.updateUserPassword(resetPasswordToken.getUser().getId(), newPwd);
		
		// 儲存已使用
		Date useTime = new Date();
		resetPasswordToken.setMailModify(useTime);
		resetPasswordTokenService.saveResetPasswordToken(resetPasswordToken);
		
		return "{\"resetPasswordResult\" : \"resetPasswordSuccess\"}";
	}
	
	
}










