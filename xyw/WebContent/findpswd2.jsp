<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="rj7.mail.Mail"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/findpswd.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">   
 function a()    
{    
 alert("邮件发送成功，请注意查收！");   
 }    
 </script>    
<body>
<%String email = (String)session.getAttribute("txt_logemail");%>
<div class="box01 box01_c pwd_box ">
        <div class="box_hd hd02"><h1>重置登录密码</h1></div>
        <div class="box_bd">
            <div class="pwd_setp2 clearfix">
				<div class="mt10 newsafe_ways phoneway">
		            <button class="btn_l3_disable" type="button" id="btn_mobile">
		            <span><em>手机验证重置</em></span></button>
		            <span>您可以通过有效的绑定手机重置登录密码。</span><b></b>
		        </div>
		        <div class="mt10 newsafe_ways mailway">
		            <button class="btn_l3_disable" type="button" id="btn_email"
		            onClick="window.location.href='MailServ?method=post'">
		            <span><em>邮箱验证重置</em></span></button>
		            <span>您可以通过有效的绑定邮箱重置登录密码。</span><b></b>
		        </div>
		        <div class="mt10 newsafe_ways telway">
		            <span>如果您的登录名未绑定手机和邮箱，将无法通过以上方式找回。您可以致电客服进行人工服务。
		            <br />手机 13526862613 </span><b></b>
		        </div>
		    </div>
        </div>
    </div>
</body>
</html>