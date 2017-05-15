<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加推送</title>
</head>
<body>
<form action="PushServ" method="post" style="text-align:center">
	<input type="hidden" name="flag"  value="push_add">
	标题<input type="text" name="head" style="width:100px;height:20px;"></br></br>         
	正文<textarea rows="3" cols="30" name="content"></textarea></br>	</br>
	类型<select>
	<option name="type">文章</option>
	<option name="type">公告</option>
	<option name="type">新闻</option>
	</select></br></br>
	<input type="submit" name="添加" value="添加" >
</form>
</body>
</html>