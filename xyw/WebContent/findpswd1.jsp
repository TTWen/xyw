<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>

	<div class="box01 box01_c pwd_box ">
	<div class="box_hd hd02"><h1>重置登录密码</h1></div>
        <ul class="box_bd account_form pwd_form">
            <li>
                <label class="tit">请输入登录名</label>
                <input type="text" class="m_input w01" id="txt_logname" />
            </li>
            <li id="divVerifyCode">
                <label class="tit">请输入验证码</label>
                <input type="text" class="m_input w02" id="txt_code" />
                <img id="img_code" height="30" style="top: 5px; right: 63px;" />
                <span>看不清，<a style="cursor:pointer;" id="a_code" title="换一个验证码">换一张</a></span>
            </li>
            <li>
                <label class="tit">&nbsp;</label>
                <button type="button" id="btn_submit" class="btn_l3">
                <span><em>提交</em></span></button>
            </li>
        </ul>
        <input type="hidden" name ="page_id" value ="100019"/>
    </div>
    
</body>
</html>