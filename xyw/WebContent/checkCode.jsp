<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<html>  
  <head>  
    <title>输入校验</title>  
  </head>  
  <body>  
    <%  
    	String email = request.getParameter("txt_logemail");
        String checkcode=request.getParameter("checkCode");
        session.setAttribute("txt_logemail", email);
        System.out.println(email);
        if(email==null||"".equals(email)||email.trim().isEmpty()){  
            out.print("<script language=javascript>alert('请输入邮箱');window.location.href='findpswd1.jsp';</script>");  
        }
        else if(checkcode==null){  
            out.print("<script>alert('请输入验证码');history.back(-1);</script>");  
        }else{  
            if(!checkcode.equalsIgnoreCase((String)session.getAttribute("randCheckCode"))){  
                out.print("<script>alert('验证码不正确,请重新输入');history.back(-1);</script>");  
            }else{
            	 out.print("<script language=javascript>window.location.href='findpswd2.jsp'</script>");  
           }  
        }  
     %>  
  </body>  
</html>  