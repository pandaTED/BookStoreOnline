--请另外建一个bookstore_bak的库
CREATE TABLE dbbak(
		id VARCHAR(40) primary key NOT NULL,
 		filename VARCHAR(255) NOT NULL,
 		baktime DATETIME NOT NULL,
 		description VARCHAR(255)
		);