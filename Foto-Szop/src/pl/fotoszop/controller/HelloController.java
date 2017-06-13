package pl.fotoszop.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dto.LoginFormDTO;
import pl.fotoszop.model.Client;
import pl.fotoszop.model.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;



@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ClientDAODbImpl clientDatabaseDAO;
    @Autowired
    private AccountDAODbImpl aclientDatabaseDAO;

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public ModelAndView showIndex(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        Employee employee = (Employee) session.getAttribute("employee");
        ModelAndView model = null;
        if (client != null) {
            model = new ModelAndView("account");

        } else if (employee != null) {
            model = new ModelAndView("employeeAccount");
        } else {
            model = new ModelAndView("index");
            model.addObject("loginForm", new LoginFormDTO());
        }


        logger.debug("Index page has been loaded");
        return model;
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ModelAndView handleLogin(@ModelAttribute("loginForm") @Valid LoginFormDTO form, BindingResult result) {
        ModelAndView model = null;

        if (result.hasErrors()) {
            model = new ModelAndView("index");
            model.addObject("loginForm", form);
        } else {
            String login = form.getLogin();
            String password = form.getPassword();
            //TODO NIE ZNAJDUJE PLIKU XML
            //ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");

            //AccountDAO accountDAO = (AccountDAO) context.getBean("accountDAODbImpl");
            System.out.println(clientDatabaseDAO);
            model = new ModelAndView("index");
            System.out.println("no errors");
            System.out.println(form.getPassword());
            model.addObject("loginForm", new LoginFormDTO());
        }
        logger.debug("Login form has been initialized");
        return model;
    }


}