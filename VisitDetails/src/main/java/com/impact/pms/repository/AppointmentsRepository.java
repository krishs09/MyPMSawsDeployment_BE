package com.impact.pms.repository;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impact.pms.model.Appointments;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Long>{

	@Query(value="select * from appointments where appointment_with = :physicianId and active=1 order by appointment_date asc",nativeQuery = true)
	public List<Appointments> getAppoinmentForPhysician(Long physicianId);
	

	@Transactional
	@Modifying
	@Query(value="Update appointments set active = :status where appointment_id = :aptId ",nativeQuery = true)
	public int updateActiveStatus(int status, Long aptId);
	
	@Query(value="select appointment_time from appointments where appointment_date = :date",nativeQuery = true)
	public List<Time> getBookedTimeSlots(String date);
}
