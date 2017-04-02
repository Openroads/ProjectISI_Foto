package pl.fotoszop.dao;

import java.util.Collection;

import pl.fotoszop.modelinterfaces.IClient;

public interface ClientDAO {
	public void saveOrUpdate(IClient client);
	public void delete(int clientId);
	public IClient getClientById(int clientId);
	public Collection<IClient> getAllContacts();
	
}
