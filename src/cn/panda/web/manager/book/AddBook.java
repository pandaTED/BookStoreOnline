package cn.panda.web.manager.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.book.Book;
import cn.panda.domain.category.Category;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;
import cn.panda.utils.WebUtils;

@WebServlet("/manager/addBook")
public class AddBook extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BussinessService bs = new BussinessServiceImpl();
		List<Category> list = bs.getAllCategory();
		request.setAttribute("categories", list);
		request.getRequestDispatcher("/manager/addBook.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			BussinessService bs = new BussinessServiceImpl();
			Book book = WebUtils.upload(request, this.getServletContext()
					.getRealPath("/images"));
			bs.addBook(book);
			request.setAttribute("message", "添加成功！！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
