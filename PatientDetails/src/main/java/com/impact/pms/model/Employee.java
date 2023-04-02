package com.impact.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long employeeId;
	@Column(name="employee_name")
	private String employeeName;
	@Column(name="roles")
	private String role;
	@Column(name="gender")
	private String gender;
	
}
