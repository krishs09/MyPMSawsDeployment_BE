package com.impact.pms.service;

import org.springframework.stereotype.Service;

import com.impact.pms.entity.Employee;

@Service
public interface RegistrationAndLoginService {

	public Employee validateLogin(String email, String password); 
}
