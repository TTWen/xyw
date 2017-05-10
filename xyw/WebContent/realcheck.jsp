<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="rj7.dao.real.RealDAOProxy" %>
<%@ page import="java.util.List" %>
<%@ page import="rj7.bean.Real" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核资料</title>
</head>
<body>
<div>
<table>
		<tr bgcolor="yellow">
		    <th>ID</th>
			<th>姓名</th>
			<th>身份证号</th>
			<th>头像</th>
			<th>学校</th>
			<th>专业</th>
			<th>资料</th>
			<th>通过</th>
			<th>不通过</th>
		</tr>
		     <%
		    RealDAOProxy rePro= new RealDAOProxy();
		    String ris="0";
		    String check="1";//通过审核
		    
		    List list0 = rePro.findByris(ris);
		    for(Object t1:list0){
				Real t2 = (Real)t1;
				String rid=t2.getRid();
			%>
		<tr bgcolor="pink">
		    <td><%=rid %></td>
		   <td><%=t2.getName() %></td>
		   <td><%=t2.getIdcard() %></td>
		   <td><%= t2.getIconurl() %></td>
		   <td><%= t2.getSchool() %></td>
		   <td>d<%=t2.getMajor() %></td>
		   <td>d<%=t2.getFilesurl() %></td>
		   <td><a href="RealCekServ?check=<%= check %>&rid=<%= rid %>">通过</a>></td>
		   
		   <td><a href="RealCekServ?check=<%= "0" %>&rid=<%= rid %>">不通过</a></td>
			<%
			}
		    %>
	</tr>
	</table>
</div>
</body>
</html>