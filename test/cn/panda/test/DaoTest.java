package cn.panda.test;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import cn.panda.dao.BookDao;
import cn.panda.dao.CategoryDao;
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
import cn.panda.domain.order.Order;
import cn.panda.domain.order.OrderItem;
import cn.panda.domain.user.User;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;
import cn.panda.utils.JdbcUtils;

public class DaoTest {

	@Test
	public void addUser() {

		UserDao userdao = new UserDaoImpl();
		String id = "2";
		String username = "孙晓蓓";
		String password = "123456";
		String phone = "8933418";
		String cellphone = "13053876411";
		String email = "sunxiaobei@gmail.com";
		String address = "山东泰安";

		User user = new User();

		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(cellphone);
		user.setCellphone(cellphone);
		user.setEmail(email);
		user.setAddress(address);

		userdao.addUser(user);

		JdbcUtils.commitTransaction();
	}

	@Test
	public void addCategory() {

		CategoryDao categorydao = new CategoryDaoImpl();

		Category category = new Category();

		String id = "2";
		String name = "科普类";
		String description = "知道的越多越好";

		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		categorydao.addCategory(category);

		JdbcUtils.commitTransaction();

	}

	@Test
	public void addBook() {

		BookDao bookdao = new BookDaoImpl();
		Book book = new Book();

		String id = "2";
		String name = "科普类";
		String description = "知道的越多越好";

		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		String id1 = "2";
		String name1 = "JavaEE";
		double price = 50;
		String author = "汤阳光";
		String image = "2222.img"; // 记住书的图片的位置
		String description1 = "javaEE必备";

		book.setId(id1);
		book.setName(name1);
		book.setPrice(price);
		book.setAuthor(author);
		book.setImage(image);
		book.setDescription(description1);
		book.setCategory(category);

		bookdao.addBook(book);

		JdbcUtils.commitTransaction();
	}

	@Test
	public void addOrder() {
		BookDao bookdao = new BookDaoImpl();
		UserDao userdao = new UserDaoImpl();
		CategoryDao categorydao = new CategoryDaoImpl();

		// 得到用户
		String id = "2";
		String username = "孙晓蓓";
		String password = "123456";
		String phone = "8933418";
		String cellphone = "13053876411";
		String email = "sunxiaobei@gmail.com";
		String address = "山东泰安";

		User user = new User();

		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(cellphone);
		user.setCellphone(cellphone);
		user.setEmail(email);
		user.setAddress(address);

		// 得到书

		Book book = new Book();

		String id5 = "2";
		String name = "科普类";
		String description = "知道的越多越好";

		Category category = new Category();
		category.setId(id5);
		category.setName(name);
		category.setDescription(description);

		String id1 = "2";
		String name1 = "JavaEE";
		double price = 50;
		String author = "汤阳光";
		String image = "2222.img"; // 记住书的图片的位置
		String description1 = "javaEE必备";

		book.setId(id1);
		book.setName(name1);
		book.setPrice(price);
		book.setAuthor(author);
		book.setImage(image);
		book.setDescription(description1);
		book.setCategory(category);

		// 得到订单项
		OrderItem orderitem = new OrderItem();
		String id2 = "1";
		Book book2 = book;
		int quantity = 2;
		double price2 = book.getPrice() * quantity;

		orderitem.setId(id2);
		orderitem.setBook(book2);
		orderitem.setQuantity(quantity);
		orderitem.setPrice(price2);

		// 生成订单
		String id3 = "1";
		Date ordertime = new Date(115, 10, 29); // 下单时间
		boolean state = false; // 发货状态
		double price1 = orderitem.getPrice(); // 总价
		// User
		Set orderitems = new HashSet<OrderItem>();
		orderitems.add(orderitem);

		Order order = new Order();

		order.setId(id3);
		order.setOrdertime(ordertime);
		order.setState(state);
		order.setPrice(price1);
		order.setUser(user);
		order.setOrderitems(orderitems);

		OrderDao orderdao = new OrderDaoImpl();

		orderdao.addOrder(order);

		JdbcUtils.commitTransaction();
	}

	@Test
	public void findOrder() {

		OrderDao orderdao = new OrderDaoImpl();
		Order order = orderdao.findOrder("1");
		System.out.println(order.getId());

	}

	@Test
	public void findUser() {

		UserDao userdao = new UserDaoImpl();
		User user = userdao.find("朱运鹏", "123456");
		System.out.println(user.getId());

	}

	@Test
	public void categoryUser() {
		CategoryDao categorydao = new CategoryDaoImpl();
		Category category = categorydao.findCategory("1");
		System.out.println(category.getId() + "&" + category.getName());
	}

	@Test
	public void findBook() {
		BookDao bookdao = new BookDaoImpl();
		Book book = bookdao.findBook("1");
		System.out.println(book.getId() + "&" + book.getName() + "&"
				+ book.getDescription());
	}

	@Test
	public void getAllOrder() {
		OrderDao orderdao = new OrderDaoImpl();
		List<Order> list = orderdao.getAll(false);
		for (int i = 0; i < list.size(); i++) {
			Order order = list.get(i);
			System.out.println(order.getId());
		}
	}

	@Test
	public void getqueryresult() {
		BookDao bookdao = new BookDaoImpl();
		BookQueryResult queryresult = new BookQueryResult();
		queryresult = bookdao.getQueryResult(0, 5, "");
		System.out.println(queryresult.getTotalrecord());

		List<Book> list = queryresult.getList();
		for (int i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			System.out.println(book.getName());
		}
	}

	@Test
	public void getqueryresult1() {
		BussinessService bs = new BussinessServiceImpl();

		BookQueryInfo bi = new BookQueryInfo();
		
		BookPageBean bqBean = bs.bookPageQuery(bi);
		List list = bqBean.getList();
		for (int i = 0; i < list.size(); i++) {
			Book book = (Book) list.get(i);
			System.out.println(book.getName());
		}
	}

	@Test
	public void getAllBook() {

		BookDaoImpl bd = new BookDaoImpl();
		List list = bd.getAllBook();
		for (int i = 0; i < list.size(); i++) {
			Book book = (Book) list.get(i);
			System.out.println(book.getName());

		}
	}
}
