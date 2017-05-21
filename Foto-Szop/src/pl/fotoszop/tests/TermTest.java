package pl.fotoszop.tests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import pl.fotoszop.DAODbImpl.EmployeeDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.model.Employee;
import pl.fotoszop.modelinterfaces.IEmployee;

/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext_mock.xml" })*/
public class TermTest {
	
	@Autowired TermDAODbImpl termDAO;
	@Autowired EmployeeDAODbImpl employeeDAO;
	
	@Test
	public void getTermsTests()
	{
		System.out.println("ASDAS");
		IEmployee empl = employeeDAO.getEmployeeById(1);
		System.out.println(empl);
		assertNotNull(termDAO.getCurrentTermsForEmployee(empl));
		
	}
	
}
