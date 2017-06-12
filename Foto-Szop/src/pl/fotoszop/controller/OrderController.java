package pl.fotoszop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.OrderDAODbImpl;
import pl.fotoszop.model.Client;
import pl.fotoszop.modelinterfaces.IOrder;

@Controller
public class OrderController {


    OrderDAODbImpl orderDAO;
	
	
	 @RequestMapping("/order")
	    public ModelAndView showList(@SessionAttribute Client client) {
	        List<IOrder> orderList = orderDAO.getAllOrders(client.getId());
	        ModelAndView model = new ModelAndView("order");
	        if(!orderList.isEmpty())
	        {
	 	        model.addObject("termList", orderList);
	        }
	        return model;
	    }
}