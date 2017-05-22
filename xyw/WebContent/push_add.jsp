<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加推送</title>
</head>
<body>
${reback}
<form action="PushAddServ" method="post" style="text-align:center" enctype ="multipart/form-data">
<!--设置enctype ="multipart/form-data"，以二进制形式提交参数，request.getparameter()无法取到参数
应该利用commons中jar包相关方法  -->
	标题<input type="text" name="head" style="width:100px;height:20px;"></br></br>         
	正文<textarea rows="3" cols="30" name="content"></textarea></br>	</br>
	图片<input type="file" name="picture" ></br>	</br>
	类型<select>
	<option name="type">文章</option>
	<option name="type">公告</option>
	<option name="type">新闻</option>
	</select></br></br>
	<input type="submit" name="添加" value="添加" >
</form>
</body>
</html>