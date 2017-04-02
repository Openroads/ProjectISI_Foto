package pl.fotoszop.dao;

import java.util.Collection;

import pl.fotoszop.modelinterfaces.IClient;

public interface ClientDAO {
	/**
	 * Method to save object in storage, passed client  is sought through storage and update if 
	 *  client on the same id already exist, in other case it create new client object with new id
	 * @param client object to save in storage
	 * @return new generated id for saved client if passed doesn't exist. If the client already exist
	 * the same id what passed object has.
	 */
	public int saveOrUpdate(IClient client);
	/**
	 * Delete client for passed client id
	 * @param clientId - id of client - for instance, primary key for database
	 * @return true - if deleting was successful, false if client on passed id doesn't exist
	 */
	public boolean delete(int clientId);
	/**
	 * 
	 * @param clientId
	 * @return Client object for passed id, null if client of passed id doesn't exist
	 */
	public IClient getClientById(int clientId);
	/**
	 * Method to obtain all Clients
	 * @return All Client objects from data storage or empty collection 
	 */
	public Collection<IClient> getAllContacts();
	
}
