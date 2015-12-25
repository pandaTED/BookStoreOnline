<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台左侧导航页面</title>

</head>

<body>

	<ul style="font-size: 20px">*分类管理
	</ul>
	<ul>
		<a href="${pageContext.request.contextPath }/manager/addcategory.jsp"
			target="right">添加分类</a>
	</ul>
	<ul>
		<a href="${pageContext.request.contextPath }/manager/listCategory"
			target="right">查看分类</a>
	</ul>

	<ul style="font-size: 20px">*图书管理
	</ul>
	<ul>
		<a href="${pageContext.request.contextPath }/manager/addBook"
			target="right">添加图书</a>
	</ul>
	<ul>
		<a href="${pageContext.request.contextPath }/manager/listBook"
			target="right">查看图书</a>
	</ul>

	<ul style="font-size: 20px">*订单管理
	</ul>

	<ul>
		<a
			href="${pageContext.request.contextPath }/manager/orderStatus?status=true"
			target="right">已发货订单 </a>
	</ul>
	<ul>
		<a
			href="${pageContext.request.contextPath }/manager/orderStatus?status=false"
			target="right">未发货订单</a>
	</ul>
	
		<ul style="font-size: 20px">*备份恢复数据库
	</ul>
	
	<ul>
	<a href="${pageContext.request.contextPath }/manager/dbBackUp"
			target="right">	备份数据库 	</a>
	</ul>
	<ul>
	<a href="${pageContext.request.contextPath }/manager/dbRestore"
			target="right">	恢复数据库	</a>
	</ul>


</body>
</html>
