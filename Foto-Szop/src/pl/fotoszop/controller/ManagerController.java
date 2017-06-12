package pl.fotoszop.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.dto.Form;
import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.model.Employee;
import pl.fotoszop.model.Manager;
import pl.fotoszop.modelinterfaces.ITerm;

@Controller
public class ManagerController {
	private static final Logger logger = Logger.getLogger(ManagerController.class.getName());

    @Autowired
    TermDAODbImpl termDAO;
    
    @RequestMapping("/employeeAdding")
    public ModelAndView showList(@SessionAttribute Manager manager) {
    	List<ITerm> employeeAdding = termDAO.getCurrentTermsForEmployee(manager);
    	ModelAndView model = new ModelAndView();
    	TermFormtDTO form = new TermFormtDTO();
    	form.setEmployeeId((int) manager.getId());
        model.addObject("termForm", form);
        model.addObject("employeeAdding", employeeAdding);
    	
		return model;

    }
	
}