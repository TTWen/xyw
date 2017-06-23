<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="QueryFriendsServlet" method="post" class="form-horizontal" role="form" novalidate="novalidate">
            <div class="form-group" >
				<label class="col-md-3 control-label ">昵称关键字</label>
				  <div class="col-md-9">
						<input name='username' type="text" class="form-control"/>
				  </div>
			</div>
				
			<div class="form-group" >
					<label class="col-md-2 control-label ">性别</label>
					 <div class="col-md-9">
						男 <input name="sex" type="radio" value="1"/>
						女 <input name="sex" type="radio" value="0"/>
				  </div>
			</div>
			<div class="form-group" >
					<label class="col-md-2 control-label ">地区</label>
					 <div class="col-md-9">
					    <input name='city' type="text" class="form-control"/>
				     </div>
			</div>	
			<div class="form-group">
					<label class="col-md-3 control-label ">年龄最小</label>
				  <div class="col-md-9">
						<input name='age1' type="text" class="form-control"/>
				  </div>
	        </div>
	        <div class="form-group">
					<label class="col-md-3 control-label ">年龄最大</label>
				  <div class="col-md-9">
						<input name='age2' type="text" class="form-control"/>
				  </div>
	        </div>
			<div class="form-group">
					<input type="submit" value="查询好友" style="width:150px;" class="button_blue"/>
	        </div>
   </form>
</body>
</html>