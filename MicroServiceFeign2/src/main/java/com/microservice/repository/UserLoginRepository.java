package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String>{

}
