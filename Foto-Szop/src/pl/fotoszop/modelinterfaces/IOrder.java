package pl.fotoszop.modelinterfaces;

import java.sql.Date;

public interface IOrder {
	
	public void setOrderId(String id);
	public void setDateOfOrder(Date dateOfOrder);
	public void setIdOfRealizationTerm(String termId);
	public void setDateOfModification(Date dateOfModification);
	public void setOrderStatus(String orderStatus);
	public void setServiceId(String serviceId);
	public void setClientId(String clientId);

	
	public String getOrderId();
	public Date getDateOfOrder();
	public String getIdOfRealizationTerm();
	public Date getDateOfModification();
	public String getOrderStatus();
	public String getServiceId();
	public String getClientId();	
}