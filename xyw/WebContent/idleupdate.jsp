<%@ page language="java" contentType="text/html; charset=UTF-8" 
	import="java.util.*" 
	import="rj7.bean.Idle"
	import="rj7.bean.IdleFile" 
	import="rj7.dao.idle.IdleDAOProxy"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>修改闲置物品信息</title>
		<link rel="stylesheet" media="screen" href="styles.css" >
		<link rel="stylesheet" type="text/css" href="css/updateidle.css">
	</head>
	<body> 
		<form class="updateidle_form" action="IdleServ?method=updateidle&method1=addfile" method="post" name="updateidle_form">
			<ul>
				<%
					Idle idle = (Idle)request.getSession().getAttribute("idle");
					List<IdleFile> flist = (List)request.getSession().getAttribute("flist");
				%>
				<li>
					<h2>修改闲置物品信息(要回显修改前的值)</h2>
					<span class="required_notification">* 表示必填项</span>
				</li>
				<input type="text" id="idleid" name="idleid" value="<%=request.getParameter("idleid") %>" style="display:none"/>
				<input type="text" id="memid" name="memid" value="<%=request.getParameter("memid") %>" style="display:none"/><br>
				<li>
					<label for="idlename">闲置物品名称:</label>
					<input type="text" id="idlename" name="idlename" value ="<%=idle.getIdlename() %>" required/>*
				</li>
				<li>
					<label for="idledetail">闲置物品详情描述:</label>
					<input type="text" id="idledetail" name="idledetail" value = "<%=idle.getIdledetail() %>" required/>*
				</li>
				<li>
					<label for="message">闲置物品类型:</label>
					<select name="idletype">
							<option value="forfree" <%="forfree".equals(idle.getIdletype())?"selected":"" %>  >免费提供</option>
							<option value="forsale" <%="forsale".equals(idle.getIdletype())?"selected":""%> >待售物品</option>
					</select>*
				</li>
				<li>
					<table>
							<label for="idledetail">闲置物品图片已上传:</label>
							<c:if test="${empty flist}">无图片</c:if>
							<c:forEach var="singlefile" items="${flist }">
								<img alt="" src="${pageContext.request.contextPath}/idlefupload/${singlefile.fdir1}/${singlefile.fdir2}/${singlefile.idlefuuidname }">
							</c:forEach>
							<br>
				  			<input type="button" name = "wenjian" value="添加上传文件" onclick="addfile()">
				  		<tr>
				  			<td></td>
				  			<td>
				  				<div id="files"></div>
				  			</td>
				  		</tr>
	  				</table>
				</li>
				<li>
					<button class="submit" type="submit">提交</button>
				</li>
			</ul>
		</form>
	</body>
	<script type="text/javascript">
		  	function addfile()
		  	{
		  		var files = document.getElementById("files");
		  		var input = document.createElement("input");
		  		input.type = 'file';
		  		input.name = 'idlepicurl';
		  		input.id = 'idlepicurl'
		  		
		  		var btn = document.createElement("input");
		  		btn.type = 'button';
		  		btn.value = '删除';
		  		btn.onclick = function del(){
		  			this.parentNode.parentNode.removeChild(this.parentNode);
		  		}
		  		
		  		var div = document.createElement("div");
		  		div.appendChild(input);
		  		div.appendChild(btn);
		  		
		  		files.appendChild(div);
		  	}
  		</script>
</html>