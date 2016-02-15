package cn.panda.service;

import java.util.List;

import cn.panda.domain.book.Book;
import cn.panda.domain.book.BookPageBean;
import cn.panda.domain.book.BookQueryInfo;
import cn.panda.domain.category.Category;
import cn.panda.domain.db.DbBak;
import cn.panda.domain.order.Order;
import cn.panda.domain.user.Cart;
import cn.panda.domain.user.User;

public interface BussinessService {

	/**
	 * 图书分类相关
	 * @param c
	 */
	void addCategory(Category c);

	Category findCategory(String id);

	List<Category> getAllCategory();
	
	void deleteCategory(String id);

	/**
	 * 图书相关
	 * @param book
	 */
	void addBook(Book book);
	
	void deleteBook(String id);
	
	Book findBook(String id);

	BookPageBean bookPageQuery(BookQueryInfo queryInfo);
	
	/**
	 * 用户相关
	 * @param user
	 */

	void addUser(User user);

	User findUser(String username, String password);

	User findByUserName(String id);
	
	/**
	 * 用户购物相关
	 * @param cart
	 * @param user
	 */

	void saveOrder(Cart cart, User user);

	Order findOrder(String id);

	List getOrderByState(boolean state);

	List getAllBook();

	void updateOrders(String id, boolean state);

	List listOwnOrder(User user);
	
	/**
	 * 
	 * 数据库备份与恢复相关
	 * @param bak
	 */
	
	public void addDbBak(DbBak bak);
	public List getAllBak();
	public DbBak findDbBak(String id);

}