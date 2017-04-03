package pl.fotoszop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.model.Form;

@Controller
public class LoginController {

	@RequestMapping("/zaloguj.html")
	public ModelAndView getForm(){
		ModelAndView model = new ModelAndView("Zaloguj");
		model.addObject("form", new Form());
		return model;
	}
	
}
