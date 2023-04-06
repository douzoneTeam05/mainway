package order;

import java.util.ArrayList;

public class OrderService {
	OrderDAO orderDAO;
	
	public OrderService() {
		orderDAO = new OrderDAO();
	}
	
	public void insertOrder(OrderDTO order) {
		orderDAO.insertOrder(order);			
	}
	
	public ArrayList<OrderDTO> selectOrders(String member_id) {
		return orderDAO.selectOrders(member_id);
	}
	
	public OrderDTO selectOrderById(int id) {
		return orderDAO.selectOrderById(id);
	}
	
	public ArrayList<OrderDTO> selectOrderByMemberId(String member_id) {
		return orderDAO.selectOrderByMemberId(member_id);
	}
	
	public void updateOrder(OrderDTO order) {
		orderDAO.updateOrder(order);
	}
	
	public void deleteOrder(String id) {
		orderDAO.deleteOrder(id);
	}
}