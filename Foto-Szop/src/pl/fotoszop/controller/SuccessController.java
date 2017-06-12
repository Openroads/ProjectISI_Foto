package pl.fotoszop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class SuccessController {

    private static final Logger logger = Logger.getLogger(SuccessController.class.getName());

//	@Autowired
//	private ClientDAODbImpl clientDatabaseDAO;

    @RequestMapping("/account")
    public ModelAndView helloworld() {

        ModelAndView model = new ModelAndView("account");
        logger.info("Something went successfully from success controller");
        return model;
    }


}