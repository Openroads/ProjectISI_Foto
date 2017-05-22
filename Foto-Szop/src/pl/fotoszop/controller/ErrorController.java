package pl.fotoszop.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dto.Form;
import pl.fotoszop.mocks.ClientDAOMock;
import pl.fotoszop.model.Client;
import pl.fotoszop.modelinterfaces.IClient;

@Controller
public class ErrorController{
	
//	@Autowired
//	private ClientDAODbImpl clientDatabaseDAO;
	
	@RequestMapping("/error")
	public ModelAndView helloworld(String error){
		ModelAndView model = new ModelAndView("error");
		error="Najgorszy błąd na świecie...";
		model.addObject("error", error);
		return model;
	}
	
	
	
	
	
}