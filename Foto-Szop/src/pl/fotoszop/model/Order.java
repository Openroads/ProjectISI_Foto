package pl.fotoszop.model;

import pl.fotoszop.modelinterfaces.IOrder;

public class Order implements IOrder{
	
	private String idOrder;
	private String dateOfOrder;
	private String idOfRealizationTerm;
	private String dateOfModification;
	private String orderStatus;
	private String idService;
	private String idClient;
	
	public Order()
	{	
	}

	public Order(String idOrder,
			     String dateOfOrder,
			     String idOfRealizationTerm,
			     String dateOfModification,
			     String orderStatus,
			     String idService,
			     String idClient) {

		this.idOrder = idOrder;
		this.dateOfOrder = dateOfOrder;
		this.idOfRealizationTerm = idOfRealizationTerm;
		this.dateOfModification = dateOfModification;
		this.orderStatus = orderStatus;
		this.idService = idService;
		this.idClient = idClient;
	}
	
	@Override
	public String toString() {
		return "Order [idOrder="+ idOrder + 
			   ", dateOfOrder=" + dateOfOrder +
			   ", idOfRealizationTerm=" + idOfRealizationTerm + 
			   ", dateOfModification=" + dateOfModification + 
			   ", orderStatus=" + orderStatus + 
			   ", idService=" + idService + 
			   ", idClient=" + idClient + "]";
	}

	@Override
	public void setOrderId(String id) {
		this.idOrder = id;		
	}

	@Override
	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	@Override
	public void setIdOfRealizationTerm(String termId) {
		this.idOfRealizationTerm = termId;
	}

	@Override
	public void setDateOfModification(String dateOfModification) {
		this.dateOfModification = dateOfModification;		
	}

	@Override
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public void setServiceId(String serviceId) {
		this.idService = serviceId;
	}

	@Override
	public void setClientId(String clientId) {
		this.idClient = clientId;
	}

	@Override
	public String getOrderId() {
		return this.idOrder;
	}

	@Override
	public String getDateOfOrder() {
		return this.dateOfOrder;
	}

	@Override
	public String getIdOfRealizationTerm() {
	return this.idOfRealizationTerm;
	}

	@Override
	public String getDateOfModification() {
	return this.dateOfModification;
	}

	@Override
	public String getOrderStatus() {
	return this.orderStatus;
	}

	@Override
	public String getServiceId() {
	return this.idService;
	}

	@Override
	public String getClientId() {
	return this.idClient;
	}	
}
