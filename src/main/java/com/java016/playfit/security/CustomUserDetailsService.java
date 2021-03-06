package com.java016.playfit.security;

import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	public CustomUserDetailsService() {
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException(email + "not found");
		} else {
			return new CustomUserDetails(user);
		}
	}

}
