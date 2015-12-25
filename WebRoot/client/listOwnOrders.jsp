<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="max-width: 1260px;min-width: 780px;margin: 10px auto;">
	<%@include file="/client/head.jsp"%>
	<table width="100%" border="1" style="text-align: right;">
		<tr>
			<td>序号</td>
			<td>下单时间</td>
			<td>发货状态</td>
			<td>订单总价</td>
			<td>操作</td>
		<tr>
	<c:forEach var="order" items="${listOwnOrder }" varStatus="status">
			<tr>
			<td>${status.count}</td>
			<td>${order.ordertime }</td>
			<td>${order.state==false?'未发货':'已发货' }</td>
			<td>${order.price }</td>
			<td>
			<a href="${pageContext.request.contextPath }/client/listOwnOrders?id=${order.id}">查看订单详情</a>
			</td>
			</tr>
	</c:forEach>
	</table>
</body>
</html>