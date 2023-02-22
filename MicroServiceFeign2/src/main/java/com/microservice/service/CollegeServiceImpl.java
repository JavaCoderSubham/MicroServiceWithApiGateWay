package com.microservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.feign.FeignMicroService;

@Service
public class CollegeServiceImpl implements CollegeService {
	
	@Autowired
	private FeignMicroService feign;
	
	private final Logger log = LoggerFactory.getLogger(CollegeServiceImpl.class);

	@Override
	public String deleteSingle(String id) {
		log.info("deleteSingle(String) -> | id : {}",id);
		String deleteSingleCollege = feign.deleteSingleCollege(id);
		log.info("deleteSingle(String) -> | Message : {}",deleteSingleCollege);
		return deleteSingleCollege;
	}

	@Override
	public String deleteAll() {
		log.info("deleteAll() -> | ");
		String deleteAll = feign.deleteAll();
		log.info("deleteAll() -> | Message : {}",deleteAll);
		return deleteAll;
	}

}
