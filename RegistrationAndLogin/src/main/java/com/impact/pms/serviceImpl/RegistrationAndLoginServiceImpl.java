package com.impact.pms.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.pms.customException.EmployeeNotFoundInvalidLogin;
import com.impact.pms.entity.Employee;
import com.impact.pms.repository.RegistrationAndLoginRepository;
import com.impact.pms.service.RegistrationAndLoginService;

@Service
public class RegistrationAndLoginServiceImpl implements RegistrationAndLoginService{

	@Autowired
	private RegistrationAndLoginRepository repo;
	
	@Override
	public Employee validateLogin(String email, String password) {
		Optional<Employee> emp = repo.validateEmployee(email,password);
		
		if(emp.isEmpty()) {
			throw new EmployeeNotFoundInvalidLogin();
		}else {
			return emp.get();
		}
		
	}

}
