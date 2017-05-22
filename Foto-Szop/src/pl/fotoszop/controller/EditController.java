package pl.fotoszop.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class EditController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	@Autowired
	private AccountDAODbImpl aclientDatabaseDAO;
	
	@RequestMapping("/editClient")
	public ModelAndView processForm(@ModelAttribute Form form){
		
		//ClientDAO database = new ClientDAODbImpl();
		//AccountDAO databaseAccount = new AccountDAODbImpl();
		form.doHash();
		boolean flag = clientDatabaseDAO.checkToRegister(form);
		boolean flag2 = form.checkPasswords();
		//boolean flag = checkDatabase(form,database);
		if((!flag)&&flag2){
			
			Client newClient = new Client(form);
			Account newAccount = new Account(form);
			clientDatabaseDAO.saveOrUpdate(newClient);
			aclientDatabaseDAO.saveOrUpdate(newAccount);
			ModelAndView model = new ModelAndView("success");
			model.addObject("client",newClient);
			return model;
		}
		else{
			ModelAndView model = new ModelAndView("Fail");
			return model;
		}
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView getForm(){
		
		ModelAndView model = new ModelAndView("edit");
		model.addObject("form", new Form());
		return model;
	}
}
	
	