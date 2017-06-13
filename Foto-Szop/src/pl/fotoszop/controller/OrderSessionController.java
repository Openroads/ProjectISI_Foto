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
import pl.fotoszop.constants.Constants;
import pl.fotoszop.dto.OrderSessionFormDTO;
import pl.fotoszop.model.Client;
import pl.fotoszop.model.Order;
import pl.fotoszop.modelinterfaces.ITerm;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"client", "account"})
public class OrderSessionController {

    private static final Logger logger = LoggerFactory.getLogger(OrderSessionController.class.getName());

    @Autowired
    private TermDAODbImpl termDAO;

    @Autowired
    private OrderDAODbImpl orderDatabaseDAO;


    @RequestMapping(value = "/orderSession", method = RequestMethod.POST)
    public ModelAndView processForm(@SessionAttribute("client") Client client, @ModelAttribute("form") @Valid OrderSessionFormDTO form, BindingResult result) {

        ModelAndView model = null;
        if (result.hasErrors()) {
            logger.error("Error with ordering session");
            List<ITerm> termList = termDAO.getFreeTermsFromDate(LocalDate.now());
            model = new ModelAndView("orderSession");
            Collections.sort(termList, (term1, term2) -> term1.getDate().compareTo(term2.getDate()));
            model.addObject("termList", termList);
        } else {


            Order order = new Order(form);
            order.setClientId(client.getId());
            order.setDateOfOrder(new Date());
            order.setIdService(Constants.SERVICE_SESJA);
            order.setOrderStatus(Constants.PENDING);
            order.setIdOfRealizationTerm(form.getTermId());

            orderDatabaseDAO.saveOrUpdate(order);

            model = new ModelAndView("sessionOrderSuccess");
        }


        model.addObject("form", form);
        return model;

    }


    @RequestMapping("/session")
    public ModelAndView getForm(@SessionAttribute("client") Client client) {

        ModelAndView model;

        List<ITerm> termList = termDAO.getFreeTermsFromDate(LocalDate.now());
        model = new ModelAndView("/orderSession");

        model.addObject("form", new OrderSessionFormDTO());

        Collections.sort(termList, Comparator.comparing(ITerm::getDate));
        model.addObject("termList", termList);

        logger.debug("List of terms in session order page has been loaded succesfully");
        return model;
    }
}

