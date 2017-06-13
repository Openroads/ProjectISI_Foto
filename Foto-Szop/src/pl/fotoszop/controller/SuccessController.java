package pl.fotoszop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

@Controller
public class SuccessController {

    private static final Logger logger = LoggerFactory.getLogger(SuccessController.class.getName());

//	@Autowired
//	private ClientDAODbImpl clientDatabaseDAO;

    @RequestMapping("/account")
    public ModelAndView helloworld() {

        ModelAndView model = new ModelAndView("account");
        logger.debug("Something went successfully from success controller");
        return model;
    }


}