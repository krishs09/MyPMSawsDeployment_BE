package com.impact.pms.model;

import java.time.LocalDate;
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
@Table(name="tbl_procedure")
public class Procedure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="procedure_id")
	private Long procedureId;
	@Column(name="procedure_code")
	private String procedureCode;
	@Column(name="procedure_descrp")
	private String description;
	@Column(name="is_depricated")
	private boolean isDepricated;
	@Column(name="patient_id")
	private Long patientId;
	@Column(name="appointment_id")
	private Long appointmentId;
	@Column(name="created_at",nullable = false,updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
}
