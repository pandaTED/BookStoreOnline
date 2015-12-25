###1，搭建环境
	####1.1 导入开发包
			mysql驱动
			dbutils
			beanutils
			log4j
			commons-fileupload
			commons-io
			c3p0连接池
			jstl开发包

	####1.2 创建组织程序的包
			cn.panda.domain
			cn.panda.dao
			cn.panda.dao.impl
			cn.panda.service
			cn.panda.service.impl
			cn.panda.web.controller

			创建组织jsp的目录
			webcontext下新建mannager目录，保存后台相关的jsp
						新建client目录，保存前台相关的jsp

	
	创建工程所需的库和表



	创建一些全局的工具类和过滤器
			JdbcUtils
			WebUtils
			CharacterEncodingFilter
			HtmlFilter
			TransactionFilter
			DaoFactory



###2，设计实体
	Category	分类
private	String	id;
private	String	name;
private	String	description;

	Book		书
private	String id;
private	String name;
private	double price;
private	String author;
private	String image   ; //记住书的图片的位置
private	String description;
private	Category category;

	Order 		订单
private	 String 		id					
private	 Date 		ordertime	;			//下单时间
private	 boolean		state	;				//发货状态
private	 double		price		;			//总价
private	 User 		user	;				//用户
private	 Set 		orderitems	;			//订单项

	OrderItem	订单项
private	String id;
private Book book;
private	int  quantity;
private	double price;

	User		用户 
private	String id;
private	String username;
private	String password;
private	String phone;
private	String cellphone;
private	String email;
private	String address;




表设计

分类
create table category
(
	id varchar(40) primary key,
	name varchar(40) not null unique,	
	description	 varchar(255) 
);


用户
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

书
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

订单
create table orders
(
	id varchar(40) primary key,
	ordertime datetime not null,
	state boolean not null,
	price decimal(8,2) not null,
	user_id varchar(40),
	constraint user_id_FK foreign key(user_id) references user(id)
);



订单项
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





dao层



service层



web层

java.lang.RuntimeException: java.sql.SQLException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '='1'limit 0,3' at line 1 Query: select * from bookwhere category_id=?limit ?,? Parameters: [1, 0, 3]
	at cn.panda.dao.impl.BookDaoImpl.pageQuery(BookDaoImpl.java:103)
	at cn.panda.dao.impl.BookDaoImpl.getQueryResult(BookDaoImpl.java:132)
	at cn.panda.service.impl.BussinessServiceImpl.pageQuery(BussinessServiceImpl.java:87)
	at cn.panda.test.BussinessServiceTest.pageQuery(BussinessServiceTest.java:81)
	at sun.reflect.NativeMethodAccessorImpl.inv oke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)
Caused by: java.sql.SQLException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '='1'limit 0,3' at line 1 Query: select * from bookwhere category_id=?limit ?,? Parameters: [1, 0, 3]
	at org.apache.commons.dbutils.AbstractQueryRunner.rethrow(AbstractQueryRunner.java:392)
	at org.apache.commons.dbutils.QueryRunner.query(QueryRunner.java:351)
	at org.apache.commons.dbutils.QueryRunner.query(QueryRunner.java:197)
	at cn.panda.dao.impl.BookDaoImpl.pageQuery(BookDaoImpl.java:100)
	... 26 more

