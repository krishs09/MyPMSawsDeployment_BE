package com.impact.pms.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VisitDetailsResponse {

	private Long patientId;
	private Long appointmentId;
	private VitalSign vitalSign;
	private List<Diagnosis> diagnosis;
	private Medication medication;
	private Procedure procedure;
	
}
