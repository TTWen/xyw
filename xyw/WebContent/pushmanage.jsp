<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="rj7.bean.*,java.util.*,rj7.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/pushmanage.css" rel="stylesheet" type="text/css" />
<title>推送一览</title>
</head>
<body> 
<% 	
	List<Object> list = null;
	list = (ArrayList)request.getAttribute("pageMember");
	if(list==null){
		//判断是否跳入servlet，选择性执行
%>
<jsp:forward page="PushShowServ"></jsp:forward>
<%} %>

<script>  
    function deselectedAll() {  
        var allsel = document.getElementsByName("cbox");
        for ( var i = 0; i < allsel.length; i++) {  
            allsel[i].checked = !allsel[i].checked;  
        }  
    }  
</script>
<script>  
    function selectedAll() {  
        var allsel = document.getElementsByName("cbox");
        for ( var i = 0; i < allsel.length; i++) {  
            allsel[i].checked = true;  
        }  
    }  
</script>
<div class="title"> 
<p style="text-align:center;font-size:large;"> [推送列表]</p></div>

<div  style="float:left;margin-left:80px;">
<a href="push_add.jsp">
<img alt="添加" src="images/push_add.jpg" style="border:0; cursor:hand;width:20px;height:20px;"/>
</a>
</div>

<div style="float:right;margin-right:80px;">
<input type="text" name="search" style="width:150px;height:20px;">
<a href="PushServ?flag=push_search">
<img alt="搜索" src="images/push_search.jpg" style="border:0; cursor:hand;width:20px;height:20px;"/>
</a>
</div>

<form action="PushDeleteServ" method="post">
  <table width="90%" id="mytab"  border="1" class="t1">
    <tr class="a1">
    <td>全选<input type="checkbox" name="sel" onclick="selectedAll()"/></td>
    <td>反选<input type="checkbox" name="sel" onclick="deselectedAll()"/></td>
    <td><input type="submit" name="批量删除" value="删除" onclick="{
    if(confirm('确定删除?'))
    {this.document.formname.submit();return true;}return false;}"/></td>
    </tr>
    <th>
      <td scope="col" width="13%"> id </td>
      <td scope="col" width="13%"> 标题</td>
      <td scope="col" width="13%"> 类型 </td>
      <td scope="col" width="13%"> 状态 </td>
      <td scope="col" width="13%"> 发布者 </td>
      <td scope="col" width="13%"> 最新时间</td>
      <td scope="col" width="13%"> 修改</td>
    </th>

    <%for(int i = 0; i<list.size();i++){
    	Push p = (Push)list.get(i);
    %>
    <tr class="a1">
    <td><input type="checkbox" name="cbox" value="<%=p.getPid()%>"></td>  
    <td><a href="PushDetailServ?pid=<%=p.getPid()%>"><%=p.getPid()%></a></td>
    <td><%= p.getHead()%></td>
    <td><%= p.getType()%></td>
    <td><%= p.getStatus()%></td>
    <td><%= p.getAdmid()%></td>
	<td><%= p.getTime()%></td>
    <td><a href="PushUpdateServ?pid=<%=p.getPid()%>">
    <img alt="修改" src="images/push_modify.jpg" style="border:0; cursor:hand;width:25px;height:25px;"/></a></td>
    </tr>
    <%} %>
  </table> 
</form>  

<%int curpagenum =(Integer)request.getAttribute("curpagenum");
  int tail =(Integer)request.getAttribute("pagecount");
  int pre=0;
  int next=0;
  if(curpagenum>0){
	  pre = curpagenum-1;
	  //更改当前页
  }else{
	  pre = 0;
  }
  if(curpagenum<tail){
	 next = curpagenum+1;
  }else{
	  next = tail;
  }
%>

<div style="text-align:center;">
<a href="PushShowServ?pageindex=0">首页</a>
<a href="PushShowServ?pageindex=<%=pre%>">上一页</a>
<a href="PushShowServ?pageindex=<%=next%>">下一页</a>			
<a href="PushShowServ?pageindex=<%=tail%>">尾页</a>
</div>

</body>
</html>