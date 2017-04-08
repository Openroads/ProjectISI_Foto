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
import pl.fotoszop.model.EditForm;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.mocks.ClientDAOMock;

@Controller
public class EditController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	
	@RequestMapping("/editClient")
	public ModelAndView processForm(@ModelAttribute EditForm editForm){
		
		ClientDAOMock database = new ClientDAOMock();
		boolean flag = checkDatabase(editForm,database);
		if(flag){
			
			// Need to create session data to take ID and check if this client exist and if he can maintain edit on his account.
			 Client editedClient = new Client(1,editForm.getName(),editForm.getSurname(),editForm.getAddress(),editForm.getIdentityNumber(),editForm.getPhoneNumber(),"email from session");
			database.saveOrUpdate(editedClient);
			ModelAndView model = new ModelAndView("success");
			model.addObject("client",editedClient);
			return model;
		}
		else{
			ModelAndView model = new ModelAndView("Fail");
			return model;
		}
		
	}
	
	@RequestMapping("/edycja.html")
	public ModelAndView getForm(){
		
		ModelAndView model = new ModelAndView("Edit");
		model.addObject("editForm", new EditForm());
		return model;
	}
	
	public boolean checkDatabase(EditForm editForm, ClientDAOMock database){
		Collection<IClient> clients = new ArrayList<>();
		clients = database.getAllContacts();
		
		for(IClient object: clients)
		{
		//	if(object.getEmail().equals(editForm.getEmail()))  // Session need to appear here
				return true;
		}
		return false;	
	}		
}
	
