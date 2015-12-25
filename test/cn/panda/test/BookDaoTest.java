package cn.panda.test;

import org.junit.Test;

import cn.panda.dao.impl.BookDaoImpl;

public class BookDaoTest {
	
	
	@Test
	public void deleteBook(){
		
		String id = "6349b57c-2ae4-4d6c-8fac-d91d5a77cb6d";
		BookDaoImpl bd = new BookDaoImpl();
		bd.deleteBook(id);

	}
	

}
