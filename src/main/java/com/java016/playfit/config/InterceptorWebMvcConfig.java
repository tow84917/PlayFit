package com.java016.playfit.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.java016.playfit.tool.IsEnableInterceptor;

@Configuration
public class InterceptorWebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	IsEnableInterceptor isEnableInterceptor ;
	
	// 自定義檢查是否啟用攔截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 路徑 
		List<String> path = new LinkedList<String>();
		path.add("/MemberPage");
		path.add("/calendar/calendar");
		path.add("/StartFit");
		path.add("/diary_homepage/**");
		path.add("/pay");
		
		registry.addInterceptor(isEnableInterceptor)
		.addPathPatterns(path); 
	}
	
	
}















