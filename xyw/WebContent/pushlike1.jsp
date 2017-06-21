<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推送点赞</title>
<link href="css/pushlike1.css" rel="stylesheet" type="text/css">
</head>
<body>
${reback}
<form action="PushlikeServ" method="post" style="text-align:center">
<tr><input type="hidden" name="flag" value="pushlike_add" /></tr>
<tr>点赞人ID 　<input type="text" name="likename" size="20"  style="width:200px;height:30px;margin-top:10px;border:2px solid lightblue;" /></tr>
<br><br>
<tr>被点赞人ID <input type="" name="likedname" size="20" style="width:200px;height:30px;border:2px solid lightblue;"/></tr>
<br><br>
<tr><input type="submit" value="点赞" style="width:100px;margin-left:80px;" class="button1"/></tr>
</form>
</body>
</html>