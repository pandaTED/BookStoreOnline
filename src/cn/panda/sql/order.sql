create table orders
(
	id varchar(40) primary key,
	ordertime datetime not null,
	state boolean not null,
	price decimal(8,2) not null,
	user_id varchar(40),
	constraint user_id_FK foreign key(user_id) references user(id)
);