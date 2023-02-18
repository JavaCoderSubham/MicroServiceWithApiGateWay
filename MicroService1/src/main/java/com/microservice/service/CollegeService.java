package com.microservice.service;

import java.util.List;

import com.microservice.entity.College;

public interface CollegeService {

	College createCollege(College college);
	
	List<College> createListCollege(List<College> college);
	
}
