package com.impact.pms.controller;

import java.sql.Time;
import java.time.LocalTime;
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

import com.impact.pms.model.AppointmentHistory;
import com.impact.pms.model.Appointments;
import com.impact.pms.model.BookAppointmentRequestBody;
import com.impact.pms.model.MasterDataResponse;
import com.impact.pms.model.UserPatient;
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

		return new ResponseEntity<VisitDetailsRequest>(vr,HttpStatus.OK);
	}
	
	//APPOINTMENT ID WILL BE SENT ALONG WITH PATIENT ID AND DETAILS, WHEN ROUTED TO YOUR HOME PAGE
	
	@GetMapping("/getappointmentId")
	public ResponseEntity<AppointmentHistory> getPatientDetailsById(@RequestParam long appointmentId){
		
		AppointmentHistory a =service.getAppointmentDetails(appointmentId);
		return new ResponseEntity<AppointmentHistory>(a,HttpStatus.OK);
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
	public ResponseEntity<List<AppointmentHistory>> getAllAppointment(@RequestParam Long patientId){
		
		List<AppointmentHistory> list =service.getPatientsAppoinmentAll(patientId);
		System.out.println(list);
		return new ResponseEntity<List<AppointmentHistory>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getallappointmentForPhysician")
	public ResponseEntity<List<Appointments>> getAllAppointmentForPhysician(@RequestParam Long physicianId){
		
		List<Appointments> list =service.getAppoinmentsForPhysician(physicianId);
		System.out.println(list);
		return new ResponseEntity<List<Appointments>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/consultationAppt")
	public String updateAppointmentForOnlyConsultation(@RequestParam long patientId, @RequestParam long appointmentId){
	
	//	VisitDetailsRequest vr = service.saveVisitDetails(request);

		return "Done";
	}
	
	@GetMapping("/getTimeSlots")
	public ResponseEntity<List<Time>> getAvailableTimeSlots(@RequestParam String date){
	
		List<Time> bookedTimeList =  service.getAvailableTimeSlots(date);
		return new ResponseEntity<List<Time>>(bookedTimeList,HttpStatus.OK);
	}
	
	@GetMapping("/findExistingPatient")
	public ResponseEntity<UserPatient> getExistingPatientDetails(@RequestParam String firstname, 
			@RequestParam String mobile, @RequestParam String gender ){
		
		UserPatient u =service.getExistingPatientDetails(firstname,mobile,gender);
		System.out.println(u.toString());
		return new ResponseEntity<UserPatient>(u,HttpStatus.OK);
	}
	
	@PostMapping("/saveAppointment")
	public ResponseEntity<Appointments> bookAppointment(@RequestBody BookAppointmentRequestBody bookAppointmetnObj){
		System.out.println("Appointment REQUEST: "+bookAppointmetnObj);
		Appointments vr = service.bookAppointment(bookAppointmetnObj);

		return new ResponseEntity<Appointments>(vr,HttpStatus.OK);
	}
	
	
}
