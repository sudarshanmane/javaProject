package com.metamind.model.metadeta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class MetadetaEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sr;
	
	private String volume_type;
	private String fin_year;
	private String sub_registrar_office;
	private String total_pages;
	private String missing_pages;
	private String no_of_documents;
	private String number;
	private String from_page;
	private String to_page;
	
	@Temporal(TemporalType.DATE)
	private  java.util.Date start_date;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date end_date;
	
	
}
