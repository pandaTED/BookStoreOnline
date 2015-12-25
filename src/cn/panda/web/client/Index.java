package cn.panda.web.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.book.BookPageBean;
import cn.panda.domain.book.BookQueryInfo;
import cn.panda.domain.category.Category;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;
import cn.panda.utils.WebUtils;

@WebServlet("/client/index")
public class Index extends HttpServlet {
	private BussinessService service = new BussinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookQueryInfo info = new BookQueryInfo();
		
		System.out.println("firstTime>>getCurrentPage()="+info.getCurrentPage());
		System.out.println("firstTime>>getPageSize()="+info.getPageSize());
		System.out.println("firstTime>>getStartIndex()="+info.getStartIndex());
		System.out.println("firstTime>>getWhere()="+info.getWhere());

		
		 info = WebUtils.request2Bean(request, BookQueryInfo.class);
		 
		String category_id = info.getCategory_id();
	
		
		System.out.println("分类的id>>>>category_id="+category_id);
		
		if (category_id != null && !category_id.trim().equals("")) {
			
			System.out.println("secondTime>>getCurrentPage()="+info.getCurrentPage());
			System.out.println("secondTime>>getPageSize()="+info.getPageSize());
			System.out.println("secondTime>>getStartIndex()="+info.getStartIndex());
			System.out.println("secondTime>>getWhere()="+info.getWhere());
			
		}
		
		List<Category> categories = service.getAllCategory();
		BookPageBean pagebean = service.bookPageQuery(info);

		request.setAttribute("categories", categories);
		request.setAttribute("pageBean", pagebean);

		request.getRequestDispatcher("/client/index.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}