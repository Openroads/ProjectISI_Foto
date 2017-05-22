package pl.fotoszop.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.dao.IFileUpload;
import pl.fotoszop.model.UploadFile;

public class FileUploadTest
{
    private IFileUpload fileUploadService;
    private UploadFile uploadFile;
    private AccountDAO accountDAO;
    private ClientDAO clientDAO;
    private String url = ""; //todo: url to folder on server

    @Before
    public void Setup()
    {
        fileUploadService = mock(IFileUpload.class);
        uploadFile = mock(UploadFile.class);
        accountDAO = mock(AccountDAO.class);
        clientDAO = mock(ClientDAO.class);

        uploadFile.setFileName("FirstPhoto");
        uploadFile.setUrl("url");
        //uploadFile.setData();
    }

    @Test
    public void GivenPicture_WhenSavingIntoDatabase_OutputCorrectUrl()
    {
        String expectedUrl = "myExpectedURL"; //todo: Check the url of saved pictures

        String urlFromServer = "urlFromServer"; //todo: implement method which returns url depends on saved photo or just find the rules

        int clientId = 0; //todo: get id from the user;
        int accountId = 0; //todo: get id from the account

        fileUploadService.uploadFile(uploadFile, clientId, accountId);

        Assert.assertEquals(expectedUrl, urlFromServer);
    }

}
