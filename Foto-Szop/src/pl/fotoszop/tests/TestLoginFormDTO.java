package pl.fotoszop.tests;

import org.springframework.beans.factory.annotation.Autowired;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;

public class TestLoginFormDTO {

    @Autowired
    private AccountDAODbImpl aclientDatabaseDAO;
    /*
	@Test
	public void testCheckToLogin(){
		LoginFormDTO lform = new LoginFormDTO();
		lform.setLogin("tomasek95@gmail.com");
		lform.setPassword("hazard");
		assertEquals(1, lform.checkToLogin(aclientDatabaseDAO));
	}
	*/
}
