package com.microservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.entity.College;

@FeignClient(value = "college2", url = "http://localhost:8082/college")
public interface FeignMicroService {

	@GetMapping("/all")
	public List<College> getAll();

	@PutMapping("/update/{id}")
	public College updateCollege(@PathVariable String id, @RequestBody College college);

}







