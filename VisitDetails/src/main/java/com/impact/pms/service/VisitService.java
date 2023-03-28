package com.impact.pms.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.impact.pms.model.AppointmentHistory;
import com.impact.pms.model.Appointments;
import com.impact.pms.model.MasterDataResponse;
import com.impact.pms.model.VisitDetailsRequest;
import com.impact.pms.model.VisitDetailsResponse;

@Service
public interface VisitService {

	public VisitDetailsRequest saveVisitDetails(VisitDetailsRequest request);
	public AppointmentHistory getAppointmentDetails(Long appointmentId);
	public VisitDetailsResponse getVisitDetails(Long patientId,Long appointmentId);
	public MasterDataResponse getMasterData();
	public List<AppointmentHistory> getPatientsAppoinmentAll(Long patientId);
	public List<Appointments> getAppoinmentsForPhysician(Long physicianId);
	public String updateAppointmentForOnlyConsultation(Long patientId,Long appointmentId);
}
