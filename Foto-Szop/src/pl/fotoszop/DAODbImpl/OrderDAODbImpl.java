package pl.fotoszop.DAODbImpl;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pl.fotoszop.dao.OrderDAO;
import pl.fotoszop.model.Order;
import pl.fotoszop.modelinterfaces.IOrder;
/**
 * 
 * @author Szymon
 *
 */
@Component
@Repository
public class OrderDAODbImpl implements OrderDAO{
	private JdbcTemplate jdbcTemplate;
	
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
		return 0;
	}

	@Override
	public boolean delete(String orderId) {
		String sqlQuery = "delete order_ps where id_order = " + orderId;
		jdbcTemplate.execute(sqlQuery);
		return true;
	}

	@Override
	public IOrder getOrderByClientId(int clientId) {
		String sqlQuery = "select * from order_ps where order_ps.id_client = " + clientId;
		List<Order> OrderL =  this.jdbcTemplate.query(sqlQuery, new OrderMapper());
		
		return OrderL.get(0);
	}

	@Override
	public Collection<IOrder> getAllOrders() {
		String sqlQuery = "select * from order";
		Collection<Order> OrderL =  this.jdbcTemplate.query(sqlQuery, new OrderMapper());
		return OrderL.stream().map(x->(IOrder) x).collect(Collectors.toList());
	}
}
