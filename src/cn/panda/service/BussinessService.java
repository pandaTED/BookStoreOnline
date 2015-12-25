package cn.panda.service;

import java.util.List;

import cn.panda.domain.book.Book;
import cn.panda.domain.book.BookPageBean;
import cn.panda.domain.book.BookQueryInfo;
import cn.panda.domain.category.Category;
import cn.panda.domain.customer.Cart;
import cn.panda.domain.customer.User;
import cn.panda.domain.order.Order;

public interface BussinessService {

	/*
	 * 分类相关service
	 */
	void addCategory(Category c);

	Category findCategory(String id);

	List<Category> getAllCategory();

	void addBook(Book book);
	
	void deleteBook(String id);
	
	Book findBook(String id);

	BookPageBean bookPageQuery(BookQueryInfo queryInfo);

	void addUser(User user);

	User findUser(String username, String password);

	User findByUserName(String id);

	void saveOrder(Cart cart, User user);

	Order findOrder(String id);

	List getOrderByState(boolean state);

	List getAllBook();

	void updateOrders(String id, boolean state);

	List listOwnOrder(User user);

}