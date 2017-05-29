package pl.fotoszop.dto;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class OrderSessionFormDTO {


	// ORDER SESSION //
 	
		 	@NotEmpty
		 	@Size(min=4, max=256)
		 	private String subject;
		 	@NotEmpty
		 	@Size(min=4, max=256)
		 	private String sessionAddress;
		 	@NotEmpty
		 	@Size(min=4, max=256)
		 	private String sessionPlace;
		 	
			
			//@Future
			//@DateTimeFormat(pattern = "yyyy-MM-dd")
			private String date;
		 	
		 	public String getDate() {
				return date;
			}
		 	
			public void setDate(String date) {
				this.date = date;
			}
			public String getSubject() {
		 		return subject;
		 	}
		 	public void setSubject(String subject) {
		 		this.subject = subject;
		 	}
		 	public String getSessionAddress() {
				return sessionAddress;
		 	}
		 	public void setSessionAddress(String sessionAddress) {
		 		this.sessionAddress = sessionAddress;
		     }
		 	public String getSessionPlace() {
		 		return sessionPlace;
		 	}
		 	public void setSessionPlace(String sessionPlace) {
		 		this.sessionPlace = sessionPlace;
		    }
	
}
