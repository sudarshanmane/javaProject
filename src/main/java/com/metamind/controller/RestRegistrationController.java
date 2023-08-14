package com.metamind.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metamind.model.Registration;
import com.metamind.service.RegistrationService;

@RestController
public class RestRegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/getAllRegisteredDetailsOfA")
	public ResponseEntity<List<Registration>> getAllRegisteredDetails(Model registeredDetailsJson){

		List<Registration> allRegisteredDetails = registrationService.getAllRegisteredDetails();
		
		return new ResponseEntity<List<Registration>>(allRegisteredDetails,HttpStatus.ACCEPTED);
	}
	
//	----------registration Process ------
	
	@PostMapping("/registrationProcessOfA") 
	public String registerationForm(@RequestBody String registrationDetailsJSON){		
	
			JSONObject updatedJSON = new JSONObject(registrationDetailsJSON);
			
			Registration mapToRegistration  = new Registration();
			
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
				mapToRegistration.setRecord_page_size((String)updatedJSON.get("record_page_size"));
				
//				6
				mapToRegistration.setAre_any_pages_missing((String) updatedJSON.get("are_any_pages_missing"));
				
//				7
				mapToRegistration.setPage_numbers_which_are_missing((String) updatedJSON.get("page_numbers_which_are_missing"));
				
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
				
			String registrationResult = registrationService.registerDetails(mapToRegistration);
			
			return registrationResult;

	}
	

	@PutMapping("/updationProcessOfA")
	public String getUpdationForm(@RequestBody String updatedJSONObject){

			JSONObject updatedJSON = new JSONObject(updatedJSONObject);
			
			Registration mapToRegistration  = new Registration();
			
	        //  0
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
				mapToRegistration.setRecord_page_size((String)updatedJSON.get("record_page_size"));
				
//				6
				mapToRegistration.setAre_any_pages_missing((String) updatedJSON.get("are_any_pages_missing"));
				
//				7
				mapToRegistration.setPage_numbers_which_are_missing((String) updatedJSON.get("page_numbers_which_are_missing"));
				
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
				
				Registration registrationResult = registrationService.updateRegisteredDetails(mapToRegistration);
				
				return "Details Updated Successfully.";
	}
	
		
	
	
}
