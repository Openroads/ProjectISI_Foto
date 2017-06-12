package pl.fotoszop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HistoryController {

//	@Autowired
//	private ClientDAODbImpl clientDatabaseDAO;

    @RequestMapping("/history")
    public ModelAndView helloworld() {
        ModelAndView model = new ModelAndView("history");
        return model;
    }


}