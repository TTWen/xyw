<%@ page language="java" contentType="text/html; charset=UTF-8" 
	import="java.util.*" 
	import="rj7.bean.Idle" 
	import="rj7.dao.idle.IdleDAOProxy"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>展示全部闲置物品</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<link rel="stylesheet" type="text/css" href="css/showallidle.css">
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="js/validator.js"></script>
		<script type="text/javascript" src="js/formcheck.js"></script>
		<script type="text/javascript" src="js/regist.js"></script>
		<script type="text/javascript" src="images/login.js"></script>
	</head>
	<body>
		<h1>闲置物品展示页</h1>
		<%
			List<Object> list = null;
			list = (ArrayList)request.getAttribute("pageMember");
			if(list==null){}
		%>
		<div>
			<form action="showallidle.jsp" method="post">
				<lable>筛选类型：</lable>
				<select name = "keyword">
					<option value="all">查看全部</option>
					<option value="forfree">免费提供</option>
					<option value="forsale">出售物品</option>
				</select>
				<button type="submit" class="btn">确定</button>
			</form>
			
		<div id="box">
		<form action="IdleServ?memid=8" method="post">
			<table border="1" id="mytable" cellspacing="0">
				<tr>
					<td>闲置物品id号</td>
					<td>闲置物品拥有者id</td>
					<td>闲置物品名称</td>
					<td>闲置物品详情描述</td>
					<td>闲置物品类型</td>
					<td>闲置物品发布时间</td>
					<td>操作</td>
				</tr>
				<c:forEach var="entry" items="${list }"> <!-- list 里放置的是 Idle 集合，每一个idle里面都是闲置物品的各个属性  -->
					<tr>
						<td><a href="IdleServ?memid=${entry.memid }&idleid=${entry.idleid }&method=detailidle">${entry.idleid }</td>
						<td>${entry.memid }</td>
						<td>${entry.idlename }</td>
						<td>${entry.idledetail }</td>
						<td>${entry.idletype }</td>
						<td>${entry.idletime }</td>
						<td>
							<a href="javascript:void(0)" onclick="deleteitem(${entry.idleid })">删除</a>
						</td>
					</tr>
	   			</c:forEach>
			</table>
		</form>
		</div>
		
		<a href="IdleUIServ?memid=3&method=addidle"}>添加闲置物品</a>
		<a href="IdleServ?memid=3&method=findbyuser"}>按用户id显示</a>
		
		<form name="f2" method="post" action="showallidle.jsp">
	            <table border="0" align="center" style="margin-top: 10px;class="easyui-panel"">
	              
	            </table> 
	 		</form>
	</body>
	<script type="text/javascript">
		function deleteitem(idleid)
		{
			var b = window.confirm("您确认删除该闲置物品吗？？");
			if(b)
			{
				window.location.href="IdleServ?idleid="+idleid+"&method=deleteidle";
			}
		}
	</script>
</html>
