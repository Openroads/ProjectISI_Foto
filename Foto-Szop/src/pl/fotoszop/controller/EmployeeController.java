package pl.fotoszop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.model.Employee;
import pl.fotoszop.modelinterfaces.ITerm;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

    @Autowired
    TermDAODbImpl termDAO;

    @RequestMapping("/termList")
    public ModelAndView showList(@SessionAttribute Employee employee) {
        List<ITerm> termList = termDAO.getCurrentTermsForEmployee(employee);
        ModelAndView model = new ModelAndView("employeeAddTerm");
        TermFormtDTO form = new TermFormtDTO();
        form.setEmployeeId((int) employee.getId());
        model.addObject("termForm", form);
        model.addObject("termList", termList);

        return model;

    }

    @RequestMapping("/addTerm")
    public ModelAndView showList(@SessionAttribute Employee employee, @ModelAttribute("termForm") @Valid TermFormtDTO termForm, BindingResult result) {
        ModelAndView model = new ModelAndView("employeeAddTerm");
        if (result.hasErrors()) {
            logger.error(employee.getEmail() + " couldn't load terms");
            List<ITerm> termList = termDAO.getCurrentTermsForEmployee(employee);
            model.addObject("termForm", termForm);
            model.addObject("termList", termList);
            return model;
        } else {
            termForm.setEmployeeId((int) employee.getId());
            termDAO.addNewTerm(termForm);
            logger.info(employee.getEmail() + " has inserted term");
        }
        return new ModelAndView("redirect:/termList");
    }

    @RequestMapping(value = "/deleteTerm", method = RequestMethod.POST)
    public ModelAndView deleteTerm(@RequestParam String termToDelete) {

        int idTermToDelete = Integer.valueOf(termToDelete);
        if (idTermToDelete > 0 && termDAO.deleteTerm(idTermToDelete)) {
            logger.info("Redirecting to term list for deleting");
            return new ModelAndView("redirect:/termList");

        } else {
            //TODO przekierować do strony ostrzegawczej z przekierowaniem na glowna + logi
            String message = "Coś poszło nie tak... Nie możemy usunąćc tego terminu.";
            logger.error("Cannot delete this term");
            ModelAndView model = new ModelAndView("error");
            model.addObject("error", message);
            return model;
        }


    }

}
