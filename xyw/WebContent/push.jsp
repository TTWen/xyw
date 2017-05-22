<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="rj7.bean.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="60*10" url="PushRefreshServ">
<title>热点推送</title>
</head>
<!-- 进入主页面时直接调用刷新方法，显示推送
             用户可以选择手动刷新
             系统每隔一段时间自动刷新
            限定用户每次刷新只能刷出一百条记录
 -->
<body>
<% 	
	List<Object> list = null;
	list = (ArrayList)request.getAttribute("hotpush");
%>

<form action="PushRefreshServ" method="post" style="text-align:center">
<input type="submit" name="刷新" value="刷新" >
</form>
<%for(int i=0;i<list.size();i++){
	Push p = (Push)list.get(i);
%>
<div  style="width:100px;border:1;text-align:center">
    标题:<%= p.getHead()%></br>
    类型 :<%= p.getType()%></br>
    状态:<%= p.getStatus()%></br>
   发布者:<%= p.getAdmid()%></br>
    时间 :<%= p.getTime()%></br>
    内容:<%=p.getContent()%></br></br></br></br>
</div>
<%} %>
</body>
</html>