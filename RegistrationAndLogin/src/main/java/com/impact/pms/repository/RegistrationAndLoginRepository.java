package com.impact.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.impact.pms.entity.Employee;

@Repository
public interface RegistrationAndLoginRepository extends JpaRepository<Employee, Long> {

	@Query(value="Select * from employee where email=:email and password = :password",nativeQuery = true)
	public Optional<Employee> validateEmployee (String email, String password);
}
