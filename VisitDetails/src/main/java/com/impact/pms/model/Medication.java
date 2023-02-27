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
@Table(name="medication")
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medication_id")
	private Long medicationId;
	@Column(name="patient_id")
	private Long patientId;
	@Column(name="drug_id")
	private Long drugId;
	@Column(name="drug_name")
	private String drugName;
	@Column(name="drug_generic_name")
	private String drugGenericName;
	@Column(name="drug_brand")
	private String drugBrand;
	@Column(name="drug_form")
	private String drugForm;
	@Column(name="drug_strength")
	private String drugStrength;
	@Column(name="appointment_id")
	private Long appointmentId;
	@Column(name="created_at",nullable = false,updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
}
