package pl.fotoszop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

@Controller
public class ErrorController {

    //	@Autowired
//	private ClientDAODbImpl clientDatabaseDAO;
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class.getName());

    @RequestMapping("/error")
    public ModelAndView helloworld(String error) {


        ModelAndView model = new ModelAndView("error");
        error = "Najgorszy błąd na świecie...";
        logger.error("Error controller has been activated");
        model.addObject("error", error);
        return model;
    }


}