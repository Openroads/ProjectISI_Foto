package pl.fotoszop.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.model.Form;
import pl.fotoszop.modelinterfaces.IClient;
import pl.fotoszop.model.Client;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.mocks.ClientDAOMock;

@Controller
public class RegisterController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	
	@RequestMapping("/addClient")
	public ModelAndView processForm(@ModelAttribute Form form){
		
		ClientDAO database = new ClientDAOMock();
		boolean flag = form.checkToRegister(database);
		//boolean flag = checkDatabase(form,database);
		if(!flag){
			
			//Client newClient = new Client(1,form.getName(),form.getSurname(),form.getAddress(),form.getIdentityNumber(),form.getPhoneNumber(),form.getEmail());
			Client newClient = new Client(form);
			database.saveOrUpdate(newClient);
			ModelAndView model = new ModelAndView("success");
			model.addObject("client",newClient);
			return model;
		}
		else{
			ModelAndView model = new ModelAndView("Fail");
			return model;
		}
		
	}
	
	@RequestMapping("/register")
	public ModelAndView getForm(){
		
		ModelAndView model = new ModelAndView("register");
		model.addObject("form", new Form());
		return model;
	}
	
	

}
