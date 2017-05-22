package pl.fotoszop.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import pl.fotoszop.model.HashGenerator;

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
