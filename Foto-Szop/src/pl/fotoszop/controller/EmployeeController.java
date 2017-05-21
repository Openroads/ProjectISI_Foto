package pl.fotoszop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.EmployeeDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.dao.TermDAO;
import pl.fotoszop.model.Employee;
import pl.fotoszop.modelinterfaces.ITerm;

@Controller
public class EmployeeController {
	
	@Autowired TermDAODbImpl termDAO;
	@RequestMapping("/termList")
	public ModelAndView showTermList(@SessionAttribute Employee employee)
	{
		List<ITerm> termList = termDAO.getCurrentTermsForEmployee(employee);
		ModelAndView model = new ModelAndView("employeeAddTerm");
	
		
		model.addObject("termList",termList);
		
		return model;
		
	}

}
