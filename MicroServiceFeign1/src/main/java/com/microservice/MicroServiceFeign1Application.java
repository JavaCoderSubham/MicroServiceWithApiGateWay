package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroServiceFeign1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceFeign1Application.class, args);
	}

}














