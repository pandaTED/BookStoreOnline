<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台书籍列表</title>
  </head>
	<body style="max-width: 1260px;min-width: 780px;margin: 10px auto;font-family:Microsoft YaHei;">
   	<br/><br/>
   	
   	<table border="1" frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>图书信息</h2></caption>
   		<tr>
   			<td>序号</td>
   			<td>书名</td>
   			<td>作者</td>
   			<td>描述</td>
   			<td>图片</td>
 			<td>操作</td>
   		</tr>
   		
   		<c:forEach var="book" items="${books}" varStatus="status">
   			<tr>
   				<td>${status.count}</td>
   				<td>${book.name }</td>
   				<td>${book.author }</td>
   				<td>${book.description }</td>
   				<td><a href="${pageContext.request.contextPath }/images/${book.image }">查看图片</a></td>
	   			<td>
	   				<a href="#">修改</a>
	   				<a href="${pageContext.request.contextPath }/manager/deleteBook?id=${book.id}">删除</a>
	   				<br>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	<br/><br/>
 
    
  </body>
</html>

