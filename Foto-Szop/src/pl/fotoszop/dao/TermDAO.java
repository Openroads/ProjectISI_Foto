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
}
