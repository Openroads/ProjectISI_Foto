package pl.fotoszop.model;


import java.util.Date;

public abstract class OrderBase {

	public String orderTitle;

	public String orderAddress;
    public String orderPlace;
    
    public String getOrderTitle() {
		return orderTitle;
	}
	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}
	
    public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getOrderPlace() {
		return orderPlace;
	}
	public void setOrderPlace(String orderPlace) {
		this.orderPlace = orderPlace;
	}

}
