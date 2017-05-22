<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="rj7.bean.Push" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推送详情</title>
</head>
<body>
<% Push p = (Push)request.getAttribute("push");%>
<p>图片</p><image src="<%=p.getUrlpush()%>">
<table style="text-align:center">
<tr><td><p>推送id</p></td><td> <%out.println(p.getPid());%></td></tr>
<tr><td><p>发布管理员id</p></td><td><%out.println(p.getAdmid());%></td></tr>
<tr><td><p>标题</p> </td><td><%out.println(p.getHead());%>v</tr>
<tr><td><p>内容</p></td> <td><% out.println(p.getContent());%></td></tr>
<tr><td><p>状态</p></td> <td><%out.println(p.getStatus());%></td></tr>
<tr><td><p>最新更改时间</p></td> <td><% out.println(p.getTime());%></td></tr>
<tr><td><p>类型</p> </td><td><% out.println(p.getType());%></td></tr>
<tr><td><p>浏览量</p></td><td><%out.println(p.getBrowsecnt());%></td></tr>
<tr><td><p>点赞量</p></td><td> <%out.println(p.getLikecnt());%></td></tr>
<tr><td><p>收藏量</p></td><td><%out.println(p.getCltcnt());%></td></tr>
<tr><td><p>分享量</p></td><td> <%out.println(p.getShrecnt());%></td></tr>
<tr><td><p>转发量</p> </td><td><% out.println(p.getTsmtcnt());%></td></tr>
<tr><td><p>评论量</p></td> <td><% out.println(p.getCmtcnt());%></td></tr>
</table>
<input type="button" name="fanhui" value="返回" onclick="history.back();">
</body>
</html>