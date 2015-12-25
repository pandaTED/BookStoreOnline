package cn.panda.domain.book;

import java.util.List;

public class BookPageBean {

	private List list; // 数据库查询得知 1
	private int totalRecord; // 数据库查询得知 1
	private int pageSize; // 客户设定 默认
	private int totalPage; // 计算得出 根据总记录数和每页显示多少条计算得出
	private int currentPage; // 客户设定 默认
	private int previousPage; // 计算得来 根据当前页计算
	private int nextPage; // 计算得来 根据当前页计算
	private int[] pageBar; // 计算得来 根据当前页和总页面数计算出来

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// 计算出来的
	public int getTotalPage() {
		if (this.totalRecord <= this.pageSize) {
			this.totalPage = 1;
		} else {
			if (this.totalRecord % this.pageSize == 0) {
				this.totalPage = this.totalRecord / this.pageSize;
			} else {
				this.totalPage = this.totalRecord / this.pageSize + 1;
			}

		}
		return totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	// 上一页，计算出来的
	public int getPreviousPage() {
		if (this.currentPage - 1 > 0) {
			this.previousPage = this.currentPage - 1;
		} else {
			this.previousPage = this.currentPage;
		}
		return previousPage;
	}

	// 下一页，这是计算出来的
	public int getNextPage() {

		if (this.currentPage < this.totalPage) {
			this.nextPage = this.currentPage + 1;
		} else {
			this.nextPage = this.totalPage;
		}
		return nextPage;
	}

	// 计算出来的
	public int[] getPageBar() {

		int startPage;
		int endPage;

		if (this.totalPage <= 10) {
			startPage = 1;
			endPage = this.totalPage;
		} else {
			startPage = this.currentPage - 4;
			endPage = this.currentPage + 5;

			if (startPage < 1) {
				startPage = 1;
			}
			if (endPage > this.totalPage) {
				endPage = this.totalPage;
				startPage = this.totalPage - 9;
			}
		}

		this.pageBar = new int[endPage - startPage + 1];

		int index = 0;

		for (int i = startPage; i <= endPage; i++) {
			this.pageBar[index++] = i;
		}

		return pageBar;
	}

}
