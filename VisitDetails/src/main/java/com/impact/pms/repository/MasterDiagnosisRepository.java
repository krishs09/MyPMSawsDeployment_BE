package com.impact.pms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.DiagnosisMaster;

@Repository
public interface MasterDiagnosisRepository extends JpaRepository<DiagnosisMaster, Long> {

}
