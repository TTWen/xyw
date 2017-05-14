<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>展示全部闲置物品</title>
		<style type="text/css">
			body{text-align:center}
			table{margin:0px auto; width:80%; text-align:center}
		</style>
	</head>
	<body>
		<h1>展示全部闲置物品</h1>
		<table border="1">
			<tr>
				<td>闲置物品id号</td>
				<td>闲置物品拥有者id</td>
				<td>闲置物品名称</td>
				<td>闲置物品详情描述</td>
				<td>闲置物品图片URL</td>
				<td>闲置物品类型</td>
				<td>闲置物品发布时间</td>
				<td>操作</td>
			</tr>
			<c:forEach var="entry" items="${list }"> <!-- list 里放置的是 Idle 集合，每一个idle里面都是闲置物品的各个属性 -->
				<tr>
					<td>${entry.idleid }</td>
					<td>${entry.memid }</td>
					<td>${entry.idlename }</td>
					<td>${entry.idledetail }</td>
					<td>${entry.idlepicurl }</td>
					<td>${entry.idletype }</td>
					<td>${entry.idletime }</td>
					<td>
						<a href="javascript:void(0)" onclick="deleteitem(${entry.idleid })">删除</a>/
						<a href="javascript:void(0)" onclick="updateitem(${entry.idleid },${entry.memid })">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath }/servlet/IdleUIServ?memid=8&method=addidle"}>添加闲置物品</a>
		<a href="${pageContext.request.contextPath }/servlet/IdleServ?memid=8&method=findbyuser"}>按用户id显示</a>
	</body>
	<script type="text/javascript">
		function deleteitem(idleid)
		{
			var b = window.confirm("您确认删除该闲置物品吗？？");
			if(b)
			{
				window.location.href="${pageContext.request.contextPath }/servlet/IdleServ?idleid="+idleid+"&method=deleteidle";
			}
		}
		
		function updateitem(idleid,memid)
		{
			var b = window.confirm("您确认修改该闲置物品吗？？");
			if(b)
			{
				window.location.href="${pageContext.request.contextPath }/servlet/IdleUIServ?idleid="+idleid+"&memid="+memid+"&method=updateidle";
			}
		}
	</script>
</html>
