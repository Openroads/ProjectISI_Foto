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


import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.DAODbImpl.EmployeeDAODbImpl;
import pl.fotoszop.dto.LoginFormDTO;
import pl.fotoszop.modelinterfaces.IAccount;
import pl.fotoszop.modelinterfaces.IClient;
import pl.fotoszop.modelinterfaces.IEmployee;

@Controller
@SessionAttributes({"account", "client","employee"})
public class LoginController {
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	@Autowired
	private EmployeeDAODbImpl employeeDatabaseDAO;
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

		}
		else
		{
			form.doHash();
			System.out.println(form.getPassword());
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
				
				if(account.getClientId() !=0 && account.getEmployeeId() == 0)
				{
					IClient client = clientDatabaseDAO.getClientById(account.getClientId());
					model = new ModelAndView("account");
					model.addObject("account",account);
					model.addObject("client", client);
				}
				else if(account.getEmployeeId() !=0 && account.getClientId() == 0)
				{
					IEmployee employee = employeeDatabaseDAO.getEmployeeById(account.getEmployeeId());
					model = new ModelAndView("employeeAccount");
					model.addObject("account",account);
					model.addObject("employee",employee);
				}
				else
				{
					model = new ModelAndView("redirect:/index");
				}
				
			}
		}
		
		return model;
	}
	
}
