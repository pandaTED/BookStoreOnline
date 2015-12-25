<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="max-width: 1260px;min-width: 780px;margin: 10px auto;" >

	<table width="100%" border="1" style="text-align: right;">
		<tr>
			<td>序号</td>
			<td>订单人</td>
			<td>下单时间</td>
			<td>订单状态</td>
			<td>订单总价</td>
			<td>操作</td>
		</tr>
		<c:forEach var="order" items="${list }" varStatus ="status">
			<tr>
				<td>${status.count}</td>
				<td>${order.user.username }</td>
				<td>${order.ordertime }</td>
				<td>${order.state == false?'未发货':'已发货' }</td>
				<td>${order.price}</td>
				<td>
					<a href="${pageContext.request.contextPath }/manager/orderDetail?orderid=${order.id}" >查看明细</a>
					<a href="" >修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>