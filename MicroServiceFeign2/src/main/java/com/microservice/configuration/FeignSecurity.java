package com.microservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.microservice.configuration.userdetailsservice.UserLoginUserDetailsService;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class FeignSecurity {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/feign2/delete/**")
					.authenticated()
					.and()
					
					.authorizeHttpRequests()
					.requestMatchers("/feign2/delete/id/**")
					.hasAnyRole("ADMIN")
					.and()
					
					.authorizeHttpRequests()
					.requestMatchers("/feign2/delete/all")
					.hasAnyRole("SUPER_ADMIN")
					.and()
					
					.httpBasic()
					.and()
					
					.logout()
					.and()
					
					.build();
					
					
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserLoginUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.userDetailsService());
		provider.setPasswordEncoder(this.passwordEncoder());
		
		return provider;
	}
	
}















