package cn.panda.domain.book;

import java.util.List;

public class BookQueryResult {
	private List list;
	private int totalrecord;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

}
