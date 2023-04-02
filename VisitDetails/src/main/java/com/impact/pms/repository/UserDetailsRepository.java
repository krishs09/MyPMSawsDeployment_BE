package com.impact.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.impact.pms.model.UserPatient;

public interface UserDetailsRepository extends JpaRepository<UserPatient, Long> {

	@Query(value = "Select * from tbl_user_pat t where t.firstname= :firstname and t.mobile=:mobile and t.gender=:gender",nativeQuery = true)
	public Optional<UserPatient> findExistingUser( String firstname, String mobile,String gender);
}
