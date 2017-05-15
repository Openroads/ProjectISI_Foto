package pl.fotoszop.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.dto.LoginFormDTO;
import pl.fotoszop.modelinterfaces.IAccount;
import pl.fotoszop.modelinterfaces.IClient;

@Controller
public class HelloController{
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	@Autowired
	private AccountDAODbImpl aclientDatabaseDAO;
	
	@RequestMapping(value ={ "/index","/"}, method = RequestMethod.GET)
	public ModelAndView showIndex(){

		ModelAndView model = new ModelAndView("index");
		model.addObject("loginForm",new LoginFormDTO());
		
		return model;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView handleLogin(@ModelAttribute("loginForm")@Valid LoginFormDTO form, BindingResult result){
		ModelAndView model = null;
		
		if(result.hasErrors())
		{
			model = new ModelAndView("index");
			model.addObject("loginForm",form);
		}
		else
		{
			String login = form.getLogin();
			String password = form.getPassword();
			//TODO NIE ZNAJDUJE PLIKU XML
			//ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");
			
			//AccountDAO accountDAO = (AccountDAO) context.getBean("accountDAODbImpl");
			System.out.println(clientDatabaseDAO);
			model = new ModelAndView("index");
			System.out.println("no errors");
			System.out.println(form.getPassword());
			model.addObject("loginForm",new LoginFormDTO());
		}
		
		return model;
	}
	
	
	
	
	
	
}