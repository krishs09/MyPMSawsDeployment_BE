package com.impact.pms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.impact.pms.model.DemographicDetailRequest;
import com.impact.pms.model.DemographicDetails;
import com.impact.pms.model.UserPatient;

@Service
public interface DemographicDetailsService {

	public UserPatient registerPatinet(UserPatient patinet);
	public DemographicDetails saveDmgDetail(DemographicDetailRequest request);
	public UserPatient getPatientDetails(Long id);
	public Optional<DemographicDetails> getDmgDetail(Long patId);
}
