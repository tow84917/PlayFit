package com.java016.playfit.security;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final UserDetailsService userDetailsService;
	
	// 密碼驗證器
	private BCryptPasswordEncoder passwordEncoder;

	public CustomAuthenticationProvider(UserDetailsService userDetailsService, 
			BCryptPasswordEncoder passwordEncoder) {
		super();
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) {

		UsernamePasswordAuthenticationToken token = 
				(UsernamePasswordAuthenticationToken) authentication;

		String email = token.getName();

		// 從資料庫找到的使用者
		UserDetails userDetails = null;
		if (email != null) {
			userDetails = userDetailsService.loadUserByUsername(email);
		}
		
		//--------------------------------------
		// 原始檢查密碼在檢查其他項目之後,改變順序邏輯,先查密碼再檢查是否啟用(其他認證項目)
		
		// 檢查使用者的密碼 = 資料庫內密碼
		String password = userDetails.getPassword();
		// 與authentication裡面的credentials相比較 = 輸入之明碼
		String plaintext = (String) token.getCredentials();
		
		// 比對密碼
		boolean comparePassword = 
				passwordEncoder.matches(plaintext, password);
		
		// 密碼錯誤
		if (!comparePassword) {
			throw new BadCredentialsException("使用者Email/密碼無效");
		}

		// 檢查其他認證
		if (!userDetails.isEnabled()) {
			throw new DisabledException("帳號尚未啟用");
		} else if (!userDetails.isAccountNonExpired()) {
			throw new AccountExpiredException("帳號已過期");
		} else if (!userDetails.isAccountNonLocked()) {
			throw new LockedException("帳號已被鎖定");
		} else if (!userDetails.isCredentialsNonExpired()) {
			throw new LockedException("憑證已過期");
		}
		//--------------------------------------
		
		// 授權
		return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}
}









