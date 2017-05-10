<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推送列表</title>
</head>
<body>
<p style="align:center;"> [推送列表]</p>
<a href="">首页</a>
<a href="">上一页</a>
<a href="">下一页</a>															
<a href="">尾页</a>
</br></br>

<a href="push_add.jsp">
<img alt="添加" src="images/push_add.jpg" style="border:0; cursor:hand;
width:20px;height:20px;"/></a>
</br></br>
${reback}
<input type="text" name="search" style="width:150px;height:20px;">
<a href="PushServ?flag=push_search">
<img alt="搜索" src="images/push_search.jpg" style="border:0; cursor:hand;
width:20px;height:20px;"/></a>
  						
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td scope="col" width="10%"> id </td>
       <td scope="col" width="10%"> 标题</td>
       <td scope="col" width="10%"> 类型 </td>
       <td scope="col" width="10%"> 状态 </td>
       <td scope="col" width="10%"> 发布者 </td>
       <td scope="col" width="10%"> 发布时间</td>
       <td scope="col" width="10%"> 修改</td>
       <td scope="col" width="10%"> 删除</td>
     </tr>
     
     <tr>  
     <td><a href="push_detail.jsp&id=<%= 123%>"><%=123 %></a></td>
     <td><%=123 %></td>
     <td><%= 123%></td>
     <td><%= 123%></td>
     <td><%=123 %></td>
     <td><%= 123%></td>
     <td>
     <a href="push_modify.jsp">
	 <img alt="修改" src="images/push_modify.jpg" style="border:0; cursor:hand;
	 width:25px;height:25px;"/></a>
     </td>
     <td>
     <a href="PushServ?flag=push_delete">
	 <img alt="删除" src="images/push_delete.png" style="border:0; cursor:hand;
	 width:25px;height:25px;"/></a>
     </td>
     </tr>
   </table> 
</body>
</html>