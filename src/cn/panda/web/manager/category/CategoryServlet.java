package cn.panda.web.manager.category;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.category.Category;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;
import cn.panda.utils.WebUtils;

/**
 * Servlet implementation class CategoryServlet
 * cn.panda.web.manager.CategoryServlet
 */

@WebServlet("/manager/categoryServlet")
public class CategoryServlet extends HttpServlet {

	private BussinessService service = new BussinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String method = request.getParameter("method");
		String method = "add";
		if ("add".equals(method)) {
			add(request, response);
		}
		if ("getAll".equals(method)) {
			getAll(request, response);
		}

	}

	private void getAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> list = service.getAllCategory();
		request.setAttribute("categories", list);

		request.getRequestDispatcher("/manager/listcategory.jsp").forward(
				request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Category c = WebUtils.request2Bean(request, Category.class);
			c.setId(UUID.randomUUID().toString());
			service.addCategory(c);
			request.setAttribute("message", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}