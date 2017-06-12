package pl.fotoszop.modelinterfaces;

public interface IOrder {
	
	public void setOrderId(String id);
	public void setDateOfOrder(String dateOfOrder);
	public void setIdOfRealizationTerm(String termId);
	public void setDateOfModification(String dateOfModification);
	public void setOrderStatus(String orderStatus);
	public void setServiceId(String serviceId);
	public void setClientId(String clientId);

	
	public String getOrderId();
	public String getDateOfOrder();
	public String getIdOfRealizationTerm();
	public String getDateOfModification();
	public String getOrderStatus();
	public String getServiceId();
	public String getClientId();	
}