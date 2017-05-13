<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/md5.js"></script>
<script type="text/javascript" src="js/formcheck.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
$(function () {
	var pswd = $('#pswd').val();
	var md5pswd = $.md5(pswd);
	console.log(md5pswd.length);
	$('#pswd').val(md5pswd);
});
</script>

<body>
	<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div style="text-align:center;font-size:20px;">快速登录</div>
    </div>    
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    
            <!--登录-->
            <div class="web_login" id="web_login">
            <div class="login-box">
				<div class="login_form">
					<form action="LogRegServ" accept-charset="utf-8" class="loginForm" method="post">
						<input type="hidden" name="did" value="0"/>
	                	<div class="uinArea" id="uinArea">
	                		<label class="input-tips" for="u">帐号：</label>
	                		<div class="inputOuter" id="uArea">
	                    		<input type="text" id="username" name="username" class="inputstyle"/>
	               			</div>
	                	</div>
	               		<div class="pwdArea" id="pwdArea">
	               			<label class="input-tips" for="p">密码：</label> 
	               			<div class="inputOuter" id="pArea">
	                    		<input type="password" id="pswd" name="pswd" class="inputstyle"/>
	                		</div>
	                	</div>
	                	<div style="padding-left:50px;margin-top:20px;">
	                		<input type="submit" value="登 录" style="width:150px;" class="button_blue"/>
	                		<a href="regist.jsp" class="zcxy" target="_blank">注册</a>
	                	</div>
	                	<input type="hidden" name="dowhat" value="log">
	              	</form>
	           </div>
           </div>
           </div>
           <!--登录end-->
  </div>
</div>
</body>
</html>