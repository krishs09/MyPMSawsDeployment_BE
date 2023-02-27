package com.impact.pms.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDetailsRequest {

	private Long patientId;
	private Long appointmentId;
	private VitalSign vitalSign;
	private List<Diagnosis> diagnosis;
	private Medication medication;
	private Procedure procedure;
}
