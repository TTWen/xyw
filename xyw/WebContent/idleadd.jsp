<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>添加一个闲置物品</title>
 
		<link rel="stylesheet" media="screen" href="styles.css" >
		<link rel="stylesheet" type="text/css" href="css/idleadd.css">
		<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="js/validator.js"></script>
		<script type="text/javascript" src="js/formcheck.js"></script>
		<script type="text/javascript" src="js/regist.js"></script>
		<script type="text/javascript" src="images/login.js"></script>
	</head>
		<script type="text/javascript">
		  	function addfile()
		  	{
		  		var files = document.getElementById("files");
		  		var input = document.createElement("input");
		  		input.type = 'file';
		  		input.name = 'idlepicurl';
		  		input.id = 'idlepicurl'
		  		
		  		var btn = document.createElement("input");
		  		btn.type = 'button';
		  		btn.value = '删除';
		  		btn.onclick = function del(){
		  			this.parentNode.parentNode.removeChild(this.parentNode);
		  		}
		  		
		  		var div = document.createElement("div");
		  		div.appendChild(input);
		  		div.appendChild(btn);
		  		
		  		files.appendChild(div);
		  	}
  		</script>
	<body>

		<form class="addidle_form" action="IdleServ?method=addidle&memid=3" method="post" name="addidle_form" accept-charset="UTF-8"enctype="multipart/form-data">
			<ul>
				<li>
					<h2>添加一个闲置物品表单</h2>
					<span class="required_notification">* 表示必填项</span>
				</li>
				<input type="text" id="idleid" name="idleid" value="<%=request.getParameter("idleid") %>" style="display:none"/>
				<input type="text" id="memid" name="memid" value="<%=request.getParameter("memid") %>" style="display:none"/><br>
				<li>
					<label for="idlename">闲置物品名称:</label>
					<input type="text" id="idlename" name="idlename" required/>*
				</li>
				<li>
					<label for="idledetail">闲置物品详情描述:</label>
					<textarea rows="10" cols="40" id="idledetail" name="idledetail" onfocus="this.value=''; this.onfocus=null;">在此输入详细信息</textarea>*
				</li>
				<li>
					<label for="message">闲置物品类型:</label>
					<select name="idletype">
							<option value="forfree">免费提供</option>
							<option value="forsale">待售物品</option>
					</select>*
				</li>
				<li>
					<table>
							<label for="idledetail">闲置物品图片上传:</label>
				  			<input type="button" name = "wenjian" value="添加上传文件" onclick="addfile()">
				  		<tr>
				  			<td></td>
				  			<td>
				  				<div id="files"></div>
				  			</td>
				  		</tr>
	  				</table>
				</li>
				<li>
					<button class="submit" type="submit">提交</button>
				</li>
			</ul>
		</form>
	</body>
</html>