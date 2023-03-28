package com.impact.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impact.pms.model.DemographicDetails;

@Repository
public interface DemographicRepository extends JpaRepository<DemographicDetails, Long>{

	@Query(value = "Select * from patient_demographic_details p where p.patient_id= :id",nativeQuery = true)
	public Optional<DemographicDetails> findByPatientId(Long id);
	
	@Modifying
	@Transactional
	@Query(value="Update patient_demographic_details set emergency_contact_id = :emgContactId where demographic_id = :demogId", nativeQuery = true)
	public int mapEmergencyContactInfo(Long emgContactId,Long demogId);
	
}
