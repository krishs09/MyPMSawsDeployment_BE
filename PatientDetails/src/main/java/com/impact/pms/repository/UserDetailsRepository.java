package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impact.pms.model.UserPatient;

public interface UserDetailsRepository extends JpaRepository<UserPatient, Long> {

	
}
