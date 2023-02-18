package com.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.feign.FeignMicroService;

@Service
public class CollegeServiceImpl implements CollegeService {
	
	@Autowired
	private FeignMicroService feign;

	@Override
	public String deleteSingle(String id) {
		return feign.deleteSingleCollege(id);
	}

	@Override
	public String deleteAll() {
		return feign.deleteAll();
	}

}
