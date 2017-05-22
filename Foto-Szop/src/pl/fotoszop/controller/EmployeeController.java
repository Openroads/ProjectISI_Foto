package pl.fotoszop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.EmployeeDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.dao.TermDAO;
import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.model.Employee;
import pl.fotoszop.modelinterfaces.ITerm;

@Controller
public class EmployeeController {
	
	@Autowired TermDAODbImpl termDAO;
	@RequestMapping("/termList")
	public ModelAndView showList(@SessionAttribute Employee employee)
	{
		List<ITerm> termList = termDAO.getCurrentTermsForEmployee(employee);
		ModelAndView model = new ModelAndView("employeeAddTerm");
		TermFormtDTO form = new TermFormtDTO();
		model.addObject("termForm",form);
		model.addObject("termList",termList);
		
		return model;
		
	}
	
	@RequestMapping("/addTerm")
	public ModelAndView showList(@ModelAttribute("newTerm")@Valid TermFormtDTO newTerm,BindingResult result)
	{
		ModelAndView model = new ModelAndView("employeeAddTerm");
		if(result.hasErrors())
		{
			model.addObject("termForm",newTerm);
		}else
		{
			termDAO.addNewTerm(newTerm);
		}
		return null;
	}
	
}
