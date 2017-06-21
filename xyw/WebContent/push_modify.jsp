<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="rj7.bean.Push" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/pushadd.css" rel="stylesheet" type="text/css" />
<title>更新推送</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	Push p =(Push)request.getAttribute("push");
%>
<div class="elegant-aero">
<form action="PushModifyServ" method="post" style="text-align:center" >
<input type="hidden" name="pid" value="<%=p.getPid()%>">
<input type="hidden" name="browsecnt" value="<%=p.getBrowsecnt()%>">
<input type="hidden" name="cltcnt" value="<%=p.getCltcnt()%>">
<input type="hidden" name="cmtcnt" value="<%=p.getCmtcnt()%>">
<input type="hidden" name="likecnt" value="<%=p.getLikecnt()%>">
<input type="hidden" name="shrecnt" value="<%=p.getShrecnt()%>">
<input type="hidden" name="tsmtcnt" value="<%=p.getTsmtcnt()%>">
标题<input type="text"  name="head" value="<%=p.getHead()%>"><br><br>          
<textarea  name="content"><%out.println(p.getContent());%></textarea><br><br>		
<select name="type" >类型
<option selected="selected"><%=p.getType()%></option> 
<option  value="文章">文章</option>
<option  value="公告">公告</option>
<option  value="广告">广告</option>
</select>
</tr><br><br>
<tr><input type="submit" name="修改" value="修改"></tr>
</form>
</div>
</body>
</html>