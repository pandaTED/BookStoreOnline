<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'orderdetail.jsp' starting page</title>
  </head>
  
  <body style="max-width: 1260px;min-width: 780px;margin: 10px auto;font-family:Microsoft YaHei;">
  	<%@include file="/client/head.jsp"%>
    <table border="1" style="text-align: right;" width="100%">
   		<h3>订单明细</h3>
   		<tr>
   			<td>书名</td>
   			<td>售价</td>
   			<td>数量</td>
   			<td>应收货款</td>
   		</tr>
   		
   		<c:forEach var="orderitem" items="${orderDetail.orderitems}">
   			<tr>
	   			<td>${orderitem.book.name }</td>
	   			<td>${orderitem.book.price }</td>
	   			<td>${orderitem.quantity }</td>
	   			<td>${orderitem.price }元</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">总计应收货款</td>
   			<td colspan="2">${orderDetail.price }元</td>
   		</tr>
   	</table>
   	<br/><br/>
   	<table border="1" style="text-align: right;" width="100%">
  		<h3>收货人详细地址</h3>
  		<tr>
  			<td>用户</td>
  			<td>电话</td>
  			<td>手机</td>
  			<td>地址</td>
  			<td>邮箱</td>
  		</tr>
  		<tr>
  			<td>${user.username }</td>
  			<td>${user.phone }</td>
  			<td>${user.cellphone }</td>
  			<td>${user.address }</td>
  			<td>${user.email }</td>
  		</tr>
  	</table>
  	<br/>
  </body>
</html>
