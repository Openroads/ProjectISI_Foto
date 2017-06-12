package pl.fotoszop.model;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.constants.Constants;
import pl.fotoszop.modelinterfaces.IOrder;
import pl.fotoszop.modelinterfaces.ITerm;

public class OrderParser extends Order {
	
	private Date realizationDate;
	private String service;
	

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

	@Autowired
    private TermDAODbImpl termDAO;
	
	public List<IOrder> getTermDates(List<IOrder> orderList){
		
		for(Iterator<IOrder> order = orderList.iterator(); order.hasNext();)
		{
			IOrder item = order.next();
			int termId = item.getIdOfRealizationTerm();
			int serviceId = item.getIdService();
			
			String termIdk =""+ termId;
			ITerm term =  termDAO.getTermById(termId);
			realizationDate = term.getDate();
			
			if(serviceId == Constants.SERVICE_SESJA)
			{
				service = "SESJA";
			}
			else if(serviceId == Constants.SERVICE_OBROBKA)
			{
				service = "OBRÓBKA";
			}
			
		}
		
		return orderList;
	}
}
