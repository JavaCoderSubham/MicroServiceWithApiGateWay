package com.microservice.service;

import java.util.List;

import com.microservice.entity.College;

public interface CollegeService {
	
	List<College> getAll();

	College updateCollege(String id, College college);
	
}
