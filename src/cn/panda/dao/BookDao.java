package cn.panda.dao;

import java.util.List;

import cn.panda.domain.book.Book;
import cn.panda.domain.book.BookQueryResult;

public interface BookDao {

	// 增
	void addBook(Book book);

	// 删
	public void deleteBook(String id);

	// 查
	Book findBook(String id);

	BookQueryResult getQueryResult(int startindex, int pagesize, String where);

	List getAllBook();

}