package com.impact.pms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.impact.pms.model.Appointment;
import com.impact.pms.model.Diagnosis;
import com.impact.pms.model.DiagnosisMaster;
import com.impact.pms.model.MasterDataResponse;
import com.impact.pms.model.Medication;
import com.impact.pms.model.MedicationMaster;
import com.impact.pms.model.Procedure;
import com.impact.pms.model.ProcedureMaster;
import com.impact.pms.model.VisitDetailsRequest;
import com.impact.pms.model.VisitDetailsResponse;
import com.impact.pms.model.VitalSign;
import com.impact.pms.repository.AppointmentRepository;
import com.impact.pms.repository.DiagnosisRepository;
import com.impact.pms.repository.MasterDiagnosisRepository;
import com.impact.pms.repository.MasterMedicationRepository;
import com.impact.pms.repository.MasterProcedureRepository;
import com.impact.pms.repository.MedicationRepository;
import com.impact.pms.repository.ProcedureRepository;
import com.impact.pms.repository.VitalSignRepository;
import com.impact.pms.service.VisitService;

@Service
public class VisitServiceImpl implements VisitService{
	
	@Autowired
	VitalSignRepository vitalSignRepo;
	
	@Autowired
	DiagnosisRepository diagnosisRepo;
	
	@Autowired
	ProcedureRepository procedureRepo;
	
	@Autowired
	MedicationRepository medRepo;
	
	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Autowired
	MasterDiagnosisRepository masterDiagRepo;
	
	@Autowired
	MasterProcedureRepository masterProcRepo;
	
	@Autowired
	MasterMedicationRepository masterMedRepo;
	
	@Override
	public VisitDetailsRequest saveVisitDetails(VisitDetailsRequest request) {
		
		VitalSign vitalSign = request.getVitalSign();
		List<Diagnosis> diagList = request.getDiagnosis();
		Procedure procd = request.getProcedure();
		Medication med = request.getMedication();
		
		VisitDetailsRequest vr = new VisitDetailsRequest();
		VitalSign savedVs = null;
		Diagnosis savedDiag = null;
		Procedure savedProc = null;
		Medication savedMed = null;
		List<Diagnosis> savedDiagList = new ArrayList<>();
		
		Optional<VitalSign> opt1 = Optional.of(vitalSign);
		if(opt1.isPresent()) {
			vitalSign.setPatientId(request.getPatientId());
			vitalSign.setAppointmentId(request.getAppointmentId());
			savedVs = vitalSignRepo.save(vitalSign);
		}
		
		Optional<List<Diagnosis>> opt = Optional.of(diagList);
		if(opt.isPresent()) {
			for(Diagnosis dg:diagList) {
				Diagnosis dgs = new Diagnosis();
				dgs.setDiagnosisCode(dg.getDiagnosisCode());
				dgs.setDescription(dg.getDescription());
				dgs.setPatientId(request.getPatientId());
				dgs.setAppointmentId(request.getAppointmentId());
				 savedDiag = diagnosisRepo.save(dgs);
				 savedDiagList.add(savedDiag);
			}
		}
		
		Optional<Procedure> opt2 = Optional.of(procd);
		if(opt2.isPresent()) {
			procd.setPatientId(request.getPatientId());
			procd.setAppointmentId(request.getAppointmentId());
			 savedProc = procedureRepo.save(procd);
		}
		
		Optional<Medication> opt3 = Optional.of(med);
		if(opt3.isPresent()) {
			med.setPatientId(request.getPatientId());
			med.setAppointmentId(request.getAppointmentId());
			 savedMed = medRepo.save(med);
			 updateExaminationColumn(request.getAppointmentId(),request.getPatientId());
		}
		
		vr.setPatientId(savedDiag.getPatientId());
		vr.setAppointmentId(request.getAppointmentId());
		vr.setVitalSign(savedVs);
		vr.setDiagnosis(savedDiagList);
		vr.setMedication(savedMed);
		vr.setProcedure(savedProc);
		
		return vr;
	}
	
	public int updateExaminationColumn(Long aptId,Long patId) {
		int status = appointmentRepo.updateExaminationColumn(aptId,patId);
		return status;
	}


	@Override
	public Appointment getAppointmentDetails(Long patientId) {
		
		Optional<Appointment> apt = appointmentRepo.findById(patientId);
		return apt.get();
	}


	@Override
	public VisitDetailsResponse getVisitDetails(Long patientId, Long appointmentId) {
		
		List<Object[]> visitDetails = appointmentRepo.getPatientVisitDetails(patientId, appointmentId);
		
		VisitDetailsResponse visitResponse = new VisitDetailsResponse();
		visitResponse.setAppointmentId(appointmentId);
		visitResponse.setPatientId(patientId);
		
		List<Diagnosis> visitDiagList = new ArrayList<>();
		VitalSign vs = new VitalSign();
		for(Object ob[]:visitDetails) 
		{	
			
			vs.setBloodPressure((String)ob[1]);
			vs.setBodyTemp(((Number)ob[2]).doubleValue());
			vs.setHeight(((Number)ob[3]).doubleValue());
			vs.setRespirationRate(((Number)ob[4]).intValue());
			vs.setWeight(((Number)ob[5]).doubleValue());
			vs.setBloodPressureType((String)(ob[19]));
			
			Diagnosis diag = new Diagnosis();
			diag.setDiagnosisCode((String)ob[7]);
			diag.setDescription((String)ob[8]);
			visitDiagList.add(diag);
			
			Medication med =new Medication();
			med.setDrugBrand((String)ob[10]);
			med.setDrugForm((String)ob[11]);
			med.setDrugGenericName((String)ob[12]);
			med.setDrugName((String)ob[14]);
			med.setDrugStrength((String)ob[15]);
			
			Procedure pr = new Procedure();
			pr.setProcedureCode((String)ob[17]);
			pr.setDescription((String)ob[18]);
			
			
			visitResponse.setMedication(med);
			visitResponse.setProcedure(pr);
			
		//	LOGGER.info("groupId : "+groupId+" sourceId : "+sourceId+" sourceId == groupId : "+(sourceId == groupId));
			
				
		}
		visitResponse.setVitalSign(vs);
		visitResponse.setDiagnosis(visitDiagList);
		System.out.println("VR: "+visitResponse);
		return visitResponse;
	}


	@Override
	public MasterDataResponse getMasterData() {
	
		List<DiagnosisMaster> diagMaster =  masterDiagRepo.findAll();
		List<ProcedureMaster> procMaster =  masterProcRepo.findAll();
		List<MedicationMaster> medMaster = masterMedRepo.findAll();

		MasterDataResponse response = new MasterDataResponse();
		response.setDiganosisMaster(diagMaster);
		response.setProcedureMaster(procMaster);
		response.setMedicationMaster(medMaster);
		return response;
	}


	@Override
	public List<Appointment> getPatientsAppoinmentAll(Long patientId) {
		List<Appointment> apt =appointmentRepo.getPatientsAppoinmentAll(patientId);
		for(Appointment appoint : apt) {
			int done = checIfDidExamination(appoint.getAppointmentId(),appoint.getPatientId());
			System.out.println("Done: "+done);
			
			appoint.setDidExaminationhappened(done);
		}
		
		return apt;
	}
	
	public int checIfDidExamination(Long appointment_id,Long patient_id) {
		
		int status = diagnosisRepo.checIfDidExamination(appointment_id,patient_id);
		
		return status;
	
	}


}
