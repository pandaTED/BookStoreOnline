create table user
(
	id varchar(40) primary key,
	name varchar(40) not null unique,
	password varchar(40) not null,
	phone varchar(20) not null,
	cellphone varchar(20) not null,
	email varchar(40) not null,
	address varchar(255) not null
);