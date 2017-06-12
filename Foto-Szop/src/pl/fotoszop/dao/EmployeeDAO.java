package pl.fotoszop.dao;

import pl.fotoszop.modelinterfaces.IEmployee;

public interface EmployeeDAO {

	/**
	 * 
	 * @param employeeId
	 * @return Employee object for passed id, null if client of passed id doesn't exist
	 */
	public IEmployee getEmployeeById(long employeeId);
	/**
	 * 
	 * @param employeeId
	 * @return Employee object of Manager for passed id, null if manager of passed id doesnt exist
	 */
	public IEmployee getManagerById(long employeeId);
}
