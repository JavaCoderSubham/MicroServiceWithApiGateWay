package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.College;

public interface CollegeRepository extends JpaRepository<College, String>{

}
