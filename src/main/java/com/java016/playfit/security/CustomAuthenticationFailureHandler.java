package com.java016.playfit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(
			HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		System.out.println(exception.getMessage());
		
		String errorMessage = exception.getMessage();
		
		// 密碼錯誤
		if (errorMessage.equals("使用者Email/密碼無效")) {
			response.sendRedirect("/login/failure?errorMessage=" + errorMessage);
		}
		
		// 尚未啟用
		if (errorMessage.equals("帳號尚未啟用")) {
			response.sendRedirect("/login/failure?errorMessage=" + errorMessage);
		}
		
	}
}
