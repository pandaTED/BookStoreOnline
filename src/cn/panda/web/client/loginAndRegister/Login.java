package cn.panda.web.client.loginAndRegister;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.user.User;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/client/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			BussinessService bs = new BussinessServiceImpl();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = bs.findUser(username, password);
			if (user == null) {
				request.setAttribute("message", "用户名或密码错误！");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				return;
			}
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
