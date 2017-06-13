package pl.fotoszop.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.OrderDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.constants.Constants;
import pl.fotoszop.model.Client;
import pl.fotoszop.model.OrderParser;
import pl.fotoszop.model.Term;
import pl.fotoszop.modelinterfaces.IOrder;

@Controller
public class OrderController {

	@Autowired
    OrderDAODbImpl orderDAO;
	
	@Autowired
    TermDAODbImpl termDAO;
	
	
	
	 @RequestMapping("/order")
	    public ModelAndView showList(@SessionAttribute Client client) {
	        List<IOrder> rawOrderList = orderDAO.getAllOrders(client.getId());
	        List<IOrder> orderList = getTermDates(rawOrderList);
	        ModelAndView model = new ModelAndView("order");
 	        model.addObject("orderList", orderList);
	        return model;
	    }
	 
	 
	 public List<IOrder> getTermDates(List<IOrder> orderList){
			
			for(Iterator<IOrder> order = orderList.iterator(); order.hasNext();)
			{
				IOrder item = order.next();
				int termId = item.getIdOfRealizationTerm();
				int serviceId = item.getIdService();
				
				Term term =  termDAO.getTermById(termId);
				item.setRealizationDate(term.getDate());
				
				if(serviceId == Constants.SERVICE_SESJA)
				{
					item.setService("SESJA");
				}
				else if(serviceId == Constants.SERVICE_OBROBKA)
				{
					item.setService("OBRÓBKA");
				}
				
			}
			
			return orderList;
		}
	 
}