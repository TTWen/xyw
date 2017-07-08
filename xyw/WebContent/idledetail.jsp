<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="rj7.bean.Idle" 
    import="rj7.bean.IdleFile" 
    import="java.util.ArrayList"
	import="java.util.List"
	import="rj7.dao.idle.IdleDAOProxy"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>闲置物品详细信息页面</title>

		<link rel="stylesheet" media="screen" href="styles.css" >
		<link rel="stylesheet" type="text/css" href="css/idledetail.css">
		<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="js/validator.js"></script>
		<script type="text/javascript" src="js/formcheck.js"></script>
		<script type="text/javascript" src="js/regist.js"></script>
		<script type="text/javascript" src="images/login.js"></script>
	</head>
	<body>
		<form class="idledetail_form" >
			<ul>
				<li>
					<h2>详细信息页面</h2>
					<span class="required_notification">* 表示必填项</span>
				</li>
				<%
					Idle idle = (Idle)request.getAttribute("idle");
					List<IdleFile> flist = (List)request.getAttribute("flist");
					
					String idletype = idle.getIdletype();		
					String type = null;
					if("forsale".equals(idletype))
					{
						type = "待售物品";
					}else if("forfree".equals(idletype))
					{
						type = "免费提供";
					}
					request.getSession().setAttribute("idle", idle);
					request.getSession().setAttribute("flist", flist);
				%>
				<a href="javascript:void(0)" onclick="updateitem(<%=idle.getIdleid() %>,<%=idle.getMemid() %>)">修改</a>
				<input type="text" id="idleid" name="idleid" value="<%=request.getParameter("idleid") %>" style="display:none"/>
				<input type="text" id="memid" name="memid" value="<%=request.getParameter("memid") %>" style="display:none"/><br>
				<li>
					<label for="idlename">闲置物品名称:</label>
					<%=idle.getIdlename() %>
				</li>
				<li>
					<label for="idledetail">闲置物品详情描述:</label>
					<textarea rows="10" cols="40">
						<%=idle.getIdledetail() %>
					</textarea>
					
				</li>
				<li>
					<label for="message">闲置物品类型:</label>
					<%=type %>
				</li>
				<li>
					<label for="idledetail">闲置物品图片:</label>
					<c:if test="${empty flist}">无图片</c:if>
					<c:forEach var="singlefile" items="${flist }">
						<img alt="" src="${pageContext.request.contextPath}/idlefupload/${singlefile.fdir1}/${singlefile.fdir2}/${singlefile.idlefuuidname }">
						<a href="javascript:void(0)" onclick="deleteitem(<%=idle.getIdleid() %>,<%=idle.getMemid() %>,${ singlefile.getIdlefid() })">删除</a>
					</c:forEach>
					<br>
				</li>
				<a style="float:right" href="IdleServ?method=allidle">返回</a>
			</ul>
		</form>
	</body>
	<script type="text/javascript">
		function updateitem(idleid,memid)
		{
			var b = window.confirm("您确认修改该闲置物品吗？？");
			if(b)
			{
				window.location.href="IdleUIServ?idleid="+idleid+"&memid="+memid+"&method=updateidle";
			}
		}
		
		function deleteitem(idleid,memid,idlefid)
		{
			var b = window.confirm("您确认删除本张图片吗？？");
			if(b)
			{
				window.location.href="IdleServ?idleid="+idleid+"&memid="+memid+"&idlefid="+idlefid+"&method=deleteidlef";
			}
		}
	</script>
</html>