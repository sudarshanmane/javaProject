package com.metamind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.metamind.Dao.MetadetaEnteryDao;
import com.metamind.model.metadeta.MetadetaEntry;

@Service
public class MetadetaService {
	
	@Autowired
	private MetadetaEnteryDao metadetaEnteryDao;
	
	public String metadetaRegisterationService(MetadetaEntry metadetaEntry) {
		MetadetaEntry registeredMetadetaDetails =  metadetaEnteryDao.save(metadetaEntry);
		return "Metadeta Details Registered Successfully.";
	}
	
	public List<MetadetaEntry> getAllRegisteredDetails(){
		return metadetaEnteryDao.findAll();
	}
	
	public String deleteMetadetaEntry(Integer sr) {
		metadetaEnteryDao.deleteById(sr);
		return "Entry Deleted Successfully.";
	}
	
	public String updateMetadataDetails(MetadetaEntry entry) {
		MetadetaEntry Updatedentry = metadetaEnteryDao.save(entry);
		return "Details Updated Successfully.";
	}
	
	
}
