<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改闲置物品信息</title>
	</head>
	<body>
		<h2 style="text-align:center">修改闲置物品信息表单</h2>
		<form action="${pageContext.request.contextPath }/servlet/IdleServ?method=updateidle" method="post">
				<!-- 闲置物品id号:获取当前闲置物品id号，这里如果固定不可修改就会报错 -->
				<input type="text" id="idleid" name="idleid" value="<%=request.getParameter("idleid") %>" style="display:none"/>
			
				<!-- 闲置物品拥有者id:根据参数获取 -->
				<input type="text" id="memid" name="memid" value="<%=request.getParameter("memid") %>" style="display:none"/><br>
			
				闲置物品名称:
				<input type="text" id="idlename" name="idlename"/><br>
			
				闲置物品详情描述:
				<input type="text" id="idledetail" name="idledetail"/><br>
			
				闲置物品图片URL:
				<input type="text" id="idlepicurl" name="idlepicurl"/><br>
			
				闲置物品类型:
				<!-- <input type="text" id="idletype" name="idletype"/><br> -->
				<select name="idletype">
					<option value="forfree">免费提供</option>
					<option value="forsale">待售物品</option>
				</select>
				
			<input id="submit" type="submit" value="提交"">
		</form>
	</body>
</html>