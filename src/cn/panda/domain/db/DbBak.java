package cn.panda.domain.db;

import java.util.Date;

public class DbBak {
	/**
	 *String id;
	 *String filename;
	 *Date baktime;
	 *String description;
	 	CREATE TABLE dbbak(
		id VARCHAR(40) primary key NOT NULL,
 		filename VARCHAR(40) NOT NULL,
 		baktime DATETIME NOT NULL,
 		description VARCHAR(255)
		);
	 * 
	 * 
	 * 
	 */

	private String id;
	private String filename;
	private Date baktime;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getBaktime() {
		return baktime;
	}
	public void setBaktime(Date baktime) {
		this.baktime = baktime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
