package pl.fotoszop.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dto.LoginFormDTO;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Form;
import pl.fotoszop.modelinterfaces.IAccount;
import pl.fotoszop.modelinterfaces.IClient;

@Controller
@SessionAttributes({"account", "client"})
public class LoginController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	@Autowired
	private AccountDAODbImpl aclientDatabaseDAO;

	
	
	@RequestMapping(value ="/logout")
	public ModelAndView logOut(HttpSession session){
		ModelAndView model = null;
		
		session.invalidate();
		
		model = new ModelAndView("/index");
		return model;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView getAccess(@ModelAttribute("loginForm")@Valid LoginFormDTO form, BindingResult result){
		
		
		ModelAndView model = null;
		
		if(result.hasErrors())
		{
			model = new ModelAndView("/index");
			model.addObject("loginForm",form);
			//redirectAttributes.addFlashAttribute("loginForm", form);
		}
		else
		{
			form.doHash();
			int r = aclientDatabaseDAO.checkToLogin(form);
			if(r == 0){
				System.out.println("B�edne has�o");
				form.setPassword("");
				int failed = 1;
				model = new ModelAndView("/index");
				result.rejectValue("password", "errCodePassword","Podane hasło jest nie prawidłowe");
				
				model.addObject("failed", failed);
				model.addObject("loginForm",form);
				
			} else if(r == -1){
				System.out.println("B�edny mail");
				model = new ModelAndView("/index");
				int failed = 1;
				result.rejectValue("login", "errorCodeLogin","Konto o podanym E-mail nie istnieje.");
				form.setPassword(null);
				model.addObject("failed", failed);
				model.addObject("loginForm",form);
			}else if(r == 1){
				IAccount account = aclientDatabaseDAO.getAccount(form);
				IClient client = clientDatabaseDAO.getClientById(account.getClientId());
				model = new ModelAndView("account");
				model.addObject("account",account);
				model.addObject("client", client);
			}
			  
		}
		
		return model;
	}
	
}
