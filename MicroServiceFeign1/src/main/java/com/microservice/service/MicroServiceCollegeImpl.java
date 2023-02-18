package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.College;
import com.microservice.feign.FeignMicroService;
import com.microservice.feign.MicroServiceFeign;

@Service
public class MicroServiceCollegeImpl implements MicroServiceCollege{

	@Autowired
	private FeignMicroService feign1;
	
	@Autowired
	private MicroServiceFeign feign2;
	
	
	@Override
	public List<College> getAll() {
		return feign1.getAll();
	}

	@Override
	public List<College> createCollege(List<College> list) {
		return feign2.createListCollege(list);
	}

	@Override
	public College createSingleCollege(College college) {
		return feign2.createCollege(college);
	}

	@Override
	public College updateCollege(String id, College college) {
		return feign1.updateCollege(id, college);
	}
	
	
	

}














