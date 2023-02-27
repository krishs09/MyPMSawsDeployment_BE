package com.impact.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impact.pms.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	String querry="select  vs.vital_sign_id,vs.blood_pressure,vs.body_temp,vs.height,vs.respiration_rate,vs.weight,"
			+ " d.diagnosis_id,d.diagnosis_code,d.diagnosis_descrp,"
			+ " m.medication_id,m.drug_brand,m.drug_form,m.drug_generic_name,m.drug_id,m.drug_name,m.drug_strength,"
			+ " pr.procedure_id,pr.procedure_code,pr.procedure_descrp,vs.blood_pressure_type "
			+ " from vital_sign vs"
			+ " join diagnosis d on d.patient_id = vs.patient_id "
			+ " join medication m on m.patient_id = vs.patient_id "
			+ " join tbl_procedure pr on pr.patient_id = vs.patient_id "
			+ " where vs.patient_id =1 and vs.appointment_id =1;";
	
	@Query(value=querry,nativeQuery = true)
	public List<Object[]> getPatientVisitDetails(Long patientId,Long appointmentId);
	
	@Query(value="select * from appointment where patient_id = 1 order by appointment_date asc",nativeQuery = true)
	public List<Appointment> getPatientsAppoinmentAll(Long patientId);
	
	@Transactional
	@Modifying
	@Query(value="Update appointment set did_examination_happened=1 where appointment_id=:aptId and patient_id=:patId",nativeQuery = true)
	public int updateExaminationColumn(Long aptId,Long patId);
}
