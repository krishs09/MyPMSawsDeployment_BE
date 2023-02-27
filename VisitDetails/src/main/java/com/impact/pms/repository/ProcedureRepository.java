package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.Procedure;
@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long>{

}
