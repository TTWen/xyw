<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/pushadd.css" rel="stylesheet" type="text/css" />
<title>添加推送</title>
</head>
<body>
<script>
function fileup(){
	var file = document.createElement("input");
	file.type = "file";
	file.name = "file";
	myform.insertBefore(file,document.getElementById("more"));
	}
</script>	
${reback}
<div class="elegant-aero">
<form action="PushAddServ" method="post" id="myform" style="text-align:center" enctype ="multipart/form-data">
	<h1></h1>
	标题<input type="text" name="head" id="name" type="text" ></br></br>         
	<textarea rows="20" cols="100" name="content" id="message" ></textarea></br></br>
	类型<select name="type" >
	<option  value="文章">文章</option>
	<option  value="公告">公告</option>
	<option  value="广告">广告</option>
	</select></br></br>
	<label>请选择图片：</label>
	<input type="file" name="picture" id="filename"></br></br>
	<input type="button" name="更多" value="更多" id="more" onclick="fileup()">
	<input type="submit" name="添加" value="添加" >
	<input type="button" name="fanhui" value="返回"   onclick="javascript:window.location.href='pushmanage.jsp'">
</form>
</div>
</body>
</html>