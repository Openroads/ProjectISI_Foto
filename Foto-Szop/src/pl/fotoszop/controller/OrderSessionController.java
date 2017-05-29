package pl.fotoszop.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.modelinterfaces.IClient;
import pl.fotoszop.modelinterfaces.ITerm;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Client;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.dto.Form;
import pl.fotoszop.dto.OrderSessionFormDTO;
import pl.fotoszop.mocks.ClientDAOMock;

@Controller
@SessionAttributes({"client","account"})
public class OrderSessionController {
	
	@Autowired 
	private TermDAODbImpl termDAO;
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	@Autowired
	private AccountDAODbImpl aclientDatabaseDAO;
	
	@RequestMapping(value="/orderSession", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("form")@Valid OrderSessionFormDTO form, BindingResult result){
		
		ModelAndView model = null;
			if(result.hasErrors()){
				
			}
			else {
				
			} 
			model=new ModelAndView("orderSession");
			return model.addObject("form",  form);
	
		}
		
	
	@RequestMapping("/session")
	public ModelAndView getForm(@SessionAttribute("client") Client client){
		
			ModelAndView model;
			
			List<ITerm> termList = termDAO.getFreeTermsFromDate(LocalDate.now());
			model = new ModelAndView("/orderSession");
			
			model.addObject("form", new OrderSessionFormDTO());
			
			Collections.sort(termList,(term1,term2)->term1.getDate().compareTo(term2.getDate()));
			model.addObject("termList",termList);
		return model;
	}
}
	
