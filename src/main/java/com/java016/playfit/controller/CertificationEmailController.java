package com.java016.playfit.controller;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.java016.playfit.model.User;
import com.java016.playfit.security.CustomUserDetails;
import com.java016.playfit.service.EmailService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.EmailTool;

@RestController
@SessionAttributes(
		value = {"newMember","checkingUser", "verificationCode", "sendTime"} // 接收User回應確認用 
		) 
public class CertificationEmailController {
	
	UserService userService;
	
	EmailService emailService;
	
	EmailTool emailTool;
	
	@Autowired
	public CertificationEmailController(
			UserService userService, EmailService emailService, 
			EmailTool emailTool) {
		this.userService = userService;
		this.emailService = emailService;
		this.emailTool = emailTool;
	}

	/**
	 * 寄認證信
	 * @param model
	 * @return CertificationEmail
	 * @throws MessagingException
	 */
	@GetMapping(value = "/sendCertificationEmail", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendEmialTest(
			Model model
			) {
		
		// 設定寄出時間(現在時間)
		Date sendTime = new Date();
		
		// 2:59 內不會發出下一封
		if (model.getAttribute("sendTime") != null && 
				emailTool.getMinute((Date)model.getAttribute("sendTime"), sendTime) < 2) {
			return "{\"emailResult\" : \"alreadySent\"}";
		}
		
		String filePath = ""; // 目前沒用(無附件)
		
		// 寄給誰
		String to = ""; 
		
		//驗證中User
		User checkingUser = null ;
		
		// For 新註冊的 user
		if (model.getAttribute("newMember") != null) {
			// 取已經儲存之User
			checkingUser = userService.findByEmail(
					((User)model.getAttribute("newMember")).getEmail()
					);
			
			// 儲存目前驗證中User
			model.addAttribute("checkingUser", checkingUser);			
			// 寄信對象
			to = checkingUser.getEmail();
		}
		
		// For 一開始未認證的 user
		if (model.getAttribute("newMember") == null) {
			// 目前登入者 + Id
			int userId = userService.getLoginUserId();
			checkingUser = userService.getUserById(userId);
			
			// 儲存目前驗證中User
			model.addAttribute("checkingUser", checkingUser);
			// 寄信對象
			to = checkingUser.getEmail();
			
			
		}
		
		// Email 標題
		String subject = "Play-Fit Certification Email";
		
		// 新用戶名、未認證用戶名
		String userName = checkingUser.getFullName();
		
		// 驗證碼
		String verificationCode = (emailTool.generateVerCode()); 
		// 驗證碼加入session
		model.addAttribute("verificationCode", verificationCode);
		System.out.println("session code :" + verificationCode);
		
		// 產生已格式化信件
		String text = emailTool.generateCertificationText(userName, verificationCode);
		
		// 寄出
		try {
			emailService.sendRichMail(to, subject, text, filePath);
		} catch (MessagingException e) {
			System.out.println("寄出失敗");
			e.printStackTrace();
			return "{\"emailResult\" : \"tryLater\"}";
		}
		
		// 寄出時間加入session
		model.addAttribute("sendTime", sendTime);
		
//		System.out.println(sendTime);
		return "{\"emailResult\" : \"sendSuccess\"}"; // 字串JSON
	}
	
	/**
	 * 接收 User 回應 
	 * @param verificationCode
	 * @param model
	 * @param status
	 * @return 驗證結果
	 */
	@PostMapping(value = "/activateAccount", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String activateAccount(
			@RequestBody String verificationCode,
			Model model, SessionStatus status
		) {
		
		System.out.println(verificationCode); // 驗證碼
		
		// 現在時間
		Date now = new Date();
		// 寄出時間
		Date sendTime = (Date) model.getAttribute("sendTime");
		
		// 超過5分鐘(4:59)測試
		if (emailTool.getMinute(sendTime, now) > 4) {
			System.out.println("驗證碼已失效");
			return "{\"emailResult\" : \"verificationCodeExpired\"}";
		}
		
		// 驗證碼
		String verificationCodeOrigin = String.valueOf(model.getAttribute("verificationCode"));
		
		// 取驗證中的使用者
		User checkingUser = (User) model.getAttribute("checkingUser");
		
		if (verificationCode.equals(verificationCodeOrigin)) {
			
			// 驗證驗證成功改為啟用
			userService.updateUserCertificationStatus(checkingUser.getId(), 1);
			
			System.out.println("Activate success!");
			
			// 取經經被更新後的 User
			User userUpdated = userService.findByEmail(checkingUser.getEmail());
			
			// 新 UserDetails 給 authentication 
			CustomUserDetails customUserDetails = new CustomUserDetails(userUpdated);
			
			// 新增 authentication 
			Authentication authentication = 
					new UsernamePasswordAuthenticationToken
					(customUserDetails, customUserDetails.getPassword(), 
							customUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			// 啟用成功移除 Controller上指定 SessionAttributes
			status.setComplete();
			
			return "{\"emailResult\" : \"activateSuccess\"}";
		}
		
		return "{\"emailResult\" : \"verificationCodeFalse\"}";
	}
}

















