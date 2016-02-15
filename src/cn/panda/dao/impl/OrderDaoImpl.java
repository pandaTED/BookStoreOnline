package cn.panda.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.panda.dao.OrderDao;
import cn.panda.domain.book.Book;
import cn.panda.domain.order.Order;
import cn.panda.domain.order.OrderItem;
import cn.panda.domain.user.User;
import cn.panda.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	// 添加订单
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.OrderDao#addOrder(cn.panda.domain.Order)
	 */
	public void addOrder(Order order) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into orders (id,ordertime,state,price,user_id) values (?,?,?,?,?)";
			Object params[] = { order.getId(), order.getOrdertime(),
					order.isState(), order.getPrice(), order.getUser().getId() };
			runner.update(conn, sql, params);

			Set<OrderItem> set = order.getOrderitems();
			for (OrderItem item : set) {
				sql = "insert into orderitem (id,quantity,price,book_id,order_id) values (?,?,?,?,?)";
				params = new Object[] { item.getId(), item.getQuantity(),
						item.getPrice(), item.getBook().getId(), order.getId() };
				runner.update(conn, sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 查找订单
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.OrderDao#findOrder(java.lang.String)
	 */
	public Order findOrder(String id) {
		try {
			// 查找订单
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from orders where id = ?";
			Order order = (Order) runner.query(conn, sql, id, new BeanHandler(
					Order.class));

			// 查找每个订单项的信息
			sql = "select * from orderitem where order_id = ? ";
			List<OrderItem> list = (List<OrderItem>) runner.query(conn, sql,
					id, new BeanListHandler(OrderItem.class));

			// 查找每个订单项里的书

			for (OrderItem item : list) {
				sql = "select b.* from orderitem oi ,book b where oi.id = ? and b.id = oi.book_id";
				Book book = (Book) runner.query(conn, sql, item.getId(),
						new BeanHandler(Book.class));
				item.setBook(book);
			}
			order.getOrderitems().addAll(list);

			// 找出下订单的人
			sql = "select u.* from orders o ,user u where o.id = ? and u.id = o.user_id ";
			User user = (User) runner.query(conn, sql, id, new BeanHandler(
					User.class));
			order.setUser(user);
			return order;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.OrderDao#getAll(boolean)
	 */
	public List<Order> getAll(boolean state) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from orders where state = ?";
			List<Order> list = (List<Order>) runner.query(conn, sql, state,
					new BeanListHandler(Order.class));
			for (Order order : list) {
				sql = "select u.* from orders o,user u where o.id =? and u.id = o.user_id";
				User user = (User) runner.query(conn, sql, order.getId(),
						new BeanHandler(User.class));
				order.setUser(user);
			}

			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	// 订单发货
	public void updateOrder(String id, boolean state) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "update orders set state =? where id =?";
			Object params[] = { state, id };
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 通过用户id查找订单
	public List<Order> getOrdersByUserId(User user) {

		// TODO 未登录时，session里没有储存user，所以这里会报错，在servlet里加验证
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from orders where user_id = ?";
			List<Order> list = (List<Order>) runner.query(conn, sql,
					user.getId(), new BeanListHandler(Order.class));

			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
