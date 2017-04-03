package pl.fotoszop.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.mocks.ClientDAOMock;
import pl.fotoszop.model.Client;
import pl.fotoszop.model.Form;
import pl.fotoszop.modelinterfaces.IClient;

@Controller
public class HelloController{
	
	@Autowired
	private ClientDAODbImpl clientDatabaseDAO;
	
	@RequestMapping("/main.html")
	public ModelAndView helloworld(){

		System.out.println(clientDatabaseDAO.getClientById(1).getEmail());
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","Hello guest!");
		
		return model;
	}
	
	@RequestMapping("/zaloguj.html")
	public ModelAndView zaloguj(){
		
		ModelAndView model = new ModelAndView("Zaloguj");
		model.addObject("msg","Zaloguj!");
		
		return model;
	}
	
	@RequestMapping("/kontakt.html")
	public ModelAndView kontakt(){
		
		ModelAndView model = new ModelAndView("/Kontakt");
		model.addObject("msg","Kontakt!");
		
		return model;
	}

	@RequestMapping("/cennik.html")
	public ModelAndView cennik(){
		
		ModelAndView model = new ModelAndView("/Cennik");
		model.addObject("msg","Cennik!");
		
		return model;
	}
	
	@RequestMapping("/about.html")
	public ModelAndView about(){
		
		ModelAndView model = new ModelAndView("/About");
		model.addObject("msg","O nas!");
		
		return model;
	}
	
	
	
	
	
	
}