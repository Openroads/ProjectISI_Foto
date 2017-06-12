package pl.fotoszop.DAODbImpl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pl.fotoszop.dao.OrderDAO;
import pl.fotoszop.model.Order;
import pl.fotoszop.model.Term;
import pl.fotoszop.modelinterfaces.IEmployee;
import pl.fotoszop.modelinterfaces.IOrder;
import pl.fotoszop.modelinterfaces.ITerm;
/**
 * 
 * @author Szymon
 *
 */
@Component
@Repository
public class OrderDAODbImpl implements OrderDAO{
	

	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = Logger.getLogger(OrderDAODbImpl.class.getName());
	
	public OrderDAODbImpl() {}
	
	 public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	
	@Override
	public int saveOrUpdate(IOrder order) {
		String sqlQuery = "insert into order_ps(id_order,date_of_order,id_of_realization_term,date_of_modification,order_status,id_service,id_client) "
				+ "values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sqlQuery,order.getOrderId(),
									 order.getDateOfOrder(),
									 order.getIdOfRealizationTerm(),
									 Date.valueOf(LocalDate.now()),
									 order.getOrderStatus(),
									 order.getServiceId(),
									 order.getClientId());

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
		System.out.println(clientId);
		String sqlQuery = "select * from order_ps where order_ps.id_client = " + clientId;
<<<<<<< HEAD
=======
		List<Order> OrderL =  this.jdbcTemplate.query(sqlQuery, new OrderMapper());

		logger.info("Order by client id has been taken");
		return OrderL.get(0);
	}

	@Override
	public Collection<IOrder> getAllOrders() {
		String sqlQuery = "select * from order";
>>>>>>> 26d5ecaaa052961a65062ddc7ca06d1eaa7a5032
		Collection<Order> OrderL =  this.jdbcTemplate.query(sqlQuery, new OrderMapper());

		logger.info("All orders has been taken");
		return OrderL.stream().map(x->(IOrder) x).collect(Collectors.toList());
	}
}
