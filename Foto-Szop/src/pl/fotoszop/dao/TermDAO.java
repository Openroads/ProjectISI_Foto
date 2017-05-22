package pl.fotoszop.dao;

import java.time.LocalDate;
import java.util.List;

import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.modelinterfaces.IEmployee;
import pl.fotoszop.modelinterfaces.ITerm;

public interface TermDAO {
	public List<ITerm> getFreeTermsFromDate(LocalDate date);
	public List<ITerm> getCurrentTermsForEmployee(IEmployee employee);
	public int addNewTerm(TermFormtDTO newTerm);
	public boolean deleteTerm(int id);
	/**
	 * Function return list of free Terms from the passed date until the end of the  week
	 * @param date - the date from which we start getting the terms
	 * @return 
	 */
	List<ITerm> getFreeTermsForWeek(LocalDate date);
}
