package pl.fotoszop.modelMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.fotoszop.model.Account;

public class AccountMapper implements RowMapper<Account> {


    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

        Account acc = new Account();

        acc.setAccountId(rs.getInt("id_account"));
        acc.setLogin(rs.getString("login"));
        acc.setPassword(rs.getString("password"));
        acc.setCreationDate(rs.getDate("date_of_creation"));
        acc.setClientId(rs.getInt("id_employee"));
        acc.setEmployeeId(rs.getInt("id_client"));
  
        return acc;
    }


}
