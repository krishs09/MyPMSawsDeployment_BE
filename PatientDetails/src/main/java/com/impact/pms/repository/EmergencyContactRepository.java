package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.EmergencyContactInfo;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContactInfo, Long> {

}
