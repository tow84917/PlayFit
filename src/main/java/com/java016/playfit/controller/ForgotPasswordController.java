package com.java016.playfit.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ForgotPasswordController {
	
	
	
	// 給忘記密碼輸入Email
	@GetMapping("/forgotPassword")
	public String forgotPasswordSendEmail() {
		return "forgotPwdSendEmail";
	}
	
	// 寄重設密碼信
	@PostMapping(value = "/sendForgotPwdEmail", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String sendForgotPwdEmail (@RequestBody String email) {
		
		
		System.out.println(email);
			
		
		return "{\"forgetEmailResult\" : \"sendSuccess\"}";
	}
	
}















