package com.microservice.configuration.userdetailsservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.microservice.entity.UserLogin;
import com.microservice.repository.UserLoginRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserLoginUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserLoginRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername(String) -> | UserName : {}", username);
		Optional<UserLogin> user = repository.findById(username);
		
		return user.map(UserLoginUserDetails::new)
				.orElseThrow(()-> new UsernameNotFoundException("User Name Not Found Exception | UserName : " + username));
	}

}











