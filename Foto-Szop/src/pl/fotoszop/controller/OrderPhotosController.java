package pl.fotoszop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.DAODbImpl.FileUploadImpl;
import pl.fotoszop.dto.OrderPhotosFormDTO;
import pl.fotoszop.model.UploadFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes({"client", "account"})
public class OrderPhotosController {

    private static final Logger logger = LoggerFactory.getLogger(OrderPhotosController.class.getName());

    @Autowired
    private ClientDAODbImpl clientDatabaseDAO;
    @Autowired
    private AccountDAODbImpl aclientDatabaseDAO;

    private FileUploadImpl fileUploadService;

    @RequestMapping(value = "/orderPhotos", method = RequestMethod.POST)
    public ModelAndView processForm(@ModelAttribute("form") @Valid OrderPhotosFormDTO form, BindingResult result) {

        ModelAndView model = null;

        model = new ModelAndView("orderPhotos");
        return model.addObject("form", form);

    }

    /***
     * To change to make it properly as previous controllers
     * @param request
     * @param fileupload
     * @return
     * @throws Exception
     */
    public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileupload) throws Exception {
        if (fileupload != null && fileupload.length > 0) {
            // todo: get the user/client data (How to get the user which is ordering?)
            int clientId = 0;
            int accountId = 0;
            for (CommonsMultipartFile file : fileupload) {
                System.out.println("Saving File: " + file.getOriginalFilename());

                UploadFile uploadFile = new UploadFile();
                uploadFile.setFileName(file.getOriginalFilename());
                uploadFile.setData(file.getBytes());
                fileUploadService.uploadFile(uploadFile, clientId, accountId);

            }
        }
        logger.debug("Photo has been uploaded successfully");
        return "File has been successfully uploaded";
    }


    @RequestMapping("/photos")
    public ModelAndView getForm(HttpSession session) {

        ModelAndView model;

        model = new ModelAndView("/orderPhotos");
        model.addObject("form", new OrderPhotosFormDTO());

        return model;
    }
}

