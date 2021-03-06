package pl.fotoszop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.OrderDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.model.Employee;
import pl.fotoszop.modelinterfaces.IOrder;
import pl.fotoszop.modelinterfaces.ITerm;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

    @Autowired
    TermDAODbImpl termDAO;
    
    @Autowired
    OrderDAODbImpl orderDAO;

    @RequestMapping("/termList")
    public ModelAndView showList(@SessionAttribute Employee employee) {
        List<ITerm> termList = termDAO.getCurrentTermsForEmployee(employee);
        ModelAndView model = new ModelAndView("employeeAddTerm");
        TermFormtDTO form = new TermFormtDTO();
        form.setEmployeeId((int) employee.getId());
        model.addObject("termForm", form);
        model.addObject("termList", termList);

        return model;

    }
    
    @RequestMapping("/acceptOrder")
    public ModelAndView acceptOrder(@SessionAttribute Employee employee, HttpServletRequest request){
    	
    	int orderId = Integer.parseInt(request.getParameter("orderId"));
    	orderDAO.update(orderId, "IN_REALIZTION"); 
    	ModelAndView model = new ModelAndView("employeeReceiveOrder");
        List<IOrder> orderList = orderDAO.getAllOrders(employee);
        List<IOrder> orderSessionList = new ArrayList<>();
        List <IOrder> orderPhotoList = new ArrayList<>();
        orderList.stream().filter(o -> o.getOrderStatus().equals("PENDING"))
         				.filter(o -> o.getIdService() == 1).forEach(orderSessionList::add);
         
        orderList.stream().filter(o -> o.getOrderStatus().equals("PENDING"))
         					.filter(o -> o.getIdService() == 2).forEach(orderPhotoList::add);
         
        model.addObject("orderSessionList", orderSessionList);
        model.addObject("orderPhotoList",orderPhotoList);
        return model;
    }
    
    
    @RequestMapping("/finish")
    public ModelAndView finishOrder(@SessionAttribute Employee employee, HttpServletRequest request){
    	
    	int orderId = Integer.parseInt(request.getParameter("orderId"));
    	orderDAO.update(orderId, "FINISHED"); 
    	ModelAndView model = new ModelAndView("employeeReceivedOrders");
        List<IOrder> orderList = orderDAO.getAllOrders(employee);
        List<IOrder> orderSessionList = new ArrayList<>();
        List <IOrder> orderPhotoList = new ArrayList<>();
        orderList.stream().filter(o -> o.getOrderStatus().equals("IN_REALIZTION"))
         				.filter(o -> o.getIdService() == 1).forEach(orderSessionList::add);
         
        orderList.stream().filter(o -> o.getOrderStatus().equals("IN_REALIZTION"))
         					.filter(o -> o.getIdService() == 2).forEach(orderPhotoList::add);
         
        model.addObject("orderSessionList", orderSessionList);
        model.addObject("orderPhotoList",orderPhotoList);
        return model;
    }
    
    
    @RequestMapping("/receiveOrders")
    public ModelAndView showNotReceivedOrders(@SessionAttribute Employee employee) {   
        ModelAndView model = new ModelAndView("employeeReceiveOrder");
        List<IOrder> orderList = orderDAO.getAllOrders(employee);
        List<IOrder> orderSessionList = new ArrayList<>();
        List <IOrder> orderPhotoList = new ArrayList<>();
        orderList.stream().filter(o -> o.getOrderStatus().equals("PENDING"))
        				.filter(o -> o.getIdService() == 1).forEach(orderSessionList::add);
        
        orderList.stream().filter(o -> o.getOrderStatus().equals("PENDING"))
        					.filter(o -> o.getIdService() == 2).forEach(orderPhotoList::add);
        
        model.addObject("orderSessionList", orderSessionList);
        model.addObject("orderPhotoList",orderPhotoList);
        return model;

    }
    @RequestMapping("/receivedOrders")
    public ModelAndView showReceivedOrders(@SessionAttribute Employee employee) {
        ModelAndView model = new ModelAndView("employeeReceivedOrders");
        List<IOrder> orderList = orderDAO.getAllOrders(employee);
        List<IOrder> orderSessionList = new ArrayList<>();
        List <IOrder> orderPhotoList = new ArrayList<>();
        orderList.stream().filter(o -> o.getOrderStatus().equals("IN_REALIZTION"))
        				.filter(o -> o.getIdService() == 1).forEach(orderSessionList::add);
        
        orderList.stream().filter(o -> o.getOrderStatus().equals("IN_REALIZTION"))
        					.filter(o -> o.getIdService() == 2).forEach(orderPhotoList::add);
        
        model.addObject("orderSessionList", orderSessionList);
        model.addObject("orderPhotoList",orderPhotoList);

        return model;

    }

    @RequestMapping("/addTerm")
    public ModelAndView showList(@SessionAttribute Employee employee, @ModelAttribute("termForm") @Valid TermFormtDTO termForm, BindingResult result) {
        ModelAndView model = new ModelAndView("employeeAddTerm");
        System.out.println(termForm.getDate());
        
        if (result.hasErrors()) {
            logger.error(employee.getEmail() + " couldn't load terms");
            List<ITerm> termList = termDAO.getCurrentTermsForEmployee(employee);
            model.addObject("termForm", termForm);
            model.addObject("termList", termList);
            return model;
        } else {
            termForm.setEmployeeId((int) employee.getId());
            termDAO.addNewTerm(termForm);
            logger.info(employee.getEmail() + " has inserted term");
        }
        return new ModelAndView("redirect:/termList");
    }

    @RequestMapping(value = "/deleteTerm", method = RequestMethod.POST)
    public ModelAndView deleteTerm(@RequestParam String termToDelete) {

        int idTermToDelete = Integer.valueOf(termToDelete);
        if (idTermToDelete > 0 && termDAO.deleteTerm(idTermToDelete)) {
            logger.info("Redirecting to term list for deleting");
            return new ModelAndView("redirect:/termList");

        } else {
            //TODO przekierować do strony ostrzegawczej z przekierowaniem na glowna + logi
            String message = "Coś poszło nie tak... Nie możemy usunąćc tego terminu.";
            logger.error("Cannot delete this term");
            ModelAndView model = new ModelAndView("error");
            model.addObject("error", message);
            return model;
        }


    }

}
