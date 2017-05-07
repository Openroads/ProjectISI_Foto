package pl.fotoszop.DAODbImpl;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.model.Client;
import pl.fotoszop.modelinterfaces.IClient;
/**
 * 
 * @author dariusz
 *
 */
@Repository
public class ClientDAODbImpl implements ClientDAO{
	private JdbcTemplate jdbcTemplate;
	
	public ClientDAODbImpl() {}
	
	 public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	
	@Override
	public int saveOrUpdate(IClient client) {
		String sqlQuery = "insert into client(id_client,name,surname,address,personal_id,phone_nr,email) "
				+ "values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sqlQuery,client.getId(),client.getName(),client.getSurname(),client.getAddress(),
				client.getIdentityNumber(),client.getPhoneNumber(),client.getEmail());
		
		return 0;
	}

	@Override
	public boolean delete(int clientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IClient getClientById(int clientId) {
		String sqlQuery = "select * from client where client.id_client = " + clientId;
		List<Client> clientL =  this.jdbcTemplate.query(sqlQuery, new ClientMapper());
		
		return clientL.get(0);
	}

	@Override
	public Collection<IClient> getAllContacts() {
		String sqlQuery = "select * from client";
		Collection<Client> clientL =  this.jdbcTemplate.query(sqlQuery, new ClientMapper());
		return clientL.stream().map(x->(IClient) x).collect(Collectors.toList());
	}

}
