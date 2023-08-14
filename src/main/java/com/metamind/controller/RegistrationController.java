package com.metamind.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.internal.build.AllowSysOut;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/registrationForm")
	public String registerationForm(Model model){
		
		model.addAttribute("registrationDetails" , new Registration());
		return "registrationForm";
		
	}
	
	@PostMapping("/registrationProcess") 
	public String registerationForm(@ModelAttribute("registrationDetails") RegistrationDetailsAcceptor registrationDetails, 
			Model registrationMessage){
		
		Registration mapToRegistration  = new Registration();
		System.out.println(registrationDetails);
		
		try {
			
			String date_of_receipt_of_record1 = registrationDetails.getDate_of_receipt_of_record();
			LocalDate date1 = LocalDate.parse(date_of_receipt_of_record1,DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
//			1
			mapToRegistration.setDate_of_receipt_of_record(java.sql.Date.valueOf(date1));

//			2
			mapToRegistration.setBook_volume_no(registrationDetails.getBook_volume_no());
			
//			3
			mapToRegistration.setDistrict(registrationDetails.getDistrict());
						
//			4
			mapToRegistration.setTotal_no_of_pages(registrationDetails.getTotal_no_of_pages());
			
//			5
			mapToRegistration.setRecord_page_size(registrationDetails.getRecord_page_size());
			
//			6
			mapToRegistration.setAre_any_pages_missing(registrationDetails.getAre_any_pages_missing());
			
//			7
			mapToRegistration.setPage_numbers_which_are_missing(registrationDetails.getPage_numbers_which_are_missing());
			
//			8
			mapToRegistration.setCondition_of_the_document(registrationDetails.getCondition_of_the_document());
			
//			9
			mapToRegistration.setRemark(registrationDetails.getRemark());

//			10
			mapToRegistration.setSign_of_record_room_igsr_at_the_time_issuing_of_document(
					registrationDetails.getSign_of_record_room_igsr_at_the_time_issuing_of_document());
			
//			11
			mapToRegistration.setSign_of_agency_at_the_time_issuing_of_document(
					registrationDetails.getSign_of_agency_at_the_time_issuing_of_document());
			
//			12
			String date_of_return_of_the_record2 = registrationDetails.getDate_of_return_of_the_record();
			LocalDate date2 = LocalDate.parse(date_of_return_of_the_record2,DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
			mapToRegistration.setDate_of_return_of_the_record(java.sql.Date.valueOf(date2));
			
//			13
			mapToRegistration.setSign_of_record_room_igrs_at_the_time_submitting_the_document(
					registrationDetails.getSign_of_record_room_igrs_at_the_time_submitting_the_document());	
			
//			14
			mapToRegistration.setSign_of_agency_at_the_time_submitting_the_document(
					registrationDetails.getSign_of_agency_at_the_time_submitting_the_document());	

			System.out.println(mapToRegistration);

		} catch (Exception e) {
			System.out.println(e);
			registrationMessage.addAttribute("registrationResult", "Error date time formatter inside registration process");
			System.out.println("inside exception");
		}
		
		String registrationResult = registrationService.registerDetails(mapToRegistration);
		registrationMessage.addAttribute("registrationResult", registrationResult);
		
		return "registrationForm";
	}
	
	@GetMapping("/getAllRegisteredDetails")
	public String getAllRegisteredDetails(Model registeredDetailsJson){

		List<Registration> allRegisteredDetails = registrationService.getAllRegisteredDetails();
		
		if(allRegisteredDetails.size()>0) {
			allRegisteredDetails = registrationService.getAllRegisteredDetails();
			
			JSONArray registeredDetailsList = new JSONArray();
			
			for(Registration details : allRegisteredDetails) {
				JSONObject jsonObjectOfDetails = new JSONObject(details);
				registeredDetailsList.put(jsonObjectOfDetails);
			}
			registeredDetailsJson.addAttribute("registeredDetailsJson", registeredDetailsList);
		}else {
			registeredDetailsJson.addAttribute("DetailsNoFound", "Registered Details Not Found");
		}
		
		return "registeredDetails";
	}
	
//	-------- Deletion --------
	
	@GetMapping("/deleteRegisteredDetails/{srNoOfRegisteredDetails}")
	public String deleteRegisteredDetails(Model registeredDetailsJson, @PathVariable int srNoOfRegisteredDetails){
		
			String deletionMessage = registrationService.deleteElementBySr(srNoOfRegisteredDetails);
		
		return "redirect:/getAllRegisteredDetails";
	}
	
//	------- Updation Process --------

	@GetMapping("/updationForm")
	public String getUpdationForm(Model model){
		
		model.addAttribute("updationDetailsObject" , new RegistrationDetailsAcceptor());
		return "updationForm";
	}
	
	@PostMapping("/updationProcess") 
	public String updationForm(@ModelAttribute("updationDetailsObject") RegistrationDetailsAcceptor registrationDetails, Model registrationMessage){
		
		Registration mapToRegistration  = new Registration();
		System.out.println(registrationDetails);
		
		try {
			
//			0
			mapToRegistration.setSr(registrationDetails.getSr());

			String date_of_receipt_of_record1 = registrationDetails.getDate_of_receipt_of_record();
			LocalDate date1 = LocalDate.parse(date_of_receipt_of_record1,DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
//			1
			mapToRegistration.setDate_of_receipt_of_record(java.sql.Date.valueOf(date1));

//			2
			mapToRegistration.setBook_volume_no(registrationDetails.getBook_volume_no());
			
//			3
			mapToRegistration.setDistrict(registrationDetails.getDistrict());
						
//			4
			mapToRegistration.setTotal_no_of_pages(registrationDetails.getTotal_no_of_pages());
			
//			5
			mapToRegistration.setRecord_page_size(registrationDetails.getRecord_page_size());
			
//			6
			mapToRegistration.setAre_any_pages_missing(registrationDetails.getAre_any_pages_missing());
			
//			7
			mapToRegistration.setPage_numbers_which_are_missing(registrationDetails.getPage_numbers_which_are_missing());
			
//			8
			mapToRegistration.setCondition_of_the_document(registrationDetails.getCondition_of_the_document());
			
//			9
			mapToRegistration.setRemark(registrationDetails.getRemark());

//			10
			mapToRegistration.setSign_of_record_room_igsr_at_the_time_issuing_of_document(
					registrationDetails.getSign_of_record_room_igsr_at_the_time_issuing_of_document());
			
//			11
			mapToRegistration.setSign_of_agency_at_the_time_issuing_of_document(
					registrationDetails.getSign_of_agency_at_the_time_issuing_of_document());
			
//			12
			String date_of_return_of_the_record2 = registrationDetails.getDate_of_return_of_the_record();
			LocalDate date2 = LocalDate.parse(date_of_return_of_the_record2,DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
			mapToRegistration.setDate_of_return_of_the_record(java.sql.Date.valueOf(date2));
			
//			13
			mapToRegistration.setSign_of_record_room_igrs_at_the_time_submitting_the_document(
					registrationDetails.getSign_of_record_room_igrs_at_the_time_submitting_the_document());	
			
//			14
			mapToRegistration.setSign_of_agency_at_the_time_submitting_the_document(
					registrationDetails.getSign_of_agency_at_the_time_submitting_the_document());
			System.out.println(mapToRegistration);
			
			Registration updatedDetails = registrationService.updateRegisteredDetails(mapToRegistration);
			
			registrationMessage.addAttribute("updationResult",updatedDetails);
			
			System.out.println(mapToRegistration);
			
		} catch (Exception e) {
			System.out.println("inside Updation Exception");
			registrationMessage.addAttribute("registrationResult", "Error date time formatter inside registration process");
		}		
		
		return "updationForm";
	}

	@GetMapping("/updationJSON/{updatedJson}")
	public String getUpdationForm(@PathVariable("updatedJson") String updatedJSONObject,Model returnUpdatedDetails){
	
		try {
			JSONObject updatedJSON = new JSONObject(updatedJSONObject);
			
			Registration mapToRegistration  = new Registration();
			
//			
	        //			0
				mapToRegistration.setSr(updatedJSON.getInt("sr"));

				String date_of_receipt_of_record1 = (String) updatedJSON.get("date_of_receipt_of_record");
				LocalDate date1 = LocalDate.parse(date_of_receipt_of_record1,DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
//				1
				mapToRegistration.setDate_of_receipt_of_record(java.sql.Date.valueOf(date1));

//				2
				mapToRegistration.setBook_volume_no(updatedJSON.getInt("book_volume_no"));
				
//				3
				mapToRegistration.setDistrict((String) updatedJSON.get("district"));
							
//				4
				mapToRegistration.setTotal_no_of_pages(updatedJSON.getInt("total_no_of_pages"));
				
//				5
				mapToRegistration.setRecord_page_size(updatedJSON.getInt("record_page_size"));
				
//				6
				mapToRegistration.setAre_any_pages_missing((String) updatedJSON.get("are_any_pages_missing"));
				
//				7
				mapToRegistration.setPage_numbers_which_are_missing(updatedJSON.getInt("page_numbers_which_are_missing"));
				
//				8
				mapToRegistration.setCondition_of_the_document((String) updatedJSON.get("condition_of_the_document"));
				
//				9
				mapToRegistration.setRemark((String) updatedJSON.get("remark"));

//				10
				mapToRegistration.setSign_of_record_room_igsr_at_the_time_issuing_of_document(
						(String) updatedJSON.get("sign_of_record_room_igsr_at_the_time_issuing_of_document"));
				
//				11
				mapToRegistration.setSign_of_agency_at_the_time_issuing_of_document(
						(String) updatedJSON.get("sign_of_agency_at_the_time_issuing_of_document"));
				
//				12
				String date_of_return_of_the_record2 = (String) updatedJSON.get("date_of_return_of_the_record");
				LocalDate date2 = LocalDate.parse(date_of_return_of_the_record2,DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
				mapToRegistration.setDate_of_return_of_the_record(java.sql.Date.valueOf(date2));
				
//				13
				mapToRegistration.setSign_of_record_room_igrs_at_the_time_submitting_the_document(
						(String) updatedJSON.get("sign_of_record_room_igrs_at_the_time_submitting_the_document"));	
				
//				14
				mapToRegistration.setSign_of_agency_at_the_time_submitting_the_document(
						(String) updatedJSON.get("sign_of_agency_at_the_time_submitting_the_document"));
				
				registrationService.updateRegisteredDetails(mapToRegistration);
				return "redirect:/updationForm";
				
		} catch (Exception e) {
			System.out.println("inside updation process json.");
			System.out.println(e);	
		}
		
		return "redirect:/updationForm";

	}
	
	
}
