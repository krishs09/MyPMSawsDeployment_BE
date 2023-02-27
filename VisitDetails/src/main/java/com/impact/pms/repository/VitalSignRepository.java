package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.VitalSign;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {

}
