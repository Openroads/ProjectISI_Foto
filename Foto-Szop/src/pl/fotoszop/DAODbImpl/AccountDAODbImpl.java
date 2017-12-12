package pl.fotoszop.DAODbImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.fotoszop.dao.AccountDAO;
import pl.fotoszop.dto.EditFormDTO;
import pl.fotoszop.dto.LoginFormDTO;
import pl.fotoszop.model.Account;
import pl.fotoszop.modelinterfaces.IAccount;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class AccountDAODbImpl implements AccountDAO {

    private static final Logger logger = LoggerFactory.getLogger(AccountDAODbImpl.class.getName());

    private static final String SQL_GET_ACCOUNT_BY_LOGIN = "SELECT * from account where login = ? ";

    private DataSource dataSource;

    private IAccount account;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int saveOrUpdate(IAccount account) {

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            logger.info("Save or Update - Connection to database");
            String sqlQuery = "insert into account(id_account,login,password,date_of_creation,id_employee,id_client) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, account.getAccountId());
            statement.setString(2, account.getLogin());
            statement.setString(3, account.getPassword());
            statement.setDate(4, account.getCreationDate());
            if((int) account.getEmployeeId() != 0)
            	statement.setInt(5,(int) account.getEmployeeId());
            else
            	statement.setNull(5,java.sql.Types.INTEGER);
            if(account.getClientId() != 0)
            	statement.setInt(6,account.getClientId());
            else
            	statement.setNull(6,java.sql.Types.INTEGER);
            statement.executeUpdate();

            logger.info("Save or update has been successfully made");
        } catch (SQLException e) {

            logger.error("Cannot connect to database or save/update data");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    logger.info("Disconnect database");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    logger.error("Cannot disconnect with the database");
                }
            }
        }

        return 0;
    }

    public Collection<IAccount> getAllAccounts() {

        Connection connection = null;
        Collection<IAccount> accounts = null;

        try {
            connection = dataSource.getConnection();
            logger.info("Get all Accounts - connected with database");
            String sqlQuery = "SELECT * from account";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            accounts = new ArrayList<>();
            while (rs.next()) {
                IAccount account = new Account();
                account.setAccountId(rs.getInt("id_account"));
                account.setLogin(rs.getString("login"));
                account.setClientId(rs.getInt("id_client"));
                account.setCreationDate(rs.getDate("date_of_creation"));
                account.setPassword(rs.getString("password"));
                accounts.add(account);
            }

            logger.info("All accounts has been taken from database");
        } catch (SQLException e) {
            logger.error("Get all accounts - cannot connect with the database or gets accounts");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public IAccount getAccountByLogin(String login) {

        Connection connection = null;

        try {

            connection = dataSource.getConnection();
            logger.info("Get account by login - connected with database");
            PreparedStatement statement = connection.prepareStatement(SQL_GET_ACCOUNT_BY_LOGIN);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            Account account = null;

            if (rs.next()) {
                account = new Account();
                account.setAccountId(rs.getInt("id_account"));
                account.setLogin(rs.getString("login"));
                account.setPassword(rs.getString("password"));
                account.setCreationDate(rs.getDate("date_of_creation"));
                account.setClientId(rs.getInt("id_client"));
                account.setEmployeeId(rs.getInt("id_employee"));
            }
            statement.close();
            rs.close();
            return account;

        } catch (SQLException e) {

            logger.info("Get account by login - cannot connect with database or gets account by login");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {

                    connection.close();
                    logger.info("Get account by login - disconnect with database");
                } catch (SQLException e) {

                    logger.info("Get account by login - cannot disconnect with database");
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public int update(Account account, EditFormDTO form) {

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            logger.info("Update - connected with database");
            String sqlQuery = "UPDATE account SET password=? WHERE id_account=?";
            PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, form.getPasswordNew());
            statement.setInt(2, account.getAccountId());
            statement.executeUpdate();

            logger.info("Update - succesfully updated");
        } catch (SQLException e) {

            logger.info("Update - cannot connect with database or update data");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    logger.info("Update - disconnect with database");
                } catch (SQLException e) {

                    logger.info("Update - cannoct disconnect");
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


        return 0;
    }

    /**
     * Method to check if data from login form is correct
     *
     * @param form - Form with login data from the view.
     * @return int result - 1 when succes, -1 when login doesnt exist, 0 when password is incorrect or another failure
     */

    public int checkToLogin(LoginFormDTO form) {

        IAccount acc = this.getAccountByLogin(form.getLogin());
        if (acc == null) {
            logger.error("Login form incorrect");
            return -1;
        } else {
            if (acc.getPassword().equals(form.getPassword())) {
                this.account = acc;
                logger.info("Login - password correctly checked");
                return 1;
            }
        }

        return 0;
    }

    /**
     * Method to get the account data for client. Return account object only if checkToLogin method return 1.
     *
     * @param form - Form with login data from the view.
     * @return IAccount object if checkToLogin method for passed form return 1.
     */

    public IAccount getAccount(LoginFormDTO form) {

        //User has called the checkToLogin method already
        if (this.account != null) {
            if (this.account.getLogin().equals(form.getLogin()) && this.account.getPassword().equals(form.getPassword())) {
                logger.info(account.getLogin() + " successfully taken from database");
                return this.account;
            } else {
                this.account = null;
            }
        } else {
            if (this.checkToLogin(form) == 1) {
                logger.info(account.getLogin() + " successfully taken from database");
                this.account = this.getAccountByLogin(form.getLogin());
            }

        }

        return this.account;
    }

}
