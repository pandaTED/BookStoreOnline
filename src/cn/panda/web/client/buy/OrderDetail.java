package cn.panda.web.client.buy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.order.Order;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

@WebServlet("/client/orderDetail")
public class OrderDetail extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderID = request.getParameter("id");
		BussinessService bs = new BussinessServiceImpl();
		Order orderDetail = bs.findOrder(orderID);
		request.getSession().setAttribute("orderDetail", orderDetail);
		request.getRequestDispatcher("/client/orderDetail.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
