package com.java016.playfit.controller;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java016.playfit.model.User;
import com.java016.playfit.service.EmailService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.EmailTool;

@RestController
@SessionAttributes(
		value = {"checkingUser", "verificationCode", "sendTime"} // 接收User回應確認用 
		) 
public class CertificationEmailController {
	
	UserService userService;
	
	EmailService emailService;
	
	EmailTool emailTool;
	
	BCryptPasswordEncoder passwordEncoder ;
	
	@Autowired
	public CertificationEmailController(
			UserService userService, EmailService emailService, 
			EmailTool emailTool, BCryptPasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.emailService = emailService;
		this.emailTool = emailTool;
		this.passwordEncoder = passwordEncoder;
	}

	// 寄認證信
	@RequestMapping("/sendEmail")
	public String sendEmialTest(
			Model model
			) throws MessagingException {
		
		String filePath = ""; // 目前沒用(無附件)
		// 接收Email參數, 等前段請求待定
		String to = "hcy0930527919@gmail.com"; 
		String subject = "test";
		
//		User checkingUser = userService.findByEmail(to);
		
//		if (checkingUser == null) {
//			return "Send faild";
//		}
		
		// 驗證中USER加入session
//		model.addAttribute("checkingUser", checkingUser);
		
		// 新用戶名、未認證用戶名
//		String userName = checkingUser.getFullName(); // 先寫死 
		String userName = "FrankHsiao"; // 先寫死 
		
		// 驗證碼(加密)
		String verificationCode = passwordEncoder.encode(emailTool.generateVerCode()); 
		// 驗證碼加入session
		model.addAttribute("verificationCode", verificationCode);
		
		// 產生已格式化信件
		String text = emailTool.generateText(userName, verificationCode);
		// 寄出
		emailService.sendRichMail(to, subject, text, filePath);
		
		// 設定寄出時間
		Date sendTime = new Date();
		// 寄出時間加入session
		model.addAttribute("sendTime", sendTime);
		
		System.out.println(sendTime);
				
		return "Send success";
	}
	
	// 接收 User 連結回應 
	@GetMapping("/verificationCode")
	public String activateAccount(
			@RequestParam("code") String code,
			Model model
		) {
		
		String returnMessage = ""; 
		
		System.out.println(code); // 驗證碼
		
		// 現在時間
		Date now = new Date();
		// 寄出時間
		Date sendTime = (Date) model.getAttribute("sendTime");
		
		// 超過5分鐘(4:59)測試
		if (emailTool.getMinute(sendTime, now) > 4) {
			System.out.println("驗證碼已失效");
			returnMessage = "ActivateFaild";
		}
		
		// 驗證碼
		String verificationCode = String.valueOf(model.getAttribute("verificationCode"));
		// 驗證中的使用者
//		User checkingUser = (User) model.getAttribute("checkingUser");
		
		if (code.equals(verificationCode)) {
			
			// 驗證驗證成功改為啟用
//			userService.updateUserCertificationStatus(checkingUser.getId(), 1);
			
			System.out.println("Activate success!");
			
			returnMessage = "ActivateSuccess";
		}
		
		return returnMessage;
	}
}

















