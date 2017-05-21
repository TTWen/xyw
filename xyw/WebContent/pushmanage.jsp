<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="rj7.bean.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推送一览</title>
</head>
<body> 
<script>  
    function deselectedAll() {  
        var allsel = document.getElementsByName("cbox");/cbox为复选框的name属性值 */  
        for ( var i = 0; i < allsel.length; i++) {  
            allsel[i].checked = !allsel[i].checked;  
        }  
    }  
</script>
<script>  
    function selectedAll() {  
        var allsel = document.getElementsByName("cbox");/cbox为复选框的name属性值 */  
        for ( var i = 0; i < allsel.length; i++) {  
            allsel[i].checked = true;  
        }  
    }  
</script>

<% 	
	List<Object> list = null;
	list = (ArrayList)request.getAttribute("pageMember");
%>

<p style="align:center;"> [推送列表]</p>
<a href="push_add.jsp">
<img alt="添加" src="images/push_add.jpg" style="border:0; cursor:hand;
width:20px;height:20px;"/></a>
</br></br>

</br>
<input type="text" name="search" style="width:150px;height:20px;">
<a href="PushServ?flag=push_search">
<img alt="搜索" src="images/push_search.jpg" style="border:0; cursor:hand;
width:20px;height:20px;"/></a></br></br>

<form action="PushDeleteServ" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>全选
    <input type="checkbox" name="sel" onclick="selectedAll()">
    <tr>反选
    <input type="checkbox" name="sel" onclick="deselectedAll()">
    <input type="submit" name="批量删除" value="删除" 
    onclick="{if(confirm('确定删除?'))
    {this.document.formname.submit();return true;}return false;}">
    </tr>
    <tr>
      <td scope="col" width="10%">选择</td>
      <td scope="col" width="10%"> id </td>
      <td scope="col" width="10%"> 标题</td>
      <td scope="col" width="10%"> 类型 </td>
      <td scope="col" width="10%"> 状态 </td>
      <td scope="col" width="10%"> 发布者 </td>
      <td scope="col" width="10%"> 最新时间</td>
      <td scope="col" width="10%"> 修改</td>
    </tr>

    <%for(int i = 0; i<list.size();i++){
    	Push p = (Push)list.get(i);%>
    <tr>
    <td><input type="checkbox" name="cbox" value="<%=p.getPid()%>"></td>  
    <td><a href="PushDetailServ?pid=<%=p.getPid()%>"><%=p.getPid()%></a></td>
    <td><%= p.getHead()%></td>
    <td><%= p.getType()%></td>
    <td><%= p.getStatus()%></td>
    <td><%= p.getAdmid()%></td>
    <td><%= p.getTime()%></td>
    <td><a href="PushUpdateServ?pid=<%=p.getPid()%>">
    <img alt="修改" src="images/push_modify.jpg" style="border:0; cursor:hand;
    width:25px;height:25px;"/></a></td>
    </tr>
    <%} %>
  </table> 
</form>  

<%int curpagenum =(int)request.getAttribute("curpagenum");
  int tail =(int)request.getAttribute("pagecount");
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
<a href="PushShowServ?pageindex=0">首页</a>
<a href="PushShowServ?pageindex=<%=pre%>">上一页</a>
<a href="PushShowServ?pageindex=<%=next%>">下一页</a>															
<a href="PushShowServ?pageindex=<%=tail%>">尾页</a>

</body>
</html>