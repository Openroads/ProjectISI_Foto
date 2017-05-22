package pl.fotoszop.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import pl.fotoszop.model.HashGenerator;

public class OrderPhotosFormDTO {

	 	
	 	// ORDER PHOTOS //
	 	
	 	@NotEmpty
	 	@Size(min=4, max=256)
	 	private String orderAddress;

	 	
	 	public String getOrderAddress() {
			return orderAddress;
	 	}
	 	public void setOrderAddress(String orderAddress) {
	 		this.orderAddress = orderAddress;
	 	}
	 	
	
	
}
