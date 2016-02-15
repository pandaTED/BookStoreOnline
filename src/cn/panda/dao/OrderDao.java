package cn.panda.dao;

import java.util.List;

import cn.panda.domain.order.Order;
import cn.panda.domain.user.User;

public interface OrderDao {

	// 添加订单
	void addOrder(Order order);

	// 查找订单
	Order findOrder(String id);

	List<Order> getAll(boolean state);

	void updateOrder(String id, boolean state);

	List<Order> getOrdersByUserId(User user);

}