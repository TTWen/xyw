
// 登录表单验证
$(function () {

	$('#username').validatebox({
		required: true,
		missingMessage:'用户名不能为空'
	});
	
	$('#pswd').validatebox({
		required: true,
		missingMessage:'密码不能为空'
	});

	
	// 给登录表单绑定submit事件
	$('form').bind('submit',function () {
		if (!$('#username').validatebox('isValid')){
			$('#username').focus();
            return false;
		} else if (!$('#pswd').validatebox('isValid')) {  
            $('#pswd').focus();
            return false;
        }
    	var pswd = $('#pswd').val();
		var salt="{*nbsjt*asar#cdxd#}";
		var md5pswd = $.md5(pswd + salt);
		$('#pswd').val(md5pswd);
		pswd = $('#pswd').val();
	});

	// 如果登录验证失败
//	var err = GetQueryString("error");
//	if(err == "logfail") {
//		alert('用户名或密码错误！');
//	} else if(err == "regfail"){
//		alert('注册失败！');
//	} else if(err == "reusername"){
//		alert('用户名重复');
//	}
});

