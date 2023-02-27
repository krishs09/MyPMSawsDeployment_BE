package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.Medication;
@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long>  {

}
