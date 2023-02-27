package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.Diagnosis;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

	@Query(value="Select count(*) from diagnosis where patient_id = :patient_id and appointment_id = :appointment_id ",nativeQuery = true)
	public int checIfDidExamination(Long appointment_id,Long patient_id);
}
