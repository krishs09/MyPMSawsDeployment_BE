package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.DiagnosisMaster;
import com.impact.pms.model.ProcedureMaster;

@Repository
public interface MasterProcedureRepository  extends JpaRepository<ProcedureMaster, Long>  {

}
