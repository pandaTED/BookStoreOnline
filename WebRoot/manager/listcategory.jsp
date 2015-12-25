<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看分类</title>
</head>
<body style="max-width: 1260px;min-width: 780px;margin: 10px auto;">
	<br /><br />
	<table border="1" frame="border" cellpadding="0" cellspacing="0" width="90%" >
		<caption><h2>图书分类信息管理</h2></caption>
		<tr>
			<td>序号</td>	
			<td>分类名称</td>
			<td>分类描述</td>
			<td>操作</td>
		</tr>
		<c:forEach var="category" items="${requestScope.list }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${category.name }</td>
				<td>${category.description }</td>
				<td><a href="#">修改</a> <a href="#">删除</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>