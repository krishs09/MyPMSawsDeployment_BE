package com.impact.pms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impact.pms.model.DemographicDetailRequest;
import com.impact.pms.model.DemographicDetails;
import com.impact.pms.model.UserPatient;
import com.impact.pms.service.DemographicDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DemographicDetailController {

	@Autowired
	private DemographicDetailsService service;
	
	@PostMapping("/registration")
	public ResponseEntity<UserPatient>  patientRegistration( @RequestBody UserPatient patient) {
		System.out.println("Registration REQUEST: "+patient);
		UserPatient savedUser =service.registerPatinet(patient);
		return new ResponseEntity<UserPatient>(savedUser, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<DemographicDetails>  saveDemographicDetails( @RequestBody DemographicDetailRequest demographicDetails) {
		System.out.println("REQUEST: "+demographicDetails);
		DemographicDetails details =service.saveDmgDetail(demographicDetails);
		return new ResponseEntity<DemographicDetails>(details, HttpStatus.OK);
	}
	
	@GetMapping("/getDemographicDetail")
	public ResponseEntity<DemographicDetails> getPatientDemographicDetails(@RequestParam Long patientId){
		
		Optional<DemographicDetails> details =service.getDmgDetail(patientId);
		return new ResponseEntity<DemographicDetails>(details.get(), HttpStatus.OK);
	}
	
	@GetMapping("/getpatientById")
	public ResponseEntity<UserPatient> getPatientDetailsById(@RequestParam long patientId){
		
		UserPatient u =service.getPatientDetails(patientId);
		System.out.println(u.toString());
		return new ResponseEntity<UserPatient>(u,HttpStatus.OK);
	}
}
