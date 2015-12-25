package cn.panda.dao;

import cn.panda.domain.customer.User;

public interface UserDao {

	// 增
	void addUser(User user);

	User findUser(String id);

	User find(String username, String password);

}