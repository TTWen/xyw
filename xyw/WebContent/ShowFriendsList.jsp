<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*, rj7.bean.*, rj7.dao.attention.*,javax.servlet.*,rj7.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <% 
        ArrayList<Member> user = null;
	    user = (ArrayList)request.getAttribute("user");
	    String userid = null;
	    ArrayList<Object> attenmem= new ArrayList<Object>();
	   if(session.getAttribute("crtuid") != null)
	   {
		  userid = session.getAttribute("crtuid").toString();
	      System.out.println(userid);
	      
	      IAttentionDAO dao = DAOFactory.getIAttentionDAOInstance();
	      attenmem = dao.hasAtten(userid);
	      System.out.println(attenmem.size());
	   }
	  //  MemberDetail member2 = new MemberDetail();
		//DAO d = new DAO();
		//String tbl = "tblmemberdetail";
		//String idname = "id";
     %>
     <form action="QueryFriendsServlet" method="post" class="form-horizontal" role="form" novalidate="novalidate">
			
					<label class="col-md-2 control-label ">性别</label>
					 
						男 <input name="sex" type="radio" value="1"/>
						女 <input name="sex" type="radio" value="0"/>
				 
					<label class="col-md-2 control-label ">地区</label>
					 
					    <input name='city' type="text" class="form-control"/>
				     
			
					<label class="col-md-3 control-label ">年龄最小</label>
				
						<input name='age1' type="text" class="form-control"/>
				 
	       
					<label class="col-md-3 control-label ">年龄最大</label>
				
						<input name='age2' type="text" class="form-control"/>
				
					<input type="submit" value="查询好友" style="width:150px;" class="button_blue"/>
	    
       <table width="400" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td scope="col" width="25%"> 昵&nbsp;&nbsp;称 </th>
                <td scope="col" width="25%"> 头&nbsp;&nbsp;像 </th>
              </tr>
                <%
                   for(int i=0;i<user.size();i++){
                	   Member member1 = user.get(i);   
                		String id1 = member1.getId();
        				//member2 = (MemberDetail) d.findById(tbl, id1, MemberDetail.class, idname);
               %>            
              <tr>
               
               <td><%= member1.getUsername() %></td>
               <td><img  src="images/2.jpg" style="border:0; cursor:hand;"/></td>
               <td>
               <% 
                if(userid != null && !userid.equals(id1))
                {  
                	 int bool = 1;
                     for(int j=0;j<attenmem.size();j++)
                     {
                  	   String id2 = ((Member)attenmem.get(j)).getId();
                  	   if(id1.equals(id2))
                  	   {
                   %>
                   
                  		   <a href="AttenFriendsServlet?attenid=<%=member1.getId() %>&dowhat=UnAttention">取消关注</a>
                    <%     
                          bool=0;
                          break;
                  	   }
                     }
                 
                     if(bool == 1)
                     {
                    %>
                  <a href="AttenFriendsServlet?attenid=<%=member1.getId() %>&dowhat=Attention">关注</a>
                   <% 
                }
                }
                   %>
                
                
             </td>
               
              </tr>
               <%
                }
               %>               
        </table>            
        
</body>
</html>