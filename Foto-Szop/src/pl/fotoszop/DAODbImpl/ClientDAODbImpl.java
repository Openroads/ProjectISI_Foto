package pl.fotoszop.DAODbImpl;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.model.Client;
import pl.fotoszop.modelinterfaces.IClient;
/**
 * 
 * @author dariusz
 *
 */

public class ClientDAODbImpl implements ClientDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public ClientDAODbImpl() {}
	
	 public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    } 
	
	@Override
	public int saveOrUpdate(IClient client) {
		
		String sqlInsertQuery = "insert into client(id_client,name,surname,address,personal_id,phone_nr,email) "
				+ "values (?,?,?,?,?,?,?)";
		
		IClient cl = getClientById(client.getId());
		
		if(cl != null)
		{
			this.delete(client.getId());
		}

		jdbcTemplate.update(sqlInsertQuery,client.getId(),client.getName(),client.getSurname(),client.getAddress(),
				client.getIdentityNumber(),client.getPhoneNumber(),client.getEmail());
		
		return client.getId();
	}

	@Override
	public boolean delete(int clientId) {
		String sqlQuery = "delete from client where client.id_client = ?";
		int rows = this.jdbcTemplate.update(sqlQuery, clientId);
		if (rows > 0) return true;
		
		return false;
	}

	@Override
	public IClient getClientById(int clientId) {
		
		String sqlQuery = "select * from client where client.id_client = ?";
		List<Client> clientL =  this.jdbcTemplate.query(sqlQuery,new Object[]{clientId} ,new ClientMapper());
		if(clientL.size()>0)
			return clientL.get(0);
		else return null;
	}

	@Override
	public Collection<IClient> getAllContacts() {
		String sqlQuery = "select * from client";
		Collection<Client> clientL =  this.jdbcTemplate.query(sqlQuery, new ClientMapper());
		return clientL.stream().map(x->(IClient) x).collect(Collectors.toList());
	}

}
