package pl.fotoszop.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.dto.LoginFormDTO;


@Controller
public class HelloController{
	
//	@Autowired
//	private ClientDAODbImpl clientDatabaseDAO;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
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
			
			model = new ModelAndView("index");
			System.out.println("no errors");
			System.out.println(form.getPassword());
			model.addObject("loginForm",new LoginFormDTO());
		}
		
		return model;
	}
	
	
	
	
	
	
}