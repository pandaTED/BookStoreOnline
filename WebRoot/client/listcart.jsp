<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body style="max-width: 1260px;min-width: 780px;margin: 10px auto;">
	<%@include file="/client/head.jsp"%>
	<table width="100%" border="1">
		<tr>
			<td>序号</td>
			<td>书名</td>
			<td>售价</td>
			<td>数量</td>
			<td>小计</td>
		</tr>
			<c:forEach var= "entry" items="${cart.map }" varStatus="status">
			<tr style="text-align: right;">
			<td>${status.count }</td>
			<td>${entry.value.book.name}</td>
			<td>${entry.value.book.price}元</td>
			<td>${entry.value.quantity}本</td>
			<td>${entry.value.price}元</td>
			</tr>
			</c:forEach>
		
			<tr>
			<td style="text-align: right;" colspan="5">总价:${cart.price}元</td>
		</tr>
	</table>
	<div align="right"><a href="${pageContext.request.contextPath }/client/addOrder" > 提交订单 </a></div>
</body>
</html>