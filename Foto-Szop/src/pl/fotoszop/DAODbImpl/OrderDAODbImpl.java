package pl.fotoszop.DAODbImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.fotoszop.dao.OrderDAO;
import pl.fotoszop.model.Employee;
import pl.fotoszop.model.Order;
import pl.fotoszop.modelMappers.OrderMapper;
import pl.fotoszop.modelinterfaces.IOrder;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Szymon
 */
@Component
@Repository
public class OrderDAODbImpl implements OrderDAO {

    private static final String GET_NEXT_ID = "select max(id_order)from  order_ps";
    private static final Logger logger = LoggerFactory.getLogger(OrderDAODbImpl.class.getName());
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public OrderDAODbImpl() {
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public int update(int orderId, String status){
    	
    	 String sqlQuery = "update order_ps set order_status = '"+status+"' where id_order="+orderId;
         jdbcTemplate.update(sqlQuery);
         return 0;
    }
    
    @Override
    public int saveOrUpdate(IOrder order) {

        if (order.getIdOrder() == 0) {
        	
        	Integer i = jdbcTemplate.queryForObject(GET_NEXT_ID, Integer.class);
        	
        	if(i==null) {
        		order.setOrderId(1);
        	}else {
        		order.setOrderId(i+1);
        	}
        }


        String sqlQuery = "insert into order_ps(id_order,date_of_order,id_of_realization_term,date_of_modification,order_status,subject,sessionAddress,sessionPlace,id_service,id_client,id_employee,bonus) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlQuery, order.getIdOrder(),
                order.getDateOfOrder(),
                order.getIdOfRealizationTerm(),
                null,
                order.getOrderStatus(),
                order.getOrderTitle(),
                order.getOrderAddress(),
                order.getOrderPlace(),
                order.getIdService(),
                order.getClientId(),
        		order.getEmployeeId(),
        		order.getBonus());
        ;

        logger.info("Order has been saved or updated successfully");
        return 0;
    }

    @Override
    public boolean delete(String orderId) {
        String sqlQuery = "delete order_ps where id_order = " + orderId;
        jdbcTemplate.execute(sqlQuery);

        logger.info("Order has been deleted successfully");
        return true;
    }

    @Override
    public List<IOrder> getAllOrders(int clientId) {
 
        String sqlQuery = "select * from order_ps where order_ps.id_client = " + clientId;
        Collection<Order> OrderL = this.jdbcTemplate.query(sqlQuery, new OrderMapper());
        logger.info("All orders has been taken");
        return OrderL.stream().map(x -> (IOrder) x).collect(Collectors.toList());
    }
    
    public List<IOrder> getAllOrders(Employee employee) {

        String sqlQuery = "select * from order_ps where order_ps.id_employee = " + employee.getId();
        Collection<Order> OrderL = this.jdbcTemplate.query(sqlQuery, new OrderMapper());
        try {
			Connection conn  = dataSource.getConnection();
			for(Order o: OrderL){
	        	Statement statement = conn.createStatement();
	        	ResultSet rs = statement.executeQuery("select date_of_term from term where id_term = "+o.getIdOfRealizationTerm());
	        	while(rs.next()){
	        		o.setRealizationDate(rs.getDate("date_of_term"));
	        	}
	        	
	        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
        logger.info("All orders has been taken");
        return OrderL.stream().map(x -> (IOrder) x).collect(Collectors.toList());
    }
    
    public List<IOrder> getAllOrders() {

        String sqlQuery = "select * from order_ps";
        Collection<Order> OrderL = this.jdbcTemplate.query(sqlQuery, new OrderMapper());
        logger.info("All orders has been taken");
        return OrderL.stream().map(x -> (IOrder) x).collect(Collectors.toList());
    }
}
