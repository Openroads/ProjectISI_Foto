package pl.fotoszop.modelinterfaces;

import java.util.Date;

public interface IOrder {
	
	public void setOrderId(int id);
	public void setDateOfOrder(Date dateOfOrder);
	public void setIdOfRealizationTerm(String termId);
	public void setDateOfModification(Date dateOfModification);
	public void setOrderStatus(String orderStatus);
	public void setServiceId(int serviceId);
	public void setClientId(int clientId);

	
	public int getOrderId();
	public Date getDateOfOrder();
	public String getIdOfRealizationTerm();
	public Date getDateOfModification();
	public String getOrderStatus();
	public int getServiceId();
	public int getClientId();	
}