package com.java016.playfit.security;

import com.java016.playfit.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//public class CustomUserDetails extends User implements UserDetails {
public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
//	private String fullName;
//    private String password;
//    private Integer id;
//    private List<GrantedAuthority> authorities;
    
    
    public CustomUserDetails(User user) {
        this.user = user;
    }
    
//    public CustomUserDetails(User user) {
//        this.fullName = user.getFullName();
//        this.password = user.getPassword();
//        this.id = user.getId();
//        String roles = user.getRole();
//        if (roles == null) {
//            roles = "ROLE_DEF";
//        }
//
//        this.authorities = (List) Arrays.stream(roles.split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.authorities;
    	
    	String roles = user.getRole();
	    if (roles == null) {
	    	roles = "ROLE_DEF";
	    }
    	
        return (List<? extends GrantedAuthority>) Arrays.stream(roles.split(","))
            	.map(SimpleGrantedAuthority::new)
            	.collect(Collectors.toList());
    }


    @Override
    public String getPassword() { // 用密碼
        return user.getPassword();
    }
    
    @Override
    public String getUsername() { // 用戶全名
        return user.getFullName();
    }
    
    @Override
    public boolean isAccountNonExpired() { // 帳號是否未過期
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() { // 用戶是否未被鎖
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() { // 憑證是否未過期
        return true;
    }
    
    @Override
    public boolean isEnabled() { // 用戶是否啟用
    	
		// 認證信用
		if (user.getCertificationStatus() == 0) {
			return false ;
		}
    	
        return true;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}




