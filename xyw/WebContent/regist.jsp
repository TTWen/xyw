<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/md5.js"></script>
<link href="css/easyui.css" rel="stylesheet" type="text/css"/>
<link href="css/icon.css" rel="stylesheet" type="text/css"/>
<link href="css/color.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/validator.js"></script>
<script type="text/javascript" src="js/formcheck.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div style="text-align:center;font-size:20px;">快速注册</div>
    </div>    
   
    <div class="web_login">
    
    	<form name="form2" id="from2" accept-charset="utf-8" action="LogRegServ" method="post">
       		<ul class="reg_form" id="reg-ul">
                <li>
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="username" name="username" maxlength="16" class="easyui-validatebox inputstyle2"/>
                    </div>
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="pswd"  name="pswd" maxlength="16" class="easyui-validatebox inputstyle2"/>
                    </div>
                </li>
                
                <li>
                	<label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="pswd2" name="pswd2" maxlength="16" class="easyui-validatebox inputstyle2" />
                    </div>
                    
                </li>
                
                <li>
                	<label for="email" class="input-tips2">邮箱：</label>
                    <div class="inputOuter2">
                        <input type="text" id="email" name="email" class="easyui-validatebox inputstyle2" />
                    </div>
                </li>
                
                <li>
                    <div class="inputArea">
                        <input type="submit" id="reg" style="margin-top:10px;margin-left:85px;" class="button_blue" value="同意协议并注册"/> <a href="#" class="zcxy" target="_blank">注册协议</a>
                    </div>
                </li>
                
                <div class="cl"></div>
           	</ul>
            <input type="hidden" name="dowhat" value="reg">
        </form>
    
    </div>
   </div>
</body>
</html>