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
<input type="hidden" name="flag"  value="ts_add">
<tr>标题<input type="text" name="head" style="width:100px;height:20px;"></tr><br><br>           <!-- 推送标题 -->
<tr>正文<textarea rows="3" cols="30" name="content"></textarea></tr><br><br>		<!-- 推送内容 -->
<tr>新闻<input type="radio" name="type" value="新闻">
公告<input type="radio" name="type" value="公告">
声明<input type="radio" name="type" value="声明">
</tr><br><br>
<tr><input type="submit" name="添加" value="添加"></tr>
</form>
</body>
</html>