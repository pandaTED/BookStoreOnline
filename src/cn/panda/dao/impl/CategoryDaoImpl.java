package cn.panda.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.panda.dao.CategoryDao;
import cn.panda.domain.category.Category;
import cn.panda.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	// 增删改查

	// 增
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.CategoryDao#addCategory(cn.panda.domain.Category)
	 */
	public void addCategory(Category c) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into category (id,name,description) values (?,?,?)";
			Object params[] = { c.getId(), c.getName(), c.getDescription() };
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 删
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.CategoryDao#deleteCategory(java.lang.String)
	 */
	public void deleteCategory(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "delete from category where id = ?";
			runner.update(conn, sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 改
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.panda.dao.impl.CategoryDao#updateCategory(cn.panda.domain.Category)
	 */
	public void updateCategory(Category category) {

	}

	// 查
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.CategoryDao#findCategory(java.lang.String)
	 */
	public Category findCategory(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from category where id = ?";
			return (Category) runner.query(conn, sql, id, new BeanHandler(
					Category.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 得到全部分类
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.panda.dao.impl.CategoryDao#getAllCategory()
	 */
	public List getAllCategory() {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from category";
			return (List) runner.query(conn, sql, new BeanListHandler(
					Category.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
