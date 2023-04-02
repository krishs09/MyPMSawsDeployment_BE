package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
