package com.metamind.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
	
public class RegistrationDetailsAcceptor {
	
        private Integer sr;
        
		private String date_of_receipt_of_record;

		private Integer book_volume_no;

		private String district;

		private Integer total_no_of_pages;

		private String record_page_size;

		private String are_any_pages_missing;
		
		private String page_numbers_which_are_missing;

		private String condition_of_the_document;

		private String remark;

		private String sign_of_record_room_igsr_at_the_time_issuing_of_document;
		
		private String sign_of_agency_at_the_time_issuing_of_document;
		
		private String date_of_return_of_the_record;

		private String sign_of_record_room_igrs_at_the_time_submitting_the_document;

		private String sign_of_agency_at_the_time_submitting_the_document;
		
}
