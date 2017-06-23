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


<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link href="css/realcheck.css" rel="stylesheet" type="text/css" />

</head>
<body>
      <div >
			<form action="realcheck.jsp" method="post">
				<label>类型：</label>
				<select name="keyword">
					<option value="1">通过审核</option>
					<option value="0">没有通过审核</option>
				</select>
				<button type="submit" class="btn">确定</button>
			</form>
			<%
		    String keyword;		  //查询关键字
		    keyword = request.getParameter("keyword");
		    if (keyword != null){
		    	session.setAttribute("tabkey", keyword);
		    }
		    int pages;            //待显示页面
		    int count;            //总条数
		    int totalpages;       //总页数
		    int limit = 10;       //每页显示记录数
		    
		    List  li = null;
		    Real tab = null;
		    int rid;
		    keyword = (String)session.getAttribute("tabkey");
            RealDAOProxy realPro=new RealDAOProxy();
		    count =realPro.recordNum(keyword);
		    //由记录总数除以每页记录数得出总页数
		    totalpages = (int)Math.ceil(count/(limit*1.0));
		    //获取跳页时传进来的当前页面参数
		    String strPage = request.getParameter("pages");
		    //判断当前页面参数的合法性并处理非法页号（为空则显示第一页，小于0则显示第一页，大于总页数则显示最后一页）
		    if (strPage == null) { 
		        pages = 1;
		    } else {
		        try{
		            pages = java.lang.Integer.parseInt(strPage);
		        }catch(Exception e){
		            pages = 1;
		        }
		        if (pages < 1){
		            pages = 1;
		        }
		        if (pages > totalpages){
		            pages = totalpages;
		        }                            
		    }
		    
		    li =realPro.findPage(pages - 1, limit, keyword);
		    //由(pages-1)*limit算出当前页面第一条记录，由limit查询limit条记录。则得出当前页面的记录
		    %>
		    <div id="box">
		    <form action="realdetail.jsp" method="post">
		    	<table id="mytable" cellspacing="0" >
		    		<tr >
					    <th width="118" class="head" scope="col" abbr="Configurations">ID</th>
						<th width="168" class="head" scope="col" abbr="Dual 1.8">姓名</th>
						<th width="118" class="head" scope="col">身份证号</th>
						<th width="118" class="head" scope="col">头像</th>
				        <th width="118" class="head" scope="col">学校</th>
						<th width="118" class="head" scope="col">专业</th>
						<th width="118" class="head" scope="col">用户ID</th>
						<th width="118" class="head" scope="col">详情</th>
						
		           </tr>
		    <%
		    for(int i = 0; i< li.size(); i++){
		    	tab = (Real)li.get(i);
		    %>
		    		<tr>
		    			<td class="alt"><%= tab.getRid() %></td>
		    			<td><%=tab.getName() %></td>
					   <td class="alt"><%=tab.getIdcard() %></td>
					   <td><%= tab.getIconurl() %></td>
					   <td class="alt"><%= tab.getSchool() %></td>
					   <td><%=tab.getMajor() %></td>
					   <td class="alt"><%=tab.getUserid() %></td>
					   <td><a href="realdetail.jsp?rid=<%=tab.getRid()%>">详情</a>></td>
		    		</tr>
		    <%
		    }
		    %>
		    	</table>
		    	
	    	</form>
	    	</div>
	    	<form name="f2" method="POST" action="realcheck.jsp">
	            <table border="0" align="center" style="margin-top: 10px;">
	                <tr>
	                    <td>第<%=pages%>页&nbsp;&nbsp;共<%=totalpages%>页 <a href="realcheck.jsp?pages=1">&nbsp;&nbsp;首页</a></td>
	                    <td><a href="realcheck.jsp?pages=<%=(pages<=1)?pages:(pages-1) %>">&nbsp;&nbsp;上一页</a></td>
	                    <td><a href="realcheck.jsp?pages=<%=(pages>=totalpages)?totalpages:(pages+1)%>">&nbsp;&nbsp;下一页</a></td>
	                    <td><a href="realcheck.jsp?pages=<%=totalpages%>">&nbsp;&nbsp;最后一页</a></td>
	                    <td>&nbsp;&nbsp;转到第:<input type="text" name="pages" size="8">页<input type="submit" value="GO" class="btn"></td>
	                </tr>
	            </table> 
	 		</form>
		</div>
</body>
</html>