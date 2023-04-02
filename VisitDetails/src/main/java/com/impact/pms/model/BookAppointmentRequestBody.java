package com.impact.pms.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class BookAppointmentRequestBody {

		private int isExistingPatient;
	    private Long patientId;
	   private String firstname;
	    private String lastname;
	    private String email;
	   private String mobile;
	   private String gender;
	   private LocalDate appointmentDate;
	   private LocalTime appointmentTime;
	   private String meetingTtile;
	   private Long appointment_with;
	
}
