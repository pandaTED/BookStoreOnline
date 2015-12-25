package cn.panda.dao;

import java.util.List;

import cn.panda.domain.db.DbBak;

public interface DbBakDao {

	void add(DbBak bak);

	List getAll();

	DbBak find(String id);

}