package pl.fotoszop.model;

import java.util.Date;

import pl.fotoszop.dto.OrderSessionFormDTO;
import pl.fotoszop.modelinterfaces.IOrder;

public class Order implements IOrder{

	private int idOrder;
	private Date dateOfOrder;
	private String idOfRealizationTerm;
	private Date dateOfModification;
	private String orderStatus;
	private int idService;
	private int idClient;

	public Order()
	{
	}

	public Order(int idOrder,
			     Date dateOfOrder,
			     String idOfRealizationTerm,
			     Date dateOfModification,
			     String orderStatus,
			     int idService,
			     int idClient) {

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
	public void setOrderId(int id) {
		this.idOrder = id;
	}

	@Override
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	@Override
	public void setIdOfRealizationTerm(String termId) {
		this.idOfRealizationTerm = termId;
	}

	@Override
	public void setDateOfModification(Date dateOfModification) {
		this.dateOfModification = dateOfModification;
	}

	@Override
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public void setServiceId(int serviceId) {
		this.idService = serviceId;
	}

	@Override
	public void setClientId(int clientId) {
		this.idClient = clientId;
	}

	@Override
	public int getOrderId() {
		return this.idOrder;
	}

	@Override
	public Date getDateOfOrder() {
		return this.dateOfOrder;
	}

	@Override
	public String getIdOfRealizationTerm() {
	return this.idOfRealizationTerm;
	}

	@Override
	public Date getDateOfModification() {
	return this.dateOfModification;
	}

	@Override
	public String getOrderStatus() {
	return this.orderStatus;
	}

	@Override
	public int getServiceId() {
	return this.idService;
	}

	@Override
	public int getClientId() {
	return this.idClient;
	}
}
