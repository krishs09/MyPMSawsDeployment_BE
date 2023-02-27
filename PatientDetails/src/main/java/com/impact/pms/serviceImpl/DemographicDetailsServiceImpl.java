package com.impact.pms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.pms.model.Allergy;
import com.impact.pms.model.DemographicDetailRequest;
import com.impact.pms.model.DemographicDetails;
import com.impact.pms.model.EmergencyContactInfo;
import com.impact.pms.model.UserPatient;
import com.impact.pms.repository.AllergyRepository;
//import com.impact.pms.repository.AllergyRepository;
import com.impact.pms.repository.DemographicRepository;
import com.impact.pms.repository.EmergencyContactRepository;
import com.impact.pms.repository.UserDetailsRepository;
import com.impact.pms.service.DemographicDetailsService;

@Service
public class DemographicDetailsServiceImpl implements DemographicDetailsService {

	@Autowired
	DemographicRepository dmgRepository;

	@Autowired
	AllergyRepository allergyRepository;

	@Autowired
	EmergencyContactRepository emergencyRepository;

	@Autowired
	UserDetailsRepository userRepo;

	@Override
	public DemographicDetails saveDmgDetail(DemographicDetailRequest request) {
		 DemographicDetails dd = request.getDemographicDetails();
		 dd.setPatientId(request.getPatientId());
		DemographicDetails savedDD = null;
		int status = 0;

		Optional<DemographicDetailRequest> opt3 = Optional.of(request);

		if (opt3.isPresent()) {
			savedDD = dmgRepository.save(dd);

			Optional<DemographicDetails> opt2 = Optional.of(savedDD);
			
			if(opt2.isPresent()) {
				
				EmergencyContactInfo eInfo = request.getEmergencyContact();
				
				EmergencyContactInfo savedEC =  emergencyRepository.save(eInfo);
				
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

		return savedDD;
	}

	@Override
	public UserPatient getPatientDetails(Long id) {

		// USER MODULE SERVICE API CALL FOR PATIENT DETAILS USING RSTTEMPLATE
		Optional<UserPatient> usr = userRepo.findById(id);
		if (usr.isPresent()) {
			return usr.get();
		} else {
			return null;
		}

	}

	@Override
	public DemographicDetails getDmgDetail(Long patId) {
		DemographicDetails dmg=	dmgRepository.findByPatientId(patId);
		return dmg;
	}

}
