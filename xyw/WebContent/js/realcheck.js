
//表单验证
$(function () {

	$('#name').validatebox({
		required: true,
	    validType: "CHS",
	    missingMessage:'姓名不能为空',
	    invalidMessage:'姓名不是中文'
	});
	$('#post').validatebox({
		required: true,
	    validType: "zipcode",
	    missingMessage:'请填写邮编',
	    
	});
	
	$('#idcard').validatebox({
		required: true,
	    validType: "idcard",
	    missingMessage:'请填写身份证号码',
	    
	});
	
//绑定表单	
	$('form').bind('submit',function () {
		if (!$('#name').validatebox('isValid')){
			$('#name').focus();
            return false;
		} else if(!$('#post').validatebox('isValid')){
			$('#post').focus();
            return false;
		}else if(!$('#idcard').validatebox('isValid')){
			$('#idcard').focus();
            return false;
		}

	});

	
});

