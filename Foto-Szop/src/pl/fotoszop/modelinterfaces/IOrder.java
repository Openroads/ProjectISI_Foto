package pl.fotoszop.modelinterfaces;

import java.util.Date;

public interface IOrder {
	
	public void setOrderId(int id);
	public void setDateOfOrder(Date dateOfOrder);
	public void setIdOfRealizationTerm(int termId);
	public void setDateOfModification(Date dateOfModification);
	public void setOrderStatus(String orderStatus);
	public void setIdService(int serviceId);
	public void setClientId(int clientId);
	public void setRealizationDate(Date realizationDate);
	public void setService(String service);
	

	
	public int getIdOrder();
	public Date getDateOfOrder();
	public int getIdOfRealizationTerm();
	public Date getDateOfModification();
	public String getOrderStatus();
	public int getIdService();
	public int getClientId();	
	public Date getRealizationDate();
	public String getService();
	public String getOrderTitle();
	public void setOrderTitle(String orderTitle);
    public String getOrderAddress();
	public void setOrderAddress(String orderAddress);
	public String getOrderPlace();
	public void setOrderPlace(String orderPlace);
	public int getEmployeeId();
	public int getBonus();
	public void setBonus(int bonus);
	public String getStatusPl();
}