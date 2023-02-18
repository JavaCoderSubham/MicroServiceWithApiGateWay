package com.microservice.service;

import java.util.List;

import com.microservice.entity.College;

public interface MicroServiceCollege {

	List<College> getAll();
	
	List<College> createCollege(List<College> list);
	
	College createSingleCollege(College college);
	
	College updateCollege(String id, College college);
	
}
