package cn.panda.dao;

import cn.panda.domain.user.User;

public interface UserDao {

	// 增
	void addUser(User user);

	User findUser(String id);

	User find(String username, String password);

}