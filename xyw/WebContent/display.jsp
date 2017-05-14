<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择用户预约</title>
</head>
<body>
	单击按钮预约
	<table border="1">
	<tr bgcolor="pink">
		<th>用户id</th>
		<th>姓名</th>
		<th>性别</th>
		<th>预约</th>
	</tr>
	<form action="reseradd.jsp" method="post">
	<tr bgcolor="pink">
		<td><input type="text" name="userid"></td>
		<td><input type="text" name="姓名"></td>
		<td><input type="text" name="性别"></td>
		<td><input type="submit" value="预约"></td>
	</tr>
	</table>
	</form>
</body>
</html>