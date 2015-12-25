package cn.panda.domain.db;

import java.util.Date;

public class DbBak {

	private String id;
	private Date bkTime;
	private String description;
	private String fileName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBkTime() {
		return bkTime;
	}

	public void setBkTime(Date bkTime) {
		this.bkTime = bkTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
