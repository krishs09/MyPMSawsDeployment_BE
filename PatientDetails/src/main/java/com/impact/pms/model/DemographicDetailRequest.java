package com.impact.pms.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DemographicDetailRequest {

	private Long patientId;
	private DemographicDetails demographicDetails;
	private EmergencyContactInfo emergencyContact;
	private List<Allergy> allergy;
	
}
