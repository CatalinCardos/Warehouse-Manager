package businesslogic;

import dataAccess.OrderDAO;
import model.Client;
import model.Order;

import java.util.List;

public class OrderBLL {
    private OrderDAO orderDAO;

    public OrderBLL() {
        this.orderDAO = new OrderDAO();
    }

    public List<Order> findALL()
    {
        List<Order> orders = orderDAO.findAll();

        return orders;
    }
    public void insertOrder(Order order)
    {
        orderDAO.insert(order);
    }
    public void delete(int id, String chosenType)
    {
        orderDAO.deleteById(id,chosenType);
    }
}
