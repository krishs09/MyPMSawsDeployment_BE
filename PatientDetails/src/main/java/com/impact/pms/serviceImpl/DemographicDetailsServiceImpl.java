package com.impact.pms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.impact.pms.customException.DemographicDetailsExistsException;
import com.impact.pms.customException.DemographicDetailsNotFoundException;
import com.impact.pms.customException.PatientAlreadyExistsException;
import com.impact.pms.customException.PatientNotFoundException;
import com.impact.pms.model.Allergy;
import com.impact.pms.model.DemographicDetailRequest;
import com.impact.pms.model.DemographicDetails;
import com.impact.pms.model.EmergencyContactInfo;
import com.impact.pms.model.Employee;
import com.impact.pms.model.UserPatient;
import com.impact.pms.repository.AllergyRepository;
//import com.impact.pms.repository.AllergyRepository;
import com.impact.pms.repository.DemographicRepository;
import com.impact.pms.repository.EmergencyContactRepository;
import com.impact.pms.repository.EmployeeRepository;
import com.impact.pms.repository.UserDetailsRepository;
import com.impact.pms.service.DemographicDetailsService;

@Service
@Transactional
public class DemographicDetailsServiceImpl implements DemographicDetailsService {

	@Autowired
	DemographicRepository dmgRepository;

	@Autowired
	AllergyRepository allergyRepository;

	@Autowired
	EmergencyContactRepository emergencyRepository;

	@Autowired
	UserDetailsRepository userRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public UserPatient registerPatinet(UserPatient patient) {
		
		int count= userRepo.checkIfPatientExists(patient.getFirstname(),patient.getLastname(),patient.getEmail());
		System.out.println("Count: "+count);
		if(count > 0) {
			throw new PatientAlreadyExistsException();
		}else {
			UserPatient user =userRepo.save(patient);
			return user;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public DemographicDetails saveDmgDetail(DemographicDetailRequest request) {
		
		 DemographicDetails dd = request.getDemographicDetails();
		 dd.setPatientId(request.getPatientId());
		 
		 System.out.println("Demogph details: "+dd);
		
		 DemographicDetails savedDD = null;
		int status = 0;

		Optional<DemographicDetailRequest> optRequest = Optional.of(request);

		if (optRequest.isPresent()) {
			
			Optional<DemographicDetails> dmgExists = getDmgDetail(dd.getPatientId());
			
		//	Optional<DemographicDetails> optExists = Optional.of(dmgExists);
			
			if(dmgExists.isPresent()) {
				throw new DemographicDetailsExistsException();
			}else {
				
				savedDD = dmgRepository.save(dd);
				
				Optional<DemographicDetails> opt2 = Optional.of(savedDD);
				
				if(opt2.isPresent()) {
					
					EmergencyContactInfo eInfo = request.getEmergencyContact();
					eInfo.setPatientId(request.getPatientId());
					
					EmergencyContactInfo savedEC =  emergencyRepository.save(eInfo);
					
					System.out.println("Saved Emg Id : "  +savedEC.getEmgId()+ " Saved DId: " +savedDD.getDemographicId());
					
					int result =dmgRepository.mapEmergencyContactInfo(savedEC.getEmgId(), savedDD.getDemographicId());
					
					if(result > 0) {
						
						//Once EC is saved merge with DD
						savedDD.setEmergencyContact(savedEC);
						System.out.println(request.getDemographicDetails().getAnyAllergy());
						if(request.getDemographicDetails().getAnyAllergy()) {
							System.out.println("HAS ALLERGY");
							List<Allergy> allergyList = request.getAllergy();
							List<Allergy> savedAlrgList = new ArrayList<>();
							
							int count=0;
							for(Allergy allergy: allergyList) {
								
								allergy = allergyList.get(count);
								allergy.setDemographicId(savedDD.getDemographicId());
								allergy.setPatientId(request.getPatientId());
								Allergy savedAlrgy = allergyRepository.save(allergy);
								
								Optional<Allergy> opt4 = Optional.of(savedAlrgy);
								if(opt4.isPresent()){
									
									savedAlrgList.add(savedAlrgy);
									
									
									status=1;
								}
								count++;
							}
							
							savedDD.setAllergy(savedAlrgList);
						}
					}
				}
				
			}
			
		}
		
		return savedDD;
	}

	@Override
	public UserPatient getPatientDetails(Long id) {

		// USER MODULE SERVICE API CALL FOR PATIENT DETAILS USING RSTTEMPLATE
		Optional<UserPatient> usr = userRepo.findById(id);
		if (usr.isPresent()) {
			return usr.get();
		} else {
			throw new PatientNotFoundException();
		}
	}

	@Override
	public Optional<DemographicDetails> getDmgDetail(Long patId) {
		System.out.println("Patinet id: "+patId);
		Optional<DemographicDetails> dmg=	dmgRepository.findByPatientId(patId);
		return dmg;
		
		/*
		 * if(dmg.isPresent()) { return dmg.get(); }else {
		 * 
		 * //throw new DemographicDetailsNotFoundException(); //return null; }
		 */
		
		
	}

	@Override
	public List<Employee> getAllPhysician() {
		List<Employee> list = empRepo.findAll();
		return list;
	}



}
