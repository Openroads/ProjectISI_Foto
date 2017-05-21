package pl.fotoszop.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.model.Form;
import pl.fotoszop.modelinterfaces.IClient;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Client;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.mocks.ClientDAOMock;

@Controller
@SessionAttributes({"client","account"})
public class OrderPhotosController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	@Autowired
	private AccountDAODbImpl aclientDatabaseDAO;
	
	@RequestMapping(value="/orderPhotos", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("form")@Valid Form form, BindingResult result){
		
		ModelAndView model = null;
	
			model=new ModelAndView("orderPhotos");
			return model.addObject("form",  form);
	
		}
		
	
	@RequestMapping("/photos")
	public ModelAndView getForm(HttpSession session){
		
			ModelAndView model;
		
			model = new ModelAndView("/orderPhotos");
			model.addObject("form", new Form());
		
		return model;
	}
}
	