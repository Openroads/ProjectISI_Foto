package pl.fotoszop.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
	
	@RequestMapping("/main.html")
	public ModelAndView helloworld(){
		
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