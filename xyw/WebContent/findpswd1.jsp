<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/findpswd.css" rel="stylesheet" type="text/css" />
<script language="javascript">  
function myReload() {  
    document.getElementById("CreateCheckCode").src = document  
            .getElementById("CreateCheckCode").src  
            + "?nocache=" + new Date().getTime();  
}
</script>
</head>
<body>
<form action="checkCode.jsp" method="post">
	<div class="box01 box01_c pwd_box ">
	<div class="box_hd hd02"><h1>重置登录密码</h1></div>
        <ul class="box_bd account_form pwd_form">
            <li>
                <label class="tit">请输入注册的邮箱</label>
                <input type="text" class="m_input w01" name="txt_logemail" id="txt_logemail" />
            </li>
            <li id="divVerifyCode">
            <label class="tit">请输入验证码</label>  
            <input name="checkCode" type="text" class="m_input w02" id="checkCode" title="验证码区分大小写"  
                size="8" maxlength="4" />  
            <img src="PictureCheckCode" id="CreateCheckCode" align="middle">  
            <span><a href="#" onclick="myReload()"> 看不清,换一个</a></span> 
            </li>
            <li>
                <label class="tit">&nbsp;</label>
                <button type="button" id="btn_submit" class="btn_l3" onclick="this.form.submit()">
                <span><em>提交</em></span></button>
            </li>
        </ul>
    </div>
    </form>
</body>
</html>