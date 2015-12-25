package cn.panda.web.client.buy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.customer.Cart;
import cn.panda.domain.customer.User;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/client/addOrder")
public class AddOrder extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			BussinessService bs = new BussinessServiceImpl();
			if (request.getSession().getAttribute("user") == null) {
				request.setAttribute("message", "请先登录");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				return;
			}
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			User user = (User) request.getSession().getAttribute("user");
			bs.saveOrder(cart, user);
			request.getSession().removeAttribute("cart");
			request.setAttribute("message", "订单已下！");
		} catch (Exception e) {
			request.setAttribute("message", "提交订单失败！");
			throw new RuntimeException(e);
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
