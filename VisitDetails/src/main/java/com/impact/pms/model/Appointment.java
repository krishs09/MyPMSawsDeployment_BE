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
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Long appointmentId;
	@Column(name="meeting_title")
	private String meetingTitle;
	@Column(name="patient_id")
	private Long patientId;
	@Column(name="examined_by")
	private Long examinedBy;
	@Column(name="did_examination_happened")
	private int didExaminationhappened;
	@Column(name="appointment_date",nullable = false,updatable = false)
	@CreationTimestamp
	private LocalDate appointmentDate;
	
}
