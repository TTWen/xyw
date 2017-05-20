<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/easyui.css">
<link rel="stylesheet" type="text/css" href="css/icon.css">
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/city-select.js"></script>
<script type="text/javascript" src="js/date-select.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui-lang-zh_CN.js"></script>
<title>Insert title here</title>
<script language="javascript" defer>
	new PCAS("user.province","user.city","user.area");
</script>

</head>

<body>

<div class="easyui-panel" title="修改基本信息" style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="meminfo_form" method="post" action="MemInfoServ" accept-charset="utf-8">
        	<input type="hidden" name="dowhat" value="modifybaseinfo"/>
            <div style="margin-bottom:20px">
                <input class="easyui-datebox" name="birth" style="width:100%" data-options="formatter:format,parser:parse,label:'出生日期'">
            </div>
            <div style="margin-bottom:20px">
               	 性别：
               	 男<input type="radio" name="sex" value="1"/>
               	 女<input type="radio" name="sex" value="0"/>
            </div>
            <div style="margin-bottom:20px">
            	现居城市：<br>
				省<select name="user.province" id="province" ></select><br>
				市<select name="user.city" id="city" ></select><br>
				县<select name="user.area" id="area" ></select><br>
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="signature" style="width:100%;height:60px" data-options="label:'个性签名',multiline:true">
            </div>
            
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a>
        </div>
    </div>
    <script>
        function submitForm(){
            $('#meminfo_form').form('submit');
        }
        function clearForm(){
        	$('#meminfo_form').form('clear');
        }
    </script>
</body>
</html>