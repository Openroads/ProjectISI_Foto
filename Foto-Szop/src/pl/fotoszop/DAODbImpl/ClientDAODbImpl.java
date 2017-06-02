package pl.fotoszop.DAODbImpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.dto.EditFormDTO;
import pl.fotoszop.dto.Form;
import pl.fotoszop.model.Client;
import pl.fotoszop.modelinterfaces.IClient;
/**
 * 
 * @author dariusz
 *
 */
@Component
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
	
	/** 
	 *Method to check if it is possible to create new Client and add it to database (check whether such Client exists in storage)
	 *@param - registration form
	 *@return true - if such Client already exists in database, false - if such Client doesn't exist in database
	  */
	public boolean checkToRegister(Form form){
		
		Collection<IClient> clients = new ArrayList<>();
		clients = getAllContacts();
		boolean isTaken = false;
		
		int id=0;
		
		for(IClient object: clients)
		{
			if(object.getEmail().equals(form.getEmail())) 
				isTaken = true;
			if(object.getId()>form.getId()) id = object.getId();
		}
		
		id++;
		form.setId(id);
		return isTaken;
	}
	
	public int updateClient (IClient client, EditFormDTO form){
		
		
		String sqlQuery;
		
				
			if(!form.getAddress().equals("") && !form.getPhoneNumber().equals("")){
				
				System.out.println("addr:"+form.getAddress()+"nr:"+form.getPhoneNumber());
				
				sqlQuery = "UPDATE client SET address=?, phone_nr=? WHERE id_client=?";
				jdbcTemplate.update(sqlQuery,form.getAddress(),form.getPhoneNumber(),client.getId());
				
			}else if(!form.getAddress().equals("")){
				
				sqlQuery = "UPDATE client SET address=? WHERE id_client=?";
				jdbcTemplate.update(sqlQuery,form.getAddress(),client.getId());
				
			}else if(!form.getPhoneNumber().equals("")){
				
				sqlQuery = "UPDATE client SET phone_nr=? WHERE id_client=?";
				jdbcTemplate.update(sqlQuery,form.getPhoneNumber(),client.getId());
			}
		
		return 0;
	}
	

}
