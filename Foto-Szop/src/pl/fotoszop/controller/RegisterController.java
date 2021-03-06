package pl.fotoszop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dto.Form;
import pl.fotoszop.model.Account;
import pl.fotoszop.model.Client;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes({"client", "account"})
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class.getName());

    @Autowired
    private ClientDAODbImpl clientDatabaseDAO;
    @Autowired
    private AccountDAODbImpl aclientDatabaseDAO;

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public ModelAndView processForm(@ModelAttribute("form") @Valid Form form, BindingResult result) {

        ModelAndView model = null;

        if (result.hasErrors()) {

            logger.error("Error in registration, binding result");
            model = new ModelAndView("register");
            model.addObject("form", form);
            form.clearPasswordFiels();
            return model;
        } else {

            form.doHash();

            boolean flag = clientDatabaseDAO.checkIdentityNumberIfExist(form);
            if(aclientDatabaseDAO.getAccountByLogin(form.getEmail())!=null) flag = true;//email exist-cannot make account
            boolean flag2 = form.checkPasswords();

            if ((!flag) && flag2) {

                //Client newClient = new Client(1,form.getName(),form.getSurname(),form.getAddress(),form.getIdentityNumber(),form.getPhoneNumber(),form.getEmail());
                Client newClient = new Client(form);
                newClient.setId(0);
                Account newAccount = new Account(form);
                newAccount.setAccountId(0);
                clientDatabaseDAO.saveOrUpdate(newClient);
                aclientDatabaseDAO.saveOrUpdate(newAccount);

                model = new ModelAndView("success");
                model.addObject("client", newClient);
                model.addObject("account", newAccount);

                logger.info(newClient.getEmail() + " has been registered successfully");
                return model;
            } else {

                logger.error("Registration error, two flags don't match");
                model = new ModelAndView("register");
                result.rejectValue("email", "errorCodeLogin", "Konto o podanym E-mail lub użytkownik o podanym peselu już istnieje.");
                result.rejectValue("identityNumber", "errorCodeLogin", "Konto o podanym E-mail lub użytkownik o podanym peselu już istnieje.");
                form.clearPasswordFiels();
                model.addObject("form", form);
                return model;
            }
        }
    }

    @RequestMapping("/register")
    public ModelAndView getForm(HttpSession session) {

        ModelAndView model;

        if (session.getAttribute("account") != null) session.invalidate();

        model = new ModelAndView("register");
        model.addObject("form", new Form());

        logger.info("Register form has been initialized");
        return model;
    }


}
