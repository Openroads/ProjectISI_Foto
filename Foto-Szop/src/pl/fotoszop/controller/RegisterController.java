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

import pl.fotoszop.modelinterfaces.IClient;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Client;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.dto.Form;
import pl.fotoszop.mocks.ClientDAOMock;

@Controller
@SessionAttributes({"client","account"})
public class RegisterController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	@Autowired
	private AccountDAODbImpl aclientDatabaseDAO;
	
	@RequestMapping(value="/addClient", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("form")@Valid Form form, BindingResult result){
		
		ModelAndView model = null;
		
		if(result.hasErrors()){
			
			model=new ModelAndView("register");
			model.addObject("form",  form);
			return model;
		}
		else{
			
		form.doHash();
		
		boolean flag = clientDatabaseDAO.checkToRegister(form);
		boolean flag2 = form.checkPasswords();
		
		if((!flag)&&flag2){
			
			//Client newClient = new Client(1,form.getName(),form.getSurname(),form.getAddress(),form.getIdentityNumber(),form.getPhoneNumber(),form.getEmail());
			Client newClient = new Client(form);
			Account newAccount = new Account(form);
			clientDatabaseDAO.saveOrUpdate(newClient);
			aclientDatabaseDAO.saveOrUpdate(newAccount);
			
			model = new ModelAndView("success");
			model.addObject("client",newClient);
			model.addObject("account",newAccount);
			return model;
		}
		else{
			
			model = new ModelAndView("register");
			model.addObject("form",new Form());
			return model;
		}
		}
	}
	
	@RequestMapping("/register")
	public ModelAndView getForm(HttpSession session){
		
			ModelAndView model;
		
			if(session.getAttribute("account")!=null) session.invalidate();
		
			model = new ModelAndView("register");
			model.addObject("form", new Form());
		
		return model;
	}
	
	

}
