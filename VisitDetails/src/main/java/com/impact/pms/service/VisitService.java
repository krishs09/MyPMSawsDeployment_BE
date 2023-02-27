package com.impact.pms.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.impact.pms.model.Appointment;
import com.impact.pms.model.MasterDataResponse;
import com.impact.pms.model.VisitDetailsRequest;
import com.impact.pms.model.VisitDetailsResponse;

@Service
public interface VisitService {

	public VisitDetailsRequest saveVisitDetails(VisitDetailsRequest request);
	public Appointment getAppointmentDetails(Long patientId);
	public VisitDetailsResponse getVisitDetails(Long patientId,Long appointmentId);
	public MasterDataResponse getMasterData();
	public List<Appointment> getPatientsAppoinmentAll(Long patientId);
}
