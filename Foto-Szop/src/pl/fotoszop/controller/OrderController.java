package pl.fotoszop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.OrderDAODbImpl;
import pl.fotoszop.model.Client;
import pl.fotoszop.model.OrderParser;
import pl.fotoszop.modelinterfaces.IOrder;

@Controller
public class OrderController {

	@Autowired
    OrderDAODbImpl orderDAO;
	
	
	 @RequestMapping("/order")
	    public ModelAndView showList(@SessionAttribute Client client) {
	        List<IOrder> rawOrderList = orderDAO.getAllOrders(client.getId());
	        OrderParser parser = new OrderParser();
	        List<IOrder> orderList = parser.getTermDates(rawOrderList);
	        ModelAndView model = new ModelAndView("order");
 	        model.addObject("orderList", orderList);
	        return model;
	    }
}