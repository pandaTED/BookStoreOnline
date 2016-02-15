create table orderitem
(
	id varchar(40) primary key,
	quantity int not null,
	price decimal(8,2) not null,
	book_id varchar(40),
	constraint book_id_FK foreign key(book_id) references book(id),
	order_id varchar(40),
	constraint order_id_FK foreign key(order_id) references orders(id)
);
