package pl.fotoszop.modelMappers;

import org.springframework.jdbc.core.RowMapper;
import pl.fotoszop.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(rs.getInt("id_client"));
        System.out.println(rs.getInt("id_client"));
        client.setName(rs.getString("name"));
        client.setSurname(rs.getString("surname"));
        client.setAddress(rs.getString("address"));
        client.setIdentityNumber(rs.getString("personal_id"));
        client.setPhoneNumber(rs.getString("phone_nr"));
        client.setEmail(rs.getString("email"));
        return client;
    }

}
