package pl.fotoszop.DAODbImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.fotoszop.model.Order;

public class OrderMapper implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setOrderId(rs.getInt("id_order"));
		order.setDateOfOrder(rs.getDate("dae_of_order"));
		order.setIdOfRealizationTerm("" + rs.getInt("id_of_realization_term"));
		order.setDateOfModification(rs.getDate("date_of_modification"));
		order.setOrderStatus(rs.getString("order_status"));
		order.setServiceId(rs.getInt("id_service"));
		order.setClientId( rs.getInt("id_client"));
		return order;
	}

}
