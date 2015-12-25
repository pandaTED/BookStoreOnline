package cn.panda.web.manager.dbBack;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.db.DbBak;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

@WebServlet("/manager/dbBackUp")
public class DbBackUp extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BussinessService bs = new BussinessServiceImpl();
		try {
			String bakpath = this.getServletContext().getRealPath("/bakup");
			String filename = System.currentTimeMillis() + ".sql";

			// 1.作备份操作
			String command = "cmd /c mysqldump -uroot -proot bookstore>"
					+ bakpath + "\\" + filename; // windows
			Runtime.getRuntime().exec(command);

			// 2.把备份信息封装到一个javabean中，并把javabean保存数据库
			DbBak bak = new DbBak();
			bak.setBkTime(new Date());
			bak.setDescription(request.getParameter("description"));
			bak.setFileName(bakpath + "\\" + filename);
			bak.setId(UUID.randomUUID().toString());
			// bs.addDbBak(bak);
			// TODO 今后写把备份数据库信息存到数据库的方法
			request.setAttribute("message", "备份成功！！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "备份失败！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
