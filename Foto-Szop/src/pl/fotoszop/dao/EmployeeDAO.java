package pl.fotoszop.dao;

import pl.fotoszop.modelinterfaces.IEmployee;

public interface EmployeeDAO {

	/**
	 * 
	 * @param employeeId
	 * @return Employee object for passed id, null if client of passed id doesn't exist
	 */
	public IEmployee getClientById(long employeeId);
}
