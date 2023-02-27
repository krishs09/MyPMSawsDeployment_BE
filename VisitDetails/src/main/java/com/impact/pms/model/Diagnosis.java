package com.impact.pms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="diagnosis")
public class Diagnosis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="diagnosis_id")
	private Long diagnosisId;
	@Column(name="patient_id")
	private Long patientId;
	@Column(name="diagnosis_code")
	private String diagnosisCode;
	@Column(name="diagnosis_descrp")
	private String description;
	@Column(name="is_depricated")
	private boolean isDepricated;
	@Column(name="appointment_id")
	private Long appointmentId;
	@Column(name="created_At",nullable = false,updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
}
