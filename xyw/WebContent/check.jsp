<%@ page language="java" contentType="textml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
<title>核验2</title>
</head>
<body>
<%
String email = (String)session.getAttribute("txt_logemail");
System.out.println(email);
if(email==null||"".equals(email)||email.trim().isEmpty()){  
    out.print("<script language=javascript>alert('请输入邮箱');window.location.href='findpswd1.jsp';</script>");  
}
else
	out.print("<script language=javascript>window.location.href='login.jsp';</script>");  
%>
</body>
</html>
