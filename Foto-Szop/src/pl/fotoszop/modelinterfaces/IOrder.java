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

	
	public int getIdOrder();
	public Date getDateOfOrder();
	public int getIdOfRealizationTerm();
	public Date getDateOfModification();
	public String getOrderStatus();
	public int getIdService();
	public int getClientId();	
}