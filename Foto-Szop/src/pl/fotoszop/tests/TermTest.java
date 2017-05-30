package pl.fotoszop.tests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import pl.fotoszop.DAODbImpl.EmployeeDAODbImpl;
import pl.fotoszop.DAODbImpl.TermDAODbImpl;
import pl.fotoszop.model.Employee;
import pl.fotoszop.modelinterfaces.IEmployee;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "WebContent//WEB-INF/spring-dispatcher-servlet.xml" })
public class TermTest {
	
	@Autowired TermDAODbImpl termDAO;
	@Autowired EmployeeDAODbImpl employeeDAO;
	

	@Test
	public void getTermsTests()
	{
		System.out.println("ASDAS");
		 //EmployeeDAODbImpl employeeDAO = new EmployeeDAODbImpl();
		IEmployee empl = employeeDAO.getEmployeeById(1);
		assertNull(empl);
		//assertNotNull(termDAO.getCurrentTermsForEmployee(empl));
		
	}
	
}
