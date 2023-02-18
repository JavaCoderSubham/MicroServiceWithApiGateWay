package com.microservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "Feign1", url = "http://localhost:8083/college")
public interface FeignMicroService {
	
	@DeleteMapping("/delete/{id}")
	public String deleteSingleCollege(@PathVariable String id);
	
	@DeleteMapping("/delete")
	public String deleteAll();
	
}















