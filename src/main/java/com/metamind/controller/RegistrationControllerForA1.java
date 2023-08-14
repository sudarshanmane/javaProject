package com.metamind.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.internal.build.AllowSysOut;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.metamind.model.Registration;
import com.metamind.model.RegistrationDetailsAcceptor;
import com.metamind.service.RegistrationService;

import lombok.Delegate;


@Controller
public class RegistrationControllerForA1 {
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/registrationForm")
	public String registerationForm(Model model){
		
		model.addAttribute("registrationDetails" , new Registration());
		return "registrationForm";
		
	}
	
	
//	-----------
	
	@GetMapping("/getAllRegisteredDetails")
	public String getAllRegisteredDetails(Model registeredDetailsJson){

		
		return "registeredDetails";
	}
	
	
//	-------- Deletion --------
	
	@GetMapping("/deleteRegisteredDetails/{srNoOfRegisteredDetails}")
	public String deleteRegisteredDetails(Model registeredDetailsJson, @PathVariable int srNoOfRegisteredDetails){
		
			String deletionMessage = registrationService.deleteElementBySr(srNoOfRegisteredDetails);
		
		return "redirect:/getAllRegisteredDetails";
	}
	
//	------- Update Process --------

	@GetMapping("/updationForm")
	public String getUpdationForm(Model model){
		
		model.addAttribute("updationDetailsObject" , new RegistrationDetailsAcceptor());
		return "updationForm";
	}
	
	
}
