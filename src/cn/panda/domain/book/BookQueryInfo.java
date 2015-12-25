package cn.panda.domain.book;

//封装查询信息
public class BookQueryInfo {

	private int currentPage = 1;
	private int pageSize = 6;
	private int startIndex;
	
	private String category_id;
	private String where;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		this.startIndex = (this.currentPage - 1) * this.pageSize;
		return startIndex;
	}
	
	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getWhere() {
		if (this.category_id == null || this.category_id.trim().equals("")) {
			return null;
		} else {
			this.where = " where category_id = "+ "\""+this.category_id+"\""+" ";
		}
		return where;
	}

}
