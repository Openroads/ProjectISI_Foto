package pl.fotoszop.DAODbImpl;

import org.springframework.stereotype.Component;
import pl.fotoszop.dao.TermDAO;
import pl.fotoszop.dto.TermFormtDTO;
import pl.fotoszop.model.Term;
import pl.fotoszop.modelinterfaces.IEmployee;
import pl.fotoszop.modelinterfaces.ITerm;

import javax.sql.DataSource;
import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

@Component
public class TermDAODbImpl implements TermDAO {

    private static final Logger logger = LoggerFactory.getLogger(TermDAODbImpl.class.getName());

    private static final String SQL_GET_TERMS_EMPLOYEE = "Select id_term,date_of_term from term where id_employee = ? and date_of_term >= ?";
    private static final String SQL_GET_TERMS_FROM_DATE = "Select * from term where date_of_term >= ?";
    private static final String SQL_GET_LAST_ID = "select max(id_term) from term";
    private static final String INSERT_NEW_TERM = "insert into term(id_term, id_employee,date_of_term) VALUES(?,?,?)";
    private static final String SQL_DELETE_TERM_FOR_ID = "delete from term where term.id_term = ?";
    private static final String SQL_GET_TERMS_BETWEEN_DATE = "Select * from term where date_of_term >= ? and date_of_term <= ?";

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<ITerm> getCurrentTermsForEmployee(IEmployee employee) {
        Connection connection = null;
        List<ITerm> termList = new ArrayList<ITerm>();

        try {
            connection = dataSource.getConnection();

            logger.debug("Connection with database");
            PreparedStatement statement = connection.prepareStatement(SQL_GET_TERMS_EMPLOYEE);
            statement.setInt(1, (int) employee.getId());
            statement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet rs = statement.executeQuery();
            ITerm term = null;

            while (rs.next()) {
                term = new Term();
                term.setId(rs.getInt("id_term"));
                term.setIdEmployee((int) employee.getId());
                term.setDate(rs.getDate("date_of_term"));
                termList.add(term);
            }
            logger.debug("Term list has been taken successfully");
        } catch (SQLException e) {

            logger.error("Cannot connect with database or cannot get list of terms: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    logger.debug("Disconnect with database");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    logger.error("Something went wrong: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        return termList;
    }

    @Override
    public List<ITerm> getFreeTermsFromDate(LocalDate date) {

        Connection connection = null;
        List<ITerm> termList = new ArrayList<ITerm>();

        try {
            connection = dataSource.getConnection();
            logger.debug("Connection with database");
            PreparedStatement statement = connection.prepareStatement(SQL_GET_TERMS_FROM_DATE);
            statement.setDate(1, java.sql.Date.valueOf(date));
            ResultSet rs = statement.executeQuery();
            ITerm term = null;

            while (rs.next()) {
                term = new Term();
                term.setId(rs.getInt("id_term"));
                term.setIdEmployee(rs.getInt("id_employee"));
                term.setDate(rs.getDate("date_of_term"));
                termList.add(term);
            }
        } catch (SQLException e) {
            //TODO TO LOGER
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return termList;
    }

    @Override
    public List<ITerm> getFreeTermsForWeek(LocalDate date) {


        Connection connection = null;
        List<ITerm> termList = new ArrayList<ITerm>();

        try {
            connection = dataSource.getConnection();

            DayOfWeek dayOfweek = date.getDayOfWeek();


            int dayNumberDayOfWeek = dayOfweek.getValue();

            int dayUntilFinishWeek = 7 - dayNumberDayOfWeek;

            LocalDate sundayDate = date.plusDays(dayUntilFinishWeek);

            PreparedStatement statement = connection.prepareStatement(SQL_GET_TERMS_BETWEEN_DATE);
            statement.setDate(1, java.sql.Date.valueOf(date));
            statement.setDate(2, java.sql.Date.valueOf(sundayDate));

            ResultSet rs = statement.executeQuery();
            ITerm term = null;

            while (rs.next()) {
                term = new Term();
                term.setId(rs.getInt("id_term"));
                term.setIdEmployee(rs.getInt("id_employee"));
                term.setDate(rs.getDate("date_of_term"));
                termList.add(term);
            }

            logger.debug("Free term list has been taken successfully");
        } catch (SQLException e) {
            logger.error("Cannot connect to database or get list of free terms: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    logger.debug("Disconnect with database");
                } catch (SQLException e) {
                    logger.error("Something went wrong: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        return termList;

    }

    @Override
    public int addNewTerm(TermFormtDTO newTerm) {
        Connection connection = null;


        try {

            connection = dataSource.getConnection();
            logger.debug("Add new term connecting to database");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_GET_LAST_ID);
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }


            PreparedStatement prStatement = connection.prepareStatement(INSERT_NEW_TERM);
            prStatement.setInt(1, id);
            prStatement.setInt(2, newTerm.getEmployeeId());
            prStatement.setDate(3, new java.sql.Date((newTerm.getDate().getTime())));
            prStatement.executeUpdate();
            logger.debug("New term has been saved or updated");

        } catch (SQLException e) {
            logger.error("Cannot connect to database or insert/update new term: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    logger.debug("Disconnect wit database");
                } catch (SQLException e) {
                    logger.error("Something went wrong: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        return 0;
    }

    @Override
    public boolean deleteTerm(int id) {

        Connection connection = null;


        try {

            connection = dataSource.getConnection();

            logger.debug("Delete term connecting with database");
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TERM_FOR_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
            logger.debug("Term with id: " + id + " has been deleted successfully");
            return true;

        } catch (SQLException e) {
            logger.error("Cannot connect with database or delete term: " + e.getMessage());

            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    logger.debug("Disconnect with database");
                } catch (SQLException e) {
                    logger.error("Something went wrong: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }


    }
}
