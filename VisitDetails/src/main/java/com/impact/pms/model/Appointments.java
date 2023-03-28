package com.impact.pms.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name="appointments")
public class Appointments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Long appointmentId;
	@Column(name="meeting_title")
	private String meetingTitle;
	@Column(name="patient_id")
	private Long patientId;
	@Column(name="appointment_with")
	private Long appointment_with;
	@Column(name="appointment_date",nullable = false,updatable = false)
	private LocalDate appointmentDate;
	@Column(name="appointment_time",nullable = false,updatable = false)
	private LocalTime appointmentTime;
	@Column(name="active")
	private int active=1;
	
}
