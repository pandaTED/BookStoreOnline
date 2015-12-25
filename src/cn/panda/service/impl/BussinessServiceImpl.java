package cn.panda.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import cn.panda.dao.BookDao;
import cn.panda.dao.CategoryDao;
import cn.panda.dao.DbBakDao;
import cn.panda.dao.OrderDao;
import cn.panda.dao.UserDao;
import cn.panda.dao.impl.BookDaoImpl;
import cn.panda.dao.impl.CategoryDaoImpl;
import cn.panda.dao.impl.OrderDaoImpl;
import cn.panda.dao.impl.UserDaoImpl;
import cn.panda.domain.book.Book;
import cn.panda.domain.book.BookPageBean;
import cn.panda.domain.book.BookQueryInfo;
import cn.panda.domain.book.BookQueryResult;
import cn.panda.domain.category.Category;
import cn.panda.domain.customer.Cart;
import cn.panda.domain.customer.CartItem;
import cn.panda.domain.customer.User;
import cn.panda.domain.db.DbBak;
import cn.panda.domain.order.Order;
import cn.panda.domain.order.OrderItem;
import cn.panda.factory.DaoFactory;
import cn.panda.service.BussinessService;

public class BussinessServiceImpl implements BussinessService {

	private CategoryDao cdao = DaoFactory.getInstance().createDao(
			CategoryDao.class);
	private BookDao bdao = DaoFactory.getInstance().createDao(BookDao.class);
	private UserDao udao = DaoFactory.getInstance().createDao(UserDao.class);
	private OrderDao odao = DaoFactory.getInstance().createDao(OrderDao.class);
	private DbBakDao ddao = DaoFactory.getInstance().createDao(DbBakDao.class); 
	
	/*
	 * 分类相关service
	 */

	public void addCategory(Category c) {
		cdao.addCategory(c);
	}

	public Category findCategory(String id) {
		return cdao.findCategory(id);
	}

	public List<Category> getAllCategory() {
		return cdao.getAllCategory();
	}

	/*
	 * 图书相关service
	 */

	public void addBook(Book book) {
		bdao.addBook(book);
	}

	public Book findBook(String id) {
		return bdao.findBook(id);
	}
	
	public void deleteBook(String id) {
		bdao.deleteBook(id);
	}
	

	public BookPageBean bookPageQuery(BookQueryInfo queryInfo) {
		
		
		System.out.println("service内>>getStartIndex()="+queryInfo.getStartIndex());
		System.out.println("service内>>=getPageSize()="+queryInfo.getPageSize());
		System.out.println("service内>>getWhere()="+queryInfo.getWhere());
		
		BookQueryResult queryResult = bdao.getQueryResult(
				queryInfo.getStartIndex(), queryInfo.getPageSize(),
				queryInfo.getWhere());
		BookPageBean pageBean = new BookPageBean();

		pageBean.setCurrentPage(queryInfo.getCurrentPage());
		pageBean.setPageSize(queryInfo.getPageSize());
		pageBean.setList(queryResult.getList());
		pageBean.setTotalRecord(queryResult.getTotalrecord());

		return pageBean;
	}

	public List getAllBook() {
		return bdao.getAllBook();
	}

	/*
	 * 用户相关的service
	 */

	public void addUser(User user) {
		udao.addUser(user);
	}

	public User findUser(String username, String password) {
		return udao.find(username, password);
	}

	public User findByUserName(String id) {

		return udao.findUser(id);

	}

	/*
	 * 订单相关的service
	 */
	// 用用户的购物车，产生订单对象，并保存到数据库

	public void saveOrder(Cart cart, User user) {

		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);

		// 定义一个集合，用于保存所有订单项
		Set orderItems = new HashSet();

		Set<Map.Entry<String, CartItem>> set = cart.getMap().entrySet();
		for (Map.Entry<String, CartItem> entry : set) {
			CartItem cartItem = entry.getValue();
			OrderItem orderItem = new OrderItem();

			// 用购物车中的购物项生成订单项
			orderItem.setBook(cartItem.getBook());
			orderItem.setId(UUID.randomUUID().toString());
			orderItem.setPrice(cartItem.getPrice());
			orderItem.setQuantity(cartItem.getQuantity());

			orderItems.add(orderItem);

		}

		order.setOrderitems(orderItems);
		odao.addOrder(order);

	}

	public Order findOrder(String id) {

		return odao.findOrder(id);
	}

	public List getOrderByState(boolean state) {
		return odao.getAll(state);
	}

	public void updateOrders(String id, boolean state) {
		odao.updateOrder(id, state);
	}

	public List listOwnOrder(User user) {
		return odao.getOrdersByUserId(user);
	}
	
	public void addDbBak(DbBak bak){
		ddao.add(bak);
	}
	
	public List getAllBak(){
		return ddao.getAll();
	}
	
	public DbBak findDbBak(String id){
		return ddao.find(id);
	}
	
	
}
