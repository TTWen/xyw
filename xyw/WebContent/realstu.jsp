<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生身份认证</title>
<link rel="stylesheet" type="text/css" href="./css/realicard.css">
</head>
<body>
            <%String rid=request.getParameter("rid"); %>
             <main>
		<div class="container">
		<div class="logo"></div>
			<fieldset>
			<form action="RealStuServ?rid=<%=rid%>"  method="post" accept-charset="utf-8">
			<h1>ID号为：<%=rid %>用户</h1>
				<label for="school">学校：</label>
				<br>
			<input type="text" placeholder="请输入学校" name="school" required>
			<br>
			<label for="major">专业：</label>
			<br>
			<input type="text" placeholder="请输入你的专业" name="major" required>
			<br>
			<label for="qq">QQ：</label>
			<br>
			<input type="text" placeholder="请输入绑定的qq号" name="qq" required>
			<br>
			<input type="submit" class="register" value="学生身份审核" ></a>
	</form>
	</fieldset>
		</div>
	</main>
	<footer></footer>
</body>
</html>