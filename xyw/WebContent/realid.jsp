<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实名认证</title>
<link rel="stylesheet" type="text/css" href="./css/realicard.css">

<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/md5.js"></script>
<link href="css/easyui.css" rel="stylesheet" type="text/css" />
<link href="css/icon.css" rel="stylesheet" type="text/css" />
<link href="css/color.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/validator.js"></script>

<script type="text/javascript" src="js/realcheck.js"></script>


</head>

<body>


	<div class="container">
		<div class="logo"></div>
		<fieldset class="idbody">
			<p class="stuhead">实名认证</p>
			<hr style="border: 1px solid #ccc">
			<form action="RealIdServ" method="post" accept-charset="utf-8">
				<table>
					<tr>
						<td><label for="name">姓名：</label></td>
						<td><input class=" outinput1" id="name" type="text"
							placeholder="请输入你的名字" name="name"></td>
					</tr>
					<tr>
						<td><label for="idcard">身份证号码：</label></td>
						<td><input class="outinput1" id="idcard" type="text"
							placeholder="请输入身份证号码" name="idcard"></td>
					</tr>
					<tr>
						<td><label for="adress">地址：</label></td>
						<td><input class="outinput1" id="adress" type="text"
							placeholder="请输入地址" name="adress"></td>
					</tr>
					<tr>
						<td><label for="post">邮编：</label></td>
						<td><input class="outinput1" id="post" type="text"
							placeholder="请输入邮编" name="post"></td>
					</tr>
				</table>
				<input type="submit" class="idcheck" value="实名认证">
			</form>
		</fieldset>
	</div>
</body>
</html>