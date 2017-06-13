package pl.fotoszop.model;


import java.util.Date;

public abstract class OrderBase {

	private  String orderTitle;

	private  String orderAddress;
    private  String orderPlace;
    
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
