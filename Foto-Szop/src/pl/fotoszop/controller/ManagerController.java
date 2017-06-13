package pl.fotoszop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.EmployeeDAODbImpl;
import pl.fotoszop.dto.AddEmpDTO;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Employee;
import pl.fotoszop.model.Manager;
import pl.fotoszop.modelinterfaces.IAccount;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class ManagerController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class.getName());

    @Autowired
    EmployeeDAODbImpl empDAO;
    @Autowired
    AccountDAODbImpl accDAO;

    @RequestMapping("/employeeAdding")
    public ModelAndView showList(@SessionAttribute Manager manager) {


        ModelAndView model = new ModelAndView("employeeAdding");
        AddEmpDTO empForm = new AddEmpDTO();

        model.addObject("AddEmpDTO", empForm);


        return model;

    }

    @RequestMapping("/managerReturn")
    public ModelAndView doReturn() {

        return new ModelAndView("managerAccount");
    }

    @RequestMapping("/addEmployee")
    public ModelAndView addEmployee(@SessionAttribute Manager manager, @ModelAttribute("AddEmpDTO") @Valid AddEmpDTO empForm, BindingResult result) {


        ModelAndView model = null;

        if (result.hasErrors()) {
            model = new ModelAndView("employeeAdding");
            model.addObject("AddEmpDTO", new AddEmpDTO());

        } else {

            empForm.doHash();
            if (empDAO.checkToAddEmp(empForm)) {

                model = new ModelAndView("employeeAdding");
                model.addObject("AddEmpDTO", new AddEmpDTO());

            } else {

                model = new ModelAndView("managerAccount");
                Employee newEmp = new Employee();
                System.out.println("EmpId: " + empForm.getId());
                newEmp.setFromForm(empForm);
                empDAO.save(newEmp);

                Account newAcc = new Account();
                Collection<IAccount> accList = new ArrayList<>();
                accList = accDAO.getAllAccounts();
                newAcc.setAccountId(0);

                for (IAccount object : accList) {
                    if (object.getAccountId() >= newAcc.getAccountId()) newAcc.setAccountId(object.getAccountId() + 1);
                }

                newAcc.setEmployeeId((int) newEmp.getId());
                newAcc.setCreationDate(Date.valueOf(LocalDate.now()));
                newAcc.setLogin(newEmp.getEmail());
                newAcc.setPassword(empForm.getPassword());
                accDAO.saveOrUpdate(newAcc);

                System.out.println("Dodano konto" + newAcc.getEmployeeId());

                return model;
            }

        }
        return model;

    }


}