package cn.panda.dao;

import java.util.List;

import cn.panda.domain.category.Category;

public interface CategoryDao {

	// 增
	void addCategory(Category c);

	// 删
	void deleteCategory(String id);

	// 改
	void updateCategory(Category category);

	// 查
	Category findCategory(String id);

	// 得到全部分类
	List getAllCategory();

}