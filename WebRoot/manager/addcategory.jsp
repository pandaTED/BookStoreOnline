<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分类</title>
</head>
<body style="max-width: 1260px;min-width: 780px;margin: 10px auto;">
	<form action="${pageContext.request.contextPath }/manager/categoryServlet" method="post">
		<table width="500px">
			<tr>
				<td>分类名称</td>
				<td><input type="text" style="width: 200px" name="name" ></td>
			</tr>
			
			<tr>
				<td>分类描述</td>
				<td><textarea rows="4" cols="40" name="description" ></textarea></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="添加分类"></td>
			</tr>

		</table>
	</form>
</body>
</html>