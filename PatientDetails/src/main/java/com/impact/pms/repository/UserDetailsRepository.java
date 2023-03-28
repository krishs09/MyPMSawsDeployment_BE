package com.impact.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.impact.pms.model.UserPatient;

public interface UserDetailsRepository extends JpaRepository<UserPatient, Long> {

	@Query(value = "Select count(*) from tbl_user_pat t where t.firstname= :firstname and t.lastname=:lastname and t.email=:email",nativeQuery = true)
	public int checkIfPatientExists( String firstname, String lastname,String email);
}
