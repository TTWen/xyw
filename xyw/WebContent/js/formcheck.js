// 正则表达式获取url中的参数
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if( r != null) return unescape(r[2]); 
     return null;
}

//表单验证
$(function () {
	$('#email').validatebox({
	    required: true,
	    validType: 'email',
	    missingMessage:'邮箱不能为空',
	    invalidMessage:'邮箱格式不正确'
	});
	$('#username').validatebox({
		required: true,
	    validType: "account['6','16']",
	    missingMessage:'用户名不能为空',
	});
	
	$('#pswd').validatebox({
		required: true,
	    validType: 'pswd',
	    missingMessage:'密码不能为空',
	    invalidMessage:'密码以字母开头，长度在6~16之间，只能包含字符、数字和下划线'
	});
	
	$('#pswd2').validatebox({
		required: true,
	    validType: "equalTo['#pswd']",
	    missingMessage:'确认输入密码',
	    invalidMessage:'两次密码不一致'
	});
	
});

