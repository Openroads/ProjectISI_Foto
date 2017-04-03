package pl.fotoszop.DAODbImpl;


import java.util.Collection;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(int clientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IClient getClientById(int clientId) {
		String sqlQuery = "select * from client where client.id = ?";
		Client client = this.jdbcTemplate.queryForObject(sqlQuery,new Object[]{clientId}, new ClientMapper());
		
		return client;
	}

	@Override
	public Collection<IClient> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

}
