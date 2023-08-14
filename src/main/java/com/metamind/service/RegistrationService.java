package com.metamind.service;

import java.util.List;

import javax.imageio.spi.RegisterableService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.metamind.Dao.RegistrationDaoForA;
import com.metamind.model.Registration;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationDaoForA registrationDao;
	
	// register details of the employee 
	public String registerDetails(Registration registration) {
		
		registrationDao.save(registration);
		return "Registration Successfull.";
	}
	
	public List<Registration> getAllRegisteredDetails(){
		List<Registration> registeredDetails = registrationDao.findAll();
		return registeredDetails;
	}
	
	public String deleteElementBySr(Integer id){
		
		registrationDao.deleteById(id);
		System.out.println(id);
		
		return "Details having id : " + id;
	}
	
//	-------- Updation Service --------
	
	public Registration updateRegisteredDetails(Registration updatedRegisteredDetails){
		
		return registrationDao.save(updatedRegisteredDetails);
		
	}
	
//	---------- select according to the district -----------
//	
//	public List<Registration> getDetailsAccordingToDistrict(String district){
//		
//	}
//	
}
