package cn.panda.web.manager.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

@WebServlet("/manager/listCategory")
public class ListCategory extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BussinessService bs = new BussinessServiceImpl();
		List list = bs.getAllCategory();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/listcategory.jsp").forward(
				request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
