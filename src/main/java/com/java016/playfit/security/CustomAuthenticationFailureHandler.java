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
		
//		System.out.println(exception.getMessage());
		
		String errorMessage = exception.getMessage();
		
		// 帳號錯誤
		if (errorMessage.equals("rgrdsgdfhgnot found")) {
			response.sendRedirect("/login/failure?errorMessage=" + errorMessage);
		}
		
		// 密碼錯誤
		if (errorMessage.equals("Bad credentials")) {
			response.sendRedirect("/login/failure?errorMessage=" + errorMessage);
		}
		
		// 尚未啟用 (改由登入後自行處理)
//		if (errorMessage.equals("Disabled")) {
//			response.sendRedirect("/login/failure?errorMessage=" + errorMessage);
//		}
		
		// 失敗處理,認證信後 前端需要字樣
//		<!--         <div th:if="${isEnabled}"> -->
//		<!--  			Account has not been activated.        -->
//		<!--         </div> -->
//		        
//		<!--         <div th:if="${error}"> -->
//		<!--             Invalid username and password. -->
//		<!--         </div> -->
	}
}
