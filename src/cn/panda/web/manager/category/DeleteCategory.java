package cn.panda.web.manager.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

/**
 * Servlet implementation class DeleteCategory
 */
@WebServlet("/manager/deleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String id = request.getParameter("id");
		BussinessService bs = new BussinessServiceImpl();
		bs.deleteCategory(id);
		request.setAttribute("message", "删除成功！");
		}catch(Exception e){
			request.setAttribute("message", "删除失败！此分类下有图书！");
			
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
