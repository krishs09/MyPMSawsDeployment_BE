package com.impact.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impact.pms.model.Appointment;
import com.impact.pms.model.MasterDataResponse;
import com.impact.pms.model.VisitDetailsRequest;
import com.impact.pms.model.VisitDetailsResponse;
import com.impact.pms.service.VisitService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VisitController {

	@Autowired
	private VisitService service;
	
	@PostMapping("/save")
	public ResponseEntity<VisitDetailsRequest> saveVisitDetails(@RequestBody VisitDetailsRequest request){
		System.out.println("VISIT REQUEST: "+request);
		VisitDetailsRequest vr = service.saveVisitDetails(request);
		System.out.println("VISIT REQUEST: "+request);
		return new ResponseEntity<VisitDetailsRequest>(vr,HttpStatus.OK);
	}
	
	//APPOINTMENT ID WILL BE SENT ALONG WITH PATIENT ID AND DETAILS, WHEN ROUTED TO YOUR HOME PAGE
	
	@GetMapping("/getappointmentId")
	public ResponseEntity<Appointment> getPatientDetailsById(@RequestParam long patientId){
		
		Appointment a =service.getAppointmentDetails(patientId);
		return new ResponseEntity<Appointment>(a,HttpStatus.OK);
	}
	
	@GetMapping("/getVisitdetail")
	public ResponseEntity<VisitDetailsResponse> getVisitDetail(@RequestParam long patientId, @RequestParam long appointmentId ){
	
		VisitDetailsResponse vd =service.getVisitDetails(patientId,appointmentId);
		System.out.println("VIEW VISIT DETAILS: "+vd);
		return new ResponseEntity<VisitDetailsResponse>(vd,HttpStatus.OK);
	}
	
	@GetMapping("/getmasterdata")
	public ResponseEntity<MasterDataResponse> getMasterData(){
		
		MasterDataResponse mr =service.getMasterData();
		System.out.println("Response: "+mr);
		return new ResponseEntity<MasterDataResponse>(mr,HttpStatus.OK);
	}
	
	@GetMapping("/getallappointment")
	public ResponseEntity<List<Appointment>> getAllAppointment(@RequestParam Long patientId){
		
		List<Appointment> list =service.getPatientsAppoinmentAll(patientId);
		System.out.println(list);
		return new ResponseEntity<List<Appointment>>(list,HttpStatus.OK);
	}
	
}
