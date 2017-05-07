package pl.fotoszop.dao;

import java.util.Collection;

import pl.fotoszop.modelinterfaces.IAccount;
import pl.fotoszop.modelinterfaces.IClient;

public interface AccountDAO {

	/**
	 * 
	 * @param account
	 */

	public IAccount getAccountByLogin(String login);
	public int saveOrUpdate(IAccount account);
	
}
