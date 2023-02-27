package com.impact.pms.service;

import org.springframework.stereotype.Service;

import com.impact.pms.model.DemographicDetailRequest;
import com.impact.pms.model.DemographicDetails;
import com.impact.pms.model.UserPatient;

@Service
public interface DemographicDetailsService {

	public DemographicDetails saveDmgDetail(DemographicDetailRequest request);
	public UserPatient getPatientDetails(Long id);
	public DemographicDetails getDmgDetail(Long patId);
}
