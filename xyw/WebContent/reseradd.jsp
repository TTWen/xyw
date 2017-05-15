<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="rj7.bean.Reserve" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>填写预约信息</title>
</head>
<body>
	<h2 style="text-align:center">添加预约信息</h2>
		<form action="ReserServ?method=reseradd" method="post">
			
				预约id:
				<input type="text" id="reserid" name="reserid"/><br>
				被预约用户id:
				<input id="userid" name="reuserid" value="<%=request.getParameter("userid") %>" /><br>
				
				预约用户id:
				<input type="text" id="reduserid" name="reduserid"/><br>
			
				预约起始时间:
				<input type="text" id="rebegtime" name="rebegtime"/><br>
	
				预约城市:
				<input type="text" id="resercity" name="resercity"/><br>
			
				<input id="submit" type="submit" value="提交">
		</form>
</body>
</html>