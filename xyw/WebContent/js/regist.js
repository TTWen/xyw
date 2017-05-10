
// 注册表单验证
$(function () {

	// 给注册表单绑定submit事件
	$('form').bind('submit',function () { 
		if (!$('#username').validatebox('isValid')) {  
            $('#username').focus();
            return false;
        } else if (!$('#pswd').validatebox('isValid')) {  
            $('#pswd').focus();
            return false;
        } else if (!$('#pswd2').validatebox('isValid')) {
        	$('#pswd2').focus();
        	return false;
        } else if(!$('#email').validatebox('isValid')) {
        	$('#email').focus();
        	return false;
        } else{
        	var pswd = $('#pswd').val();
    		var salt="{*nbsjt*asar#cdxd#}";
    		var md5pswd = $.md5(pswd + salt);
    		$('#pswd').val(md5pswd);
    		pswd = $('#pswd').val();
        }
	});

});

