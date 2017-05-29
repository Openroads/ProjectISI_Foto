package pl.fotoszop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dto.EditFormDTO;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Client;

@Controller
public class ClientController {
	
	@Autowired
	private ClientDAODbImpl clientDAO;
	@Autowired
	private AccountDAODbImpl aclientDAO;
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView getEditForm(@SessionAttribute Client client){
		
		ModelAndView model = new ModelAndView("edit");
		model.addObject("editForm", new EditFormDTO());
		return model;
	}
	
	
	@RequestMapping(value="/editClient", method=RequestMethod.POST)
	public ModelAndView editClient(@SessionAttribute Account account,@SessionAttribute Client client, @ModelAttribute("editForm")@Valid EditFormDTO editForm,BindingResult result){
		
		ModelAndView model = null;
		editForm.doHash();
		
		if(result.hasErrors())
		{
			model = new ModelAndView("/editForm");
			model.addObject("editForm",editForm);

		}
		else{
				if(editForm.getPassword().equals(account.getPassword())){
					
					if(!editForm.getPasswordNew().equals("") || !editForm.getAddress().equals("") || !editForm.getPhoneNumber().equals("")){
						
						clientDAO.updateClient(client,editForm);
						if(!editForm.getAddress().equals("")) 
							client.setAddress(editForm.getAddress());
						if(!editForm.getPhoneNumber().equals("")) 
							client.setPhoneNumber(editForm.getPhoneNumber());
						
						if(!editForm.getPasswordNew().equals("") && editForm.getPasswordNew().equals(editForm.getPasswordNew2()))
							aclientDAO.update(account,editForm);
						
						model = new ModelAndView("account");
						
					}
					else{
						model = new ModelAndView("edit");
						model.addObject("editForm",editForm);
					}
					
					//if(editForm.getAddress()!=null);
					//if(editForm.getPhoneNumber()!=null);
				}else{
					System.out.println("Bledne haslo");
					model = new ModelAndView("edit");
					model.addObject("editForm",editForm);
				}
		}
		return model;
	}


}
