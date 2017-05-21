package pl.fotoszop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.model.Employee;

@Controller
public class EmployeeController {
	
	@RequestMapping("/termList")
	public ModelAndView showTermList(@SessionAttribute Employee employee)
	{
		
		return new ModelAndView("/employeeAddTerm");
		
	}

}
