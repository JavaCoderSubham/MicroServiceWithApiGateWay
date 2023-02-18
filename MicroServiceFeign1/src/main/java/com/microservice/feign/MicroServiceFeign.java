package com.microservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.entity.College;

@FeignClient(value = "college1", url = "http://localhost:8081/college")
public interface MicroServiceFeign {

	@PostMapping("/create")
	public College createCollege(@RequestBody College college);
	
	@PostMapping("/create/all")
	public List<College> createListCollege(@RequestBody List<College> college);
	
	
	
	
}









