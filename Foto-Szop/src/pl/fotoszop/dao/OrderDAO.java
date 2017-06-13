package pl.fotoszop.dao;

import pl.fotoszop.modelinterfaces.IOrder;

import java.util.List;

public interface OrderDAO {
    /**
     * Method to save object in storage, passed order  is sought through storage and update if
     * order on the same id already exist, in other case it create new order object with new id
     *
     * @param order object to save in storage
     * @return new generated id for saved order if passed doesn't exist. If the order already exist
     * the same id what passed object has.
     */
    public int saveOrUpdate(IOrder order);

    /**
     * Delete order for passed order id
     *
     * @param orderId - id of order - for instance, primary key for database
     * @return true - if deleting was successful, false if order on passed id doesn't exist
     */
    public boolean delete(String orderId);

    /**
     * Method to obtain all orders
     *
     * @return All orders objects from data storage or empty collection
     */
    public List<IOrder> getAllOrders(int clientId);

}
