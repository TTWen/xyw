<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<link href="css/findpswd2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<script type="text/javascript">
    function changePsw(){
    	if(document.all.pswd1.value!=document.all.pswd2.value){
    		alert("两次输入的密码不一致！");
    		return;
    		}
        }
</script>
<form action="FindPswdServ" name="changepswd" id="changepswd" method="post">
<h1>邮箱重置密码</h1>
<h2>尊敬的用户，你好！</h2>
<p class="cz_pass">你正在通过邮箱重置密码.<br/>
请输入新密码并重复确认，完成密码重置操作</p>
<div class="pass_p"><label>新密码</label>
<input type="password" name="pswd1">
</div>
<div class="pass_p_align"><label>确认密码</label>
<input type="password" name="pswd2">
</div>
<br><br>
<input type="submit" class="cz_btn" onClick="changePsw();" value="确认" />
</form>
</body>
</html>