package pl.fotoszop.model;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.DAODbImpl.TermMapper;
import pl.fotoszop.constants.Constants;
import pl.fotoszop.modelinterfaces.IOrder;
import pl.fotoszop.modelinterfaces.ITerm;



@Component
public class OrderParser extends Order {
	
	
	private Date realizationDate;
	private String service;
    private JdbcTemplate jdbcTemplate;

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


	
	public List<IOrder> getTermDates(List<IOrder> orderList){
		
		for(Iterator<IOrder> order = orderList.iterator(); order.hasNext();)
		{
			IOrder item = order.next();
			int termId = item.getIdOfRealizationTerm();
			int serviceId = item.getIdService();
			
			Term term =  getTermByIdParser(termId);
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
	
	
	public Term getTermByIdParser(int id) {
		
        String sqlQuery = "select * from term where term.id_term = " + id;
        Term term = this.jdbcTemplate.queryForObject(sqlQuery, new TermMapper());
        System.out.println(term);
        return term;	    
}
	
}
