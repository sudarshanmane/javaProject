package com.metamind.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.metamind.model.BRegistration;
import com.metamind.model.Registration;
import com.metamind.model.RegistrationDetailsAcceptor;
import com.metamind.service.BRegistrationsService;

@Controller
public class BRegistrationController {
	
	
	@Autowired
	private BRegistrationsService bRegistrationsService;
	
	@GetMapping("/registrationFormB")
	public String registrationControllerForB() {
		
		return "BRegistrationForm";
	}
	
	@GetMapping("/getAllRegisteredDetailsOfB")
	public String getAllRegisteredDetailsofTableB(Model registedDetailsB){
		
		return "BRegisteredDetails";
	}
	

//	-------- upadtion ------
	
	@GetMapping("/getBupdationFormB")
	public String getUpdationForm(){
		return "BupdationForm";
	}
	
	
	
//	------detetion-------
	
	@GetMapping("/deleteRegisteredDetailsOfB/{srNo}")
	public String deleteRegisteredDetails(@PathVariable Integer srNo) {
		String deletionResult = bRegistrationsService.deletionProcessOfB(srNo);

		return "redirect:/getAllRegisteredDetailsOfB";
	}

}


