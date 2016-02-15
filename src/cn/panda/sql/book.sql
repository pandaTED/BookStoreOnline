create table book
(
	id varchar(40) primary key,
	name varchar(40) not null unique,	
	price decimal(8,2) not null,
	author varchar(40) not null,
	image varchar(255) not null,
	description	 varchar(255) ,
	category_id varchar(40),
	constraint category_id_FK foreign key(category_id) references category(id)
);