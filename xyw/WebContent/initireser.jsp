<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我发起的所有预约</title>
</head>
<body>
	<h2 style="text-align:center">我发起的所有预约</h2>
	<a href="reseradd.jsp">
<img alt="添加" src="images/push_add.jpg" style="border:0; cursor:hand;
width:20px;height:20px;"/></a>
</br></br>
${reback}
<input type="text" name="search" style="width:150px;height:20px;">
<a href="ReserServ?method=resersearch">
<img alt="查找" src="images/resersearch.jpg" style="border:0; cursor:hand;
width:20px;height:20px;"/></a>
  						
   <table width="100%" border="1" cellspacing="0" cellpadding="0">
     <tr bgcolor="pink">
       <td scope="col" width="10%"> 预约id </td>
       <td scope="col" width="10%"> 预约用户id </td>
       <td scope="col" width="10%"> 被预约用户</td>
       <td scope="col" width="10%"> 预约开始时间 </td>
       <td scope="col" width="10%"> 预约生成时间 </td>
       <td scope="col" width="10%"> 预约城市 </td>
       <td scope="col" width="10%"> 删除</td>
       <td scope="col" width="10%"> 取消预约</td>
     </tr>
     
     <tr>  
     <td><%=1 %></td>
     <td><a href="userdetail.jsp&id=<%= 123%>"><%=123 %></a></td>
     <td><a href="userdetail.jsp&id=<%= 456%>"><%=456 %></a></td>
     <td><%= 123%></td>
     <td><%= 123%></td>
     <td><%= 123%></td>

     <td>
     <a href="ReserServ?method=reserdelete">
	 <img alt="删除" src="images/push_delete.png" style="border:0; cursor:hand;
	 width:25px;height:25px;"/></a>
     </td>
      <td> <input type="submit" value="取消预约" scope="col" width="10%"></td>
     </tr>
   </table> 

</body>
</html>