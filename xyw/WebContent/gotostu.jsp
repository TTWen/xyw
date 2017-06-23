<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>认证成功</title>
</head>
<body>
	<div>
		<div
			style="margin: 100px auto; width: 400px; height: 200px; background-color: lightblue;">
			<h2 align="center" style="font-family: '微软雅黑';">
				<%=request.getParameter("name") %>，实名认证成功!
			</h2>
			<a href='realstu.jsp'>下一步，学生认证</a>
		</div>
	</div>
</body>
</html>