package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.CollegeTracker;

public interface CollegeTrackerRepository extends JpaRepository<CollegeTracker, String> {

}
