package cn.panda.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import cn.panda.domain.book.Book;
import cn.panda.domain.book.BookPageBean;
import cn.panda.domain.book.BookQueryInfo;
import cn.panda.domain.category.Category;
import cn.panda.domain.order.Order;
import cn.panda.service.impl.BussinessServiceImpl;
import cn.panda.utils.JdbcUtils;

public class BussinessServiceTest {

	BussinessServiceImpl bs = new BussinessServiceImpl();

	@Test
	public void addCategory() {
		Category c = new Category();
		c.setId("5");
		c.setName("JAVA类");
		c.setDescription("学习java");

		bs.addCategory(c);

		JdbcUtils.commitTransaction();
	}

	@Test
	public void findCategory() {

		Category category = bs.findCategory("5");
		System.out.println(category.getName());
	}

	@Test
	public void getAllCategory() {

		List list = bs.getAllCategory();
		for (int i = 0; i < list.size(); i++) {
			Category category = (Category) list.get(i);
			System.out.println(category.getName());

		}
	}

	@Test
	public void addBook() {

		Category c = new Category();
		c.setId("5");
		c.setName("JAVA类");
		c.setDescription("学习java");

		Book book = new Book();
		book.setId(UUID.randomUUID().toString());
		book.setName("Spring");
		book.setCategory(c);
		book.setPrice(66);
		book.setDescription("spring就是春");
		book.setAuthor("王大伟");
		book.setImage("222222.img");

		bs.addBook(book);

		JdbcUtils.commitTransaction();

	}

	@Test
	public void pageQuery() {
		BookQueryInfo queryInfo = new BookQueryInfo();
		queryInfo.setCurrentPage(1);
		queryInfo.setPageSize(3);

		
		BookPageBean pageBean = bs.bookPageQuery(queryInfo);

		System.out.println(pageBean.getTotalRecord());

	}

	@Test
	public void findOrder() {

		Order order = bs.findOrder("1");
		System.out.println(order.getOrdertime());

	}

}
