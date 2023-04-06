package com.impact.pms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impact.pms.entity.Employee;
import com.impact.pms.service.RegistrationAndLoginService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationAndLoginController {

	@Autowired
	private RegistrationAndLoginService service;
	
	@GetMapping("/validateLoginCredentials")
	public ResponseEntity<Employee> getPatientDemographicDetails(@RequestParam String email, @RequestParam String password ){
		
		Employee emp = service.validateLogin(email, password);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
}
