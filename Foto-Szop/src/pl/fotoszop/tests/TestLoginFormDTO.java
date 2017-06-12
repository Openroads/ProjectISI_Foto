package pl.fotoszop.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.DAODbImpl.ClientDAODbImpl;
import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.dto.LoginFormDTO;
import pl.fotoszop.modelinterfaces.IAccount;

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
