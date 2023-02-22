package com.microservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final Logger log = LoggerFactory.getLogger(MicroServiceCollegeImpl.class);
	
	
	@Override
	public List<College> getAll() {
		log.info("getAll() -> | ");
		List<College> all = feign1.getAll();
		log.info("getAll() -> | College List : {}",all);
		return all;
	}

	@Override
	public List<College> createCollege(List<College> list) {
		log.info("createCollege(List<College>) -> | List : {}",list);
		List<College> createListCollege = feign2.createListCollege(list);
		log.info("createCollege(List<College>) -> | College List : {}",createListCollege);
		return createListCollege;
	}

	@Override
	public College createSingleCollege(College college) {
		log.info("createSingleCollege(College) -> | College : {}",college);
		College createCollege = feign2.createCollege(college);
		log.info("createSingleCollege(College) -> | College : {}",createCollege);
		return createCollege;
	}

	@Override
	public College updateCollege(String id, College college) {
		log.info("updateCollege(String,College) -> | Id : {} | College : {}",id,college);
		College updateCollege = feign1.updateCollege(id, college);
		log.info("updateCollege(String,College) -> | College : {}",updateCollege);
		return updateCollege;
	}
	
	
	

}














