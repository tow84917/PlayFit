package com.java016.playfit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.java016.playfit.security.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // old
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
    
    // 自訂驗證 *主要改驗證順序,先確認帳密再確認是否啟用
    @Bean
	public AuthenticationProvider customAuthenticationProvider(){
		AuthenticationProvider authenticationProvider = 
				new CustomAuthenticationProvider(
						userDetailsService(), passwordEncoder()
						);
		return authenticationProvider;
	}
    
    @Bean
    public CustomLogoutHandler customLogoutHandler() {
    	return new CustomLogoutHandler();
    }
    
    // 自訂失敗處理器
    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
    }
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider()); // old
		auth.authenticationProvider(customAuthenticationProvider()); //認證信後改
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/","/index", "/process_register" ,"/login/failure" ,"/process_avatar"
						, "/register","/**/*.js", "/**/*.css", "/**/*.svg","/payFinish").permitAll() // void not css、html 
//				.anyRequest().authenticated() // 除了上行請求皆須登入
				.antMatchers("/MemberPage","/calendar/**"
						, "/StartFit", "/pay", "/diary_homepage/**","/orderRecord").authenticated() // 特定請求須要登入
				.anyRequest().permitAll() // 其他不用
				.and()
				.formLogin()
				.usernameParameter("email")
				.loginPage("/login")
				.failureHandler(customAuthenticationFailureHandler()) //失敗處理,認證信後改
//				.failureUrl("/login?error=true") // 回傳有誤
				.defaultSuccessUrl("/MemberPage") // 回到首頁 或 跳轉原拜訪頁
				.permitAll()
				.and()
				.logout()																												
					.logoutUrl("/logout")
					//如果是用get請求訪問/logout的話必須s加以下這一行
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.clearAuthentication(true)
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.addLogoutHandler(customLogoutHandler())
//					.logoutSuccessUrl("/login") // 登出跳轉
					.permitAll()
				.and()
				.csrf()
				.ignoringAntMatchers("/ajax**","/payFinish", "/resetPassword"); // 防 ajax POST 會被 csrf 擋下 
				// 綠界結帳後跳轉的頁面會被擋下
//				.and()
//				.csrf().disable();
	}
	
}














