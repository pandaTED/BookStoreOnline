create table category
(
	id varchar(40) primary key,
	name varchar(40) not null unique,	
	description	 varchar(255) 
);