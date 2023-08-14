package com.metamind.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metamind.model.metadeta.MetadetaEntry;
import com.metamind.service.MetadetaService;

@RestController
public class MetadetaRestController {
	
	@Autowired
	private MetadetaService metadetaService;

	@GetMapping("/getAllRegisteredDetailsOfMetadetafetch")
	public ResponseEntity<List<MetadetaEntry>> getAllRegisteredDetailsControllerNew(Model allRegisteredDetailsModel) {
		List<MetadetaEntry> myList = metadetaService.getAllRegisteredDetails();
		
		return new ResponseEntity<List<MetadetaEntry>>(myList,HttpStatus.OK);
	}
	
	@PostMapping("/registerMetadataDetails")
	public String metadetaRegistrationController(@RequestBody String metadetaObjectINP) {
			
		    JSONObject metadetaObject= new JSONObject(metadetaObjectINP);
			MetadetaEntry mapToMetadeta = new  MetadetaEntry();

			mapToMetadeta.setVolume_type((String) metadetaObject.get("volume_type"));
			mapToMetadeta.setFin_year((String) metadetaObject.get("fin_year"));
			mapToMetadeta.setSub_registrar_office((String) metadetaObject.get("sub_registrar_office"));
			mapToMetadeta.setTotal_pages((String) metadetaObject.get("total_pages"));
			mapToMetadeta.setMissing_pages((String) metadetaObject.get("missing_pages"));
			mapToMetadeta.setNo_of_documents((String) metadetaObject.get("no_of_documents"));
			mapToMetadeta.setNumber((String) metadetaObject.get("number"));
			mapToMetadeta.setFrom_page((String) metadetaObject.get("from_page"));
			mapToMetadeta.setTo_page((String) metadetaObject.get("to_page"));
			
			String startDateString = (String) metadetaObject.get("start_date");
			LocalDate startDate = LocalDate.parse(startDateString,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			mapToMetadeta.setStart_date(java.sql.Date.valueOf(startDate));
			
			String endDateString = (String) metadetaObject.get("end_date");
			LocalDate endDate = LocalDate.parse(endDateString,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			mapToMetadeta.setEnd_date(java.sql.Date.valueOf(endDate));

			String registrationResult = metadetaService.metadetaRegisterationService(mapToMetadeta);
			
			return registrationResult;
		
	}
	
	
	@PutMapping("/updateMetadataRegisteredDetails")
	public String metadetaUpdationController(@RequestBody String metadetaObjectINP) {
			
		    JSONObject metadetaObject= new JSONObject(metadetaObjectINP);
			MetadetaEntry mapToMetadeta = new  MetadetaEntry();
			mapToMetadeta.setSr( metadetaObject.getInt("sr"));
			mapToMetadeta.setVolume_type((String) metadetaObject.get("volume_type"));
			mapToMetadeta.setFin_year((String) metadetaObject.get("fin_year"));
			mapToMetadeta.setSub_registrar_office((String) metadetaObject.get("sub_registrar_office"));
			mapToMetadeta.setTotal_pages((String) metadetaObject.get("total_pages"));
			mapToMetadeta.setMissing_pages((String) metadetaObject.get("missing_pages"));
			mapToMetadeta.setNo_of_documents((String) metadetaObject.get("no_of_documents"));
			mapToMetadeta.setNumber((String) metadetaObject.get("number"));
			mapToMetadeta.setFrom_page((String) metadetaObject.get("from_page"));
			mapToMetadeta.setTo_page((String) metadetaObject.get("to_page"));
			
			String startDateString = (String) metadetaObject.get("start_date");
			LocalDate startDate = LocalDate.parse(startDateString,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			mapToMetadeta.setStart_date(java.sql.Date.valueOf(startDate));
			
			String endDateString = (String) metadetaObject.get("end_date");
			LocalDate endDate = LocalDate.parse(endDateString,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			mapToMetadeta.setEnd_date(java.sql.Date.valueOf(endDate));

			String updationResult = metadetaService.updateMetadataDetails(mapToMetadeta);
			
			return updationResult;
		
	}
	
	

}
