package cn.panda.web.manager.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

/**
 * Servlet implementation class UpdateOrderServlet
 */
@WebServlet("/manager/updateOrder")
public class UpdateOrder extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			BussinessService bs = new BussinessServiceImpl();
			String id = request.getParameter("id");
			boolean state = true;
			bs.updateOrders(id, state);
			request.setAttribute("message", "订单发货成功！");
		} catch (Exception e) {
			request.setAttribute("message", "订单发货失败！");
			throw new RuntimeException(e);
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
