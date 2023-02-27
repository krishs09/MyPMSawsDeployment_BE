package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.pms.model.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {

}
