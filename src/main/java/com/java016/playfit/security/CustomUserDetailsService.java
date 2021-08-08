package com.java016.playfit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User member = userRepository.findByEmail(email);
		
		if(member == null) {
			throw new UsernameNotFoundException(email + "not found");
		}
		
		return new CustomUserDetails(member);
	}

}
