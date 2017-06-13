package pl.fotoszop.dao;

import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.model.Client;
import pl.fotoszop.model.Term;
import pl.fotoszop.modelMappers.ClientMapper;
import pl.fotoszop.modelinterfaces.IClient;
import pl.fotoszop.modelinterfaces.IEmployee;
import pl.fotoszop.modelinterfaces.ITerm;

import java.time.LocalDate;
import java.util.List;

public interface TermDAO {
    public List<ITerm> getFreeTermsFromDate(LocalDate date);

    public List<ITerm> getCurrentTermsForEmployee(IEmployee employee);

    public int addNewTerm(TermFormtDTO newTerm);

    public boolean deleteTerm(int id);

    /**
     * Function return list of free Terms from the passed date until the end of the  week
     *
     * @param date - the date from which we start getting the terms
     * @return
     */
    List<ITerm> getFreeTermsForWeek(LocalDate date);
    
    public Term getTermById(int id);
  
}
