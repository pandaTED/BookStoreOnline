package cn.panda.dao.impl;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.panda.dao.UserDao;
import cn.panda.domain.customer.User;
import cn.panda.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	// 增删改查

	// 增
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.UserDao#addUser(cn.panda.domain.User)
	 */
	public void addUser(User user) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into user (id,username,password,phone,cellphone,email,address) values (?,?,?,?,?,?,?)";
			Object params[] = { user.getId(), user.getUsername(),
					user.getPassword(), user.getPhone(), user.getCellphone(),
					user.getEmail(), user.getAddress() };
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 删

	// 改

	// 查

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.UserDao#findUser(java.lang.String)
	 */
	public User findUser(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user where id = ?";
			return (User) runner.query(conn, sql, id, new BeanHandler(
					User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	public User find(String username, String password) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user where username = ? and password = ?";

			return (User) runner.query(conn, sql, new Object[] { username,
					password }, new BeanHandler(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
