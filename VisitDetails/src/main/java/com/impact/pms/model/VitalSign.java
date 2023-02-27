package com.impact.pms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vital_sign")
public class VitalSign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vital_sign_id")
	private Long vitalSignId;
	@Column(name="patient_id")
	private Long patientId;
	@Column(name="height")
	private double height;
	@Column(name="weight")
	private double weight;
	@Column(name="blood_pressure")
	private String bloodPressure;
	@Column(name="blood_pressure_type")
	private String bloodPressureType;
	@Column(name="body_temp")
	private double bodyTemp;
	@Column(name="respiration_rate")
	private int respirationRate;
	@Column(name="appointment_id")
	private Long appointmentId;
	
}
