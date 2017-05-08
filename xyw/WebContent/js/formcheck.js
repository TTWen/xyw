// 正则表达式获取url中的参数
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

// 验证邮箱
function ckemail() {
	var email = $('#email').val();
	if (email != '') {//判断
	    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	    if (!reg.test(email)) {
	        return false;
	  }
	}
	return true;
}

/*!验证表单是否填写完善!*/
$(function () {
	
		// 给form标签绑定submit事件
		$('form').bind('submit',function () { 
		var i=0;
		
		// 遍历input标签，判断是否有内容未填写
		$('input').each(function(){ 
			var vl=$(this).val();
			if(vl==""){
				i=1;
			}
		});
		
		// 判断textarea标签是否填写
		var t=$('textarea').val(); 
		if (t=='') {
			i=1;
		}
		
		// 如果有未填写的，则return false阻止提交
		if (i==1) {
			alert('请将信息填写完整');
			return false;
		
		// 表单内容格式错误
		} else if (ckemail()){
			alert('邮箱格式错误！');
		    $('#email').focus();
		    return false;
		
		// 密码加密后传给后台
		} else {
			var pswd = $('#pswd').val();
			var md5pswd = $.md5(pswd);
			$('#pswd').val(md5pswd);
			pswd = $('#pswd').val();
		}
		
		
	});
		
	// 如果登录验证失败
	var err = GetQueryString("error");
	if(err == "logfail") {
		alert('用户名或密码错误！');
	} else if(err == "regfail"){
		alert('注册失败！');
	} else if(err == "reusername"){
		alert('用户名重复');
	}
});

