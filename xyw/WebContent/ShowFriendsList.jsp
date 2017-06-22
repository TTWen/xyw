<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*, rj7.bean.*, rj7.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <% 
        ArrayList<Member> user=null;
	    user = (ArrayList)request.getAttribute("user");
	    MemberDetail member2 = new MemberDetail();
		DAO d = new DAO();
		String tbl = "tbluserdetail";
		String idname = "id";
     %>
       <table width="400" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td scope="col" width="25%"> 昵&nbsp;&nbsp;称 </th>
                <td scope="col" width="25%"> 头&nbsp;&nbsp;像 </th>
              </tr>
                <%
                   for(int i=0;i<user.size();i++){
                	   Member member1 = user.get(i);   
                		String id1 = member1.getId();
        				member2 = (MemberDetail) d.findById(tbl, id1, MemberDetail.class, idname);
               %>            
              <tr>
               
               <td><%= member1.getUsername() %></td>
               <td><img  src="images/2.jpg" style="border:0; cursor:hand;"/></td>
               <td><a href="AttenFriendsServlet?attenid=<%=member1.getId() %>&doWhat=atten">关注</a></td>
              </tr>
               <%
                }
               %>               
        </table>            
        
</body>
</html>