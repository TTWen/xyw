<%@ page import="java.io.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="rj7.mail.Mail"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/findpswd.css" rel="stylesheet" type="text/css" />
<title>校游网安全中心</title>
</head>
<body style="text-align:center">
<%
	out.print("<script>alert('邮件发送成功，请注意查收！');window.location.href('login.jsp')</script>");  
%>
</body>
</html>