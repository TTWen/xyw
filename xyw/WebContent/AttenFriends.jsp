<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>关注好友</title>
</head>
<body>
  <form action="AttenFriendsServlet" method="post" class="form-horizontal" role="form" novalidate="novalidate">
            <div class="form-group" >
				<label class="col-md-3 control-label ">关注人id</label>
				  <div class="col-md-9">
						<input name='userid' type="text" class="form-control"/>
				  </div>
			</div>
				
			<div class="form-group" >
					<label class="col-md-3 control-label ">被关注人id</label>
					<div class="col-md-9">
						<input name='attenid' type="text" class="form-control"/>
					</div>
			</div>
			<div class="form-group">
					<input type="submit" value="关注好友" style="width:150px;" class="button_blue"/>
	                	</div>
	        <input type="hidden" name="dowhat" value="Attention">
   </form>
</body>
</html>