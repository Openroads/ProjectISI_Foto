package pl.fotoszop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.EmployeeDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.dao.TermDAO;
import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.model.Employee;
import pl.fotoszop.model.Term;
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
		form.setEmployeeId((int)employee.getId());
		model.addObject("termForm",form);
		model.addObject("termList",termList);
		
		return model;
		
	}
	
	@RequestMapping("/addTerm")
	public ModelAndView showList(@SessionAttribute Employee employee, @ModelAttribute("termForm")@Valid TermFormtDTO termForm,BindingResult result)
	{
		ModelAndView model = new ModelAndView("employeeAddTerm");
		if(result.hasErrors())
		{
			List<ITerm> termList = termDAO.getCurrentTermsForEmployee(employee);
			model.addObject("termForm",termForm);
			model.addObject("termList",termList);
			return model;
		}else
		{
			termForm.setEmployeeId((int)employee.getId());
			termDAO.addNewTerm(termForm);
		}
		return new ModelAndView("redirect:/termList");
	}
	
	@RequestMapping(value ="/deleteTerm", method=RequestMethod.POST)
	public ModelAndView deleteTerm(@RequestParam String termToDelete)
	{

		int idTermToDelete = Integer.valueOf(termToDelete);
		if(idTermToDelete > 0 && termDAO.deleteTerm(idTermToDelete))
		{
			return new ModelAndView("redirect:/termList");

		}else
		{
			//TODO przekierować do strony ostrzegawczej z przekierowaniem na glowna + logi
			return new ModelAndView("redirect:/index");
		}
		
		
	}
	
}
