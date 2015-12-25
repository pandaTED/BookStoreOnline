package cn.panda.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.panda.dao.BookDao;
import cn.panda.domain.book.Book;
import cn.panda.domain.book.BookQueryResult;
import cn.panda.utils.JdbcUtils;

public class BookDaoImpl implements BookDao {
	// 增删改查

	// 增

	public void addBook(Book book) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into book (id,name,price,author,image,description,category_id) values(?,?,?,?,?,?,?)";
			Object params[] = { book.getId(), book.getName(), book.getPrice(),
					book.getAuthor(), book.getImage(), book.getDescription(),
					book.getCategory().getId() };
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	// 删

	public void deleteBook(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "delete from book where id = ?";
			runner.update(conn, sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	// 查

	public Book findBook(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from book where id = ?";
			return (Book) runner.query(conn, sql, id, new BeanHandler(
					Book.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 获取分页的书
	/*
	 * String where = "where category_id = ?"
	 */
	private List<Book> pageQuery(int startindex, int pagesize, String where) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			if (where == null || where.trim().equals("")) {
				String sql = "select * from book limit ?,?";
				Object params[] = { startindex, pagesize };
				return (List<Book>) runner.query(conn, sql, params,
						new BeanListHandler(Book.class));
			} else {
				String sql = "select * from book" + where + "limit ?,?";
				System.out.println(sql);
				Object params[] = { startindex, pagesize };
				return (List<Book>) runner.query(conn, sql, params,
						new BeanListHandler(Book.class));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 获取所有书的数量
	private int getNum(String where) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			if (where == null || where.trim().equals("")) {
				String sql = "select count(*) from book";
				return ((Long) runner.query(conn, sql, new ScalarHandler()))
						.intValue();
			} else {
				String sql = "select count(*) from book" + where;
				return ((Long) runner.query(conn, sql,
						new ScalarHandler())).intValue();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 获取QuerySesult

	public BookQueryResult getQueryResult(int startindex, int pagesize,String where) {

		List list = pageQuery(startindex, pagesize, where);
		int num = getNum(where);
		BookQueryResult result = new BookQueryResult();
		result.setList(list);
		result.setTotalrecord(num);
		return result;
	}

	public List getAllBook() {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from book";
			return (List<Book>) runner.query(conn, sql, new BeanListHandler(
					Book.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
