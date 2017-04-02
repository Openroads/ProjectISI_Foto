package pl.fotoszop.dao;

import java.util.Collection;

import pl.fotoszop.modelinterfaces.IAccount;
import pl.fotoszop.modelinterfaces.IClient;

public interface AccountDAO {

	public void saveOrUpdate(IAccount account);
	public void delete(int accountId);
	public IClient getClientById(int accountId);
	public Collection<IAccount> getAllAccounts();
		
	
}
