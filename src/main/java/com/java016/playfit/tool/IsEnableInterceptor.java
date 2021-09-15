package com.java016.playfit.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.security.CustomUserDetails;

@Component
public class IsEnableInterceptor implements HandlerInterceptor {
	
	// request 到 Controller 前
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("Controller前, 檢查是否啟用");
		
		boolean isEnable = false;
		
		// 取 Security authentication
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUserDetails = 
				(CustomUserDetails) authentication.getPrincipal();
		// 確認是否啟用
		if (customUserDetails != null) {
			isEnable = customUserDetails.isEnabled();
		}
		
		if (isEnable == false) {
			// 無 ContextPath, certificationEmail 前不加 /
//			response.sendRedirect(request.getContextPath() 
//					+ "certificationEmail"); 
			response.sendRedirect("/certificationEmail"); 
		}
		
		return isEnable ;
	}
	
	// Controller 處理完後執行
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("---此帳號已經啟用---");
		
	}
	
	// 整個請求及回應結束後執行
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("---請求及回應結束---");
		
	}
	
	
}













