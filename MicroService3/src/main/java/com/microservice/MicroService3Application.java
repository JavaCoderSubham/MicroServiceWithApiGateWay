package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class MicroService3Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService3Application.class, args);
	}

	
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
	
}
