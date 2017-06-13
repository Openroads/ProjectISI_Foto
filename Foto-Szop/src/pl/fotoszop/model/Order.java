package pl.fotoszop.model;

import java.util.Date;

import pl.fotoszop.dto.OrderSessionFormDTO;
import pl.fotoszop.modelinterfaces.IOrder;

public class Order extends OrderBase implements IOrder{

	private int idOrder;
	private Date dateOfOrder;
	private int idOfRealizationTerm;
	private Date dateOfModification;
	private String orderStatus;
	private int idService;
	private int idClient;
	private Date realizationDate;
	private String service;

	public Order()
	{
	}
	public Order(OrderSessionFormDTO form)
	{
		setOrderAddress(form.getSessionAddress());
		super.setOrderPlace(form.getSessionPlace());
		this.setOrderTitle(form.getSubject());
	}

	public Order(int idOrder,
			     Date dateOfOrder,
			     int idOfRealizationTerm,
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

	
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
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
	public void setIdOfRealizationTerm(int termId) {
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
	public void setIdService(int serviceId) {
		this.idService = serviceId;
	}

	@Override
	public void setClientId(int clientId) {
		this.idClient = clientId;
	}

	@Override
	public int getIdOrder() {
		return this.idOrder;
	}

	@Override
	public Date getDateOfOrder() {
		return this.dateOfOrder;
	}

	@Override
	public int getIdOfRealizationTerm() {
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
	public int getIdService() {
	return this.idService;
	}

	@Override
	public int getClientId() {
	return this.idClient;
	}
	
	
}
