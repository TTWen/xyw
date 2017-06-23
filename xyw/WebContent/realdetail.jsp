<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="rj7.dao.real.RealDAOProxy" %>
<%@ page import="java.util.List" %>
<%@ page import="rj7.bean.Real" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>认证详情页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/realdetail.css">
	

  </head>
  <%
  request.setCharacterEncoding("utf-8");
   %>
  <body>
  <%    
        String rid=request.getParameter("rid");
		Real real = new Real();
		String check="1";
		String idname="rid";
        RealDAOProxy realPro=new RealDAOProxy();
        real=realPro.findById(rid, "tblreal", idname);
		
	 %>
	 
	 
	
		
			<h1 align="center" style="font-family:隶书;color:lightcoral;font-size:40px;">用户：<%=real.getUserid() %></h1>
			<div class="myinfo" >
			<hr style="width: 400px; height:3px;border:none;border-top:3px double cadetblue;"/>
			<hr style="width: 800px; height:3px;border:none;border-top:3px double lightseagreen;"/>		
			<table width="1100" align="center"  cellspacing="10" class="context">
				<tbody>
					<tr>
						<td rowspan="6" width="500px">
							<img class="img" src="images/weixiao.jpg" alt="无法加载图片资源">
						</td>
						<td>姓名 | <%=real.getName() %></td>
						<td>ID  | <%=real.getIdcard() %></td>
					
					</tr>
					<tr>
						<td>学校 | <%=real.getSchool() %></td>
						<td>专业 | <%=real.getMajor() %></td>
					</tr>
					<tr>
						<td>地址 | <%=real.getAdress() %></td>
						
						<td>邮编 | <%=real.getPost() %></td>
					</tr>
					<tr>
						<td>编号 | <%=real.getRid() %></td>
						<%if("0".equals(real.getRis()))
		         			{
			      			out.println("<td>认证 | 未审核</td>");
		         			}else if("1".equals(real.getRis()))
		         			{
			      			out.println("<td>认证 | 通过</td>");
		         			}
		         		%>
					</tr>
					<tr>
	            <td>
	            <a href="javascript:if(confirm('确实要通过吗?'))location='RealCekServ?rid=<%=real.getRid() %>&check=<%=check %>'" class="submit-msg">通过</a>
	            </td>
	            <td>
	            <a href="javascript:if(confirm('确实要删除吗?'))location='RealCekServ?rid=<%=real.getRid() %>&check=<%="0" %>'" class="submit-msg">不通过</a>
	            </td>
	         </tr>
				</tbody>
			</table>
	
             </div>
	 

  </body>
</html>
