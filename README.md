# BookStoreOnline
	这是一个简单的在线书店项目。
##功能简介
	后台管理部分：
		1.图书分类的添加与删除
		2.图书的添加与删除
		3.订单管理：
			未发货订单的查看与发货
			发货订单的查看
		4.数据库的备份与恢复功能
	前台用户界面部分：
		1.用户的注册与登录功能
		2.用户的购买功能
		3.用户的查看购物车、提交订单的功能
		4.按照分类查看图书
		5.图书的分页显示功能
##技术实现
###用到的库
	1.数据源采用c3p0连接池，版本号0.9.5.1，需要mchange包，版本号0.2.10
	2.数据库采用mysql，版本号5.1.7，需要数据库的jdbc驱动mysql-connector-java
	3.数据库的CRUD功能采用dbutils，版本号1.6
	4.前台数据封装采用beanutils，版本号1.8.0，需要common-logging包
	5.需要jstl包
	6.上传封面、数据库备份与恢复功能需要commons-fileupload包，版本号1.3.1，需要commons-io包，版本号2.4
###用到的技术
	1.利用servlet的filter功能，设置全局的request编码为utf-8
	2.利用servlet的filter功能，过滤每次request请求，自动提交DAO的事务
	3.利用servlet的filter功能，将用户输入的字符进行转义，以保障系统的安全】
	4.DAO的管理采用工厂模式，所有的DAO交由DaoFactory管理
##部署时请注意
	请在c3p0-config.xml内设置自己的数据库信息
