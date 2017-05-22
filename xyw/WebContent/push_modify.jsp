<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="rj7.bean.Push" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新推送</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	Push p =(Push)request.getAttribute("push");
%>
${reback}
<form action="PushModifyServ" method="post" style="text-align:center" enctype ="multipart/form-data">
<tr>标题<input type="text"  id="head" name="head" value="<%=p.getHead()%>"  style="width:100px;height:20px;"></tr><br><br>          
<tr>正文<textarea rows="3" cols="30" id="content"  name="content"><%out.println(p.getContent());%></textarea></tr><br><br>		
<tr>图片<image src="<%=p.getUrlpush()%>"></tr></br></br>
<tr><input type="hidden" name="urlpush"  value="<%=p.getUrlpush()%>"></tr>
<tr><input type="file" name="picture" ></tr></br></br>
<select name="select">类型
<option  value="文章">文章</option>
<option  value="公告">公告</option>
<option  value="新闻">新闻</option>
</select>
</tr><br><br>
<tr><input type="submit" name="修改" value="修改"></tr>
</form>
</body>>
</html>