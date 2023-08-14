package com.metamind.controller;

import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.internal.build.AllowSysOut;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.metamind.model.metadeta.MetadetaEntry;
import com.metamind.service.MetadetaService;

@Controller
public class MetadetaController {
	
	@Autowired
	private MetadetaService metadetaService;
	
	@GetMapping("/metadetaRegistrationForm")
	public String metadetaHomePageController() {
		return "/metadetaEntry/metadataRegistration";
	}
	

	
	
	@GetMapping("/getAllRegisteredDetailsOfMetadeta")
	public String getAllRegisteredDetailsController(Model allRegisteredDetailsModel) {

		return "/metadetaEntry/metadetasAllRegisteredDetails";
	}
	
	
//	-------deleted entry---------
	
	@GetMapping("deletedMetadetaEntry/{sr}")
	public String deletedMetadetaEntry(@PathVariable("sr") Integer sr) {
		String enteryDeletionResult =metadetaService.deleteMetadetaEntry(sr);
		return "redirect:/getAllRegisteredDetailsOfMetadeta";
	}
	
//	----Updated Metadeta Entry----
	
	@GetMapping("/getMetadataUpdationForm")
	public String getMetadataUpdationForm() {
		
		return "/metadetaEntry/MetadataUpdationForm";
	}
	
	
	
}
