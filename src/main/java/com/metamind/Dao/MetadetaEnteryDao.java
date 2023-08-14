package com.metamind.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metamind.model.metadeta.MetadetaEntry;

public interface MetadetaEnteryDao extends JpaRepository<MetadetaEntry, Integer>{

	
}
