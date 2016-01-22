<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<%@include file="/client/head.jsp"%>
<body style="max-width: 1260px;min-width: 780px;margin: 10px auto;font-family:Microsoft YaHei;" >
	<form
		action="${pageContext.request.contextPath }/client/register" method="post">
		<table align="center">
			<tr>
				<td>用户名</td>
				<td><input type="text" name= "username" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name= "password" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name= "phone" /></td>
			</tr>
			<tr>
				<td>手机</td>
				<td><input type="text" name= "cellphone" /></td>
			</tr>
			<tr>
				<td>电子邮箱</td>
				<td><input type="text" name= "email" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name= "address" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="注册" /></td>
			</tr>
		</table>
	</form>
</body>
</html>