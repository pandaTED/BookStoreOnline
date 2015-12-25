package cn.panda.web.client.buy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.customer.User;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

@WebServlet("/client/listOwnOrders")
public class listOwnOrders extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BussinessService bs = new BussinessServiceImpl();
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			request.setAttribute("message", "请先登录");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}else{
		List listOwnOrder = bs.listOwnOrder(user);
		request.getSession().setAttribute("listOwnOrder", listOwnOrder);
		request.getRequestDispatcher("/client/listOwnOrders.jsp").forward(
				request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
