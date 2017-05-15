package pl.fotoszop.controller;

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

@Controller
@SessionAttributes("account")
public class LoginController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	@Autowired
	private AccountDAODbImpl aclientDatabaseDAO;
	
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
			String login = form.getLogin();
			String password = form.getPassword();
			
			System.out.println("no errors");
			System.out.println(form.getPassword());
			form.doHash();
			
			int r = form.checkToLogin(aclientDatabaseDAO);
			if(r == 0){
				System.out.println("B�edne has�o");
				model = new ModelAndView("/index");
				result.rejectValue("password", "errCodePassword","Podane hasło jest nie prawidłowe");
				model.addObject("loginForm",form);
			} else if(r == -1){
				System.out.println("B�edny mail");
				model = new ModelAndView("/index");
				result.rejectValue("login", "errorCodeLogin","Konto o podanym email nie istnieje");
				model.addObject("loginForm",form);
			}else if(r == 1){
				IAccount account = form.getAccount(aclientDatabaseDAO);
				model = new ModelAndView("account");
				model.addObject("account",account);
			}
			  
		}
		
		return model;
	}
	
}
