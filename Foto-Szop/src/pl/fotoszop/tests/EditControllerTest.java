package pl.fotoszop.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import pl.fotoszop.controller.EditController;
import pl.fotoszop.model.EditForm;


public class EditControllerTest
{
    private EditController editController;
    private ModelAndView model;
    private EditForm editForm;

    @Before
    public void setup()
    {
        editForm = new EditForm();

        editController = new EditController();
        model = new ModelAndView("edit");
        model.addObject("editForm", new EditForm());
    }


    @Test
    public void GivenEditController_WithNoChanges_ExpectedSuccess()
    {
        Assert.assertEquals(model.getViewName(), editController.getForm().getViewName());
    }

    @Test
    public void GivenEditController_WithNoChanges_ExpectedFail()
    {
        editController = new EditController();
        editForm.setPassword("Tak");
        editForm.setPassword2("Nie");
        Assert.assertEquals(model.getViewName(), editController.getForm().getViewName());
    }
}
