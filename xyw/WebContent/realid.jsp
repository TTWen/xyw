<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实名认证</title>
<link rel="stylesheet" type="text/css" href="./css/realicard.css">

</head>

<body>
<main>

		<div class="container">
		<div class="logo"></div>
			<fieldset>
			<form action="RealIdServ"  method="post" accept-charset="utf-8">
			<label for="rid">编号：</label>
			<br>
			<input type="text" placeholder="请输入编号" name="rid" required>
			<br>
			<label for="name">姓名：</label>
			<br>
			<input type="text" placeholder="请输入你的名字" name="name" required>
			<br>
			<label for="idcard">身份证号码：</label>
			<br>
			<input type="text" placeholder="请输入身份证号码" name="idcard" required>
			<br>
			<label for="adress">地址：</label>
			<input type="text" placeholder="请输入地址" name="adress" required>
			<br>
			<label for="post">邮编：</label>
			<input type="text" placeholder="请输入邮编" name="post" required>
			<input type="submit" class="register" value="实名认证" ></a>
	</form>
	</fieldset>
		</div>
	</main>
	<footer></footer>
</body>
</html>