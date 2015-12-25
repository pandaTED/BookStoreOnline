package cn.panda.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import cn.panda.utils.JdbcUtils;

public class TransactionFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// index.jsp
		// 拦截下来后：获取连接，开启事务，并把连接绑定到当前线程
		try {
			// JdbcUtils.StartTransaction();
			chain.doFilter(req, resp);
			// 获取当前线程上绑定的连接，提交事务，并关闭连接，释放连接与当前线程的绑定
			JdbcUtils.commitTransaction();
		} finally {
			JdbcUtils.closeConn();
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
