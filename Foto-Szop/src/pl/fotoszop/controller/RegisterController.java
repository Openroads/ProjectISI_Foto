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
import pl.fotoszop.mocks.ClientDAOMock;

@Controller
public class RegisterController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	
	@RequestMapping("/addClient")
	public ModelAndView processForm(@ModelAttribute Form form){
		
		ClientDAOMock database = new ClientDAOMock();
		boolean flag = checkDatabase(form,database);
		if(!flag){
			
			Client newClient = new Client(1,form.getName(),form.getSurname(),form.getAddress(),form.getIdentityNumber(),form.getPhoneNumber(),form.getEmail());
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
	
	@RequestMapping("/rejestracja.html")
	public ModelAndView getForm(){
		
		ModelAndView model = new ModelAndView("Register");
		model.addObject("form", new Form());
		return model;
	}
	
	public boolean checkDatabase(Form form, ClientDAOMock database){
		
		
		Collection<IClient> clients = new ArrayList<>();
		clients = database.getAllContacts();
		
		for(IClient object: clients)
		{
			if(object.getEmail().equals(form.getEmail())) 
				return true;
		}
		return false;
	}

}
