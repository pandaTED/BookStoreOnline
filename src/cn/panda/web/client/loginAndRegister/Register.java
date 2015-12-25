package cn.panda.web.client.loginAndRegister;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.customer.User;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;
import cn.panda.utils.WebUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/client/register")
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			BussinessService bs = new BussinessServiceImpl();
			User user = WebUtils.request2Bean(request, User.class);
			user.setId(UUID.randomUUID().toString());
			bs.addUser(user);
			request.setAttribute("message", "注册成功!");
			request.getSession().setAttribute("user", user);
		} catch (Exception e) {
			request.setAttribute("message", "注册成功!");
			throw new RuntimeException(e);
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
