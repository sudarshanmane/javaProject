package com.metamind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metamind.Dao.BRegistrationDao;
import com.metamind.model.BRegistration;

@Service
public class BRegistrationsService {
	
	@Autowired
	private BRegistrationDao bRegistrationDao;
	
	public String bRegistrationService(BRegistration bRegistrationDetails){
		
		BRegistration bRegistration = bRegistrationDao.save(bRegistrationDetails);
		return "Registration Successfull.";
		
	}
	
	public List<BRegistration> getAllRegisteredDetailsService(){	
		return bRegistrationDao.findAll();
	}
	
//	-------updation Process-------
	

	public String bUdationService(BRegistration bRegistrationDetails){
		
		BRegistration bRegistration = bRegistrationDao.save(bRegistrationDetails);
		return "Registration Successfull.";
		
	}

//	------------Delition Process------
	
	public String deletionProcessOfB(Integer sr) {
		bRegistrationDao.deleteById(sr);
		return "Details Deleted Successfully.";
	}

}
