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

	<div class="container">
		<div class="logo"></div>
		<fieldset class="stubody">
			<p class="stuhead">学生认证</p>
			<hr style="border: 1px solid #ccc">
			<form action="RealStuServ?rid=<%=rid%>" method="post"
				accept-charset="utf-8">
				<table>
					<tr>
						<td><label for="school">学校：</label></td>
						<td><input class="outinput1" type="text" placeholder="请输入学校"
							name="school" required></td>
					</tr>
					<tr>
						<td><label for="major">专业：</label></td>
						<td><input class="outinput1" type="text"
							placeholder="请输入你的专业" name="major" required></td>
					</tr>
					<tr>
						<td><label for="qq">QQ：</label></td>
						<td><input class="outinput1" type="text"
							placeholder="请输入绑定的qq号" name="qq" required></td>
					</tr>
				</table>
				<input type="submit" class="stucheck" value="学生身份审核"></a>
			</form>
		</fieldset>
	</div>
</body>
</html>