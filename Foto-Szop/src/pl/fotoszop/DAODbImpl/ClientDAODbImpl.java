package pl.fotoszop.DAODbImpl;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.dto.EditFormDTO;
import pl.fotoszop.dto.Form;
import pl.fotoszop.model.Client;
import pl.fotoszop.modelMappers.ClientMapper;
import pl.fotoszop.modelinterfaces.IClient;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import java.util.stream.Collectors;

/**
 * @author dariusz
 */
@Component
@Repository
public class ClientDAODbImpl implements ClientDAO {

    private static final Logger logger = LoggerFactory.getLogger(ClientDAODbImpl.class.getName());
    private JdbcTemplate jdbcTemplate;

    public ClientDAODbImpl() {
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveOrUpdate(IClient client) {
        String sqlQuery = "insert into client(id_client,name,surname,address,personal_id,phone_nr,email) "
                + "values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlQuery, client.getId(), client.getName(), client.getSurname(), client.getAddress(),
                client.getIdentityNumber(), client.getPhoneNumber(), client.getEmail());

        logger.debug(client.getEmail() + "has been added or updated");
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
        List<Client> clientL = this.jdbcTemplate.query(sqlQuery, new ClientMapper());

        logger.debug("Client id: " + clientId + "is searching in the database");
        return clientL.get(0);
    }

    @Override
    public Collection<IClient> getAllContacts() {
        String sqlQuery = "select * from client";
        Collection<Client> clientL = this.jdbcTemplate.query(sqlQuery, new ClientMapper());

        logger.debug("All contact has been taken from the database");
        return clientL.stream().map(x -> (IClient) x).collect(Collectors.toList());
    }

    /**
     * Method to check if it is possible to create new Client and add it to database (check whether such Client exists in storage)
     *
     * @param - registration form
     * @return true - if such Client already exists in database, false - if such Client doesn't exist in database
     */
    public boolean checkToRegister(Form form) {

        Collection<IClient> clients = new ArrayList<>();
        clients = getAllContacts();
        boolean isTaken = false;

        int id = 0;

        for (IClient object : clients) {
            if (object.getEmail().equals(form.getEmail()))
                isTaken = true;
            if (object.getId() > form.getId()) id = object.getId();
        }

        id++;
        form.setId(id);
        return isTaken;
    }

    public int updateClient(IClient client, EditFormDTO form) {


        String sqlQuery;


        if (!form.getAddress().equals("") && !form.getPhoneNumber().equals("")) {

            System.out.println("addr:" + form.getAddress() + "nr:" + form.getPhoneNumber());

            sqlQuery = "UPDATE client SET address=?, phone_nr=? WHERE id_client=?";
            jdbcTemplate.update(sqlQuery, form.getAddress(), form.getPhoneNumber(), client.getId());
            logger.debug(client.getEmail() + " has changed his address to: " + form.getAddress() + " and phone number to: " + form.getPhoneNumber());

        } else if (!form.getAddress().equals("")) {

            sqlQuery = "UPDATE client SET address=? WHERE id_client=?";
            jdbcTemplate.update(sqlQuery, form.getAddress(), client.getId());
            logger.debug(client.getEmail() + " has changed his address to: " + form.getAddress());

        } else if (!form.getPhoneNumber().equals("")) {

            sqlQuery = "UPDATE client SET phone_nr=? WHERE id_client=?";
            jdbcTemplate.update(sqlQuery, form.getPhoneNumber(), client.getId());

            logger.debug(client.getEmail() + " has changed his phone number to: " + form.getPhoneNumber());
        }

        return 0;
    }


}
