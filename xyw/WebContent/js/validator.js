
// 扩大easy ui表单的验证 
$.extend($.fn.validatebox.defaults.rules, {  
    // 汉字 验证
    CHS: {  
        validator: function(value) {  
            return /^[\u0391-\uFFE5]+$/.test(value);  
        },  
        message: '只能输入汉字'  
    },
    // 手机号码验证  
    mobile: {
    	// value值为文本框中的值  
        validator: function (value) {  
            var reg = /^1[3|4|5|8|9]\d{9}$/;  
            return reg.test(value);
        },
        message: '手机号码格式不正确'
    },
    // 国内邮编验证 
    zipcode: {  
        validator: function (value) {  
            var reg = /^[1-9]\d{5}$/;  
            return reg.test(value);  
        },
        message: '邮编为不以0开头的6位数字'
    },
    // 用户名验证（只能包含下划线、数字、字母）   
    account: {
    	// param的值为[]中值 
        validator: function (value, param) {
        	if (!/^[\w]+$/.test(value)) {
                $.fn.validatebox.defaults.rules.account.message = '用户名只能数字、字母、下划线构成';  
                return false;  
            } else {  
            	if (value.length < param[0] || value.length > param[1]) {  
                    $.fn.validatebox.defaults.rules.account.message = '用户名长度必须在'
                    	+ param[0] + '至' + param[1] + '个字符';  
                    return false;  
                } else {  
                    return true; 
                }
            }
        }, message: '' 
    },
    //密码验证
    pswd: {
    	validator: function (value) {  
            var reg = /^[a-zA-Z]\w{5,15}$/;
            return reg.test(value);
        }
    },
    //密码二次输入相同验证
    equalTo: { 
    	validator: function (value, param) { 
    		return value == $(param[0]).val(); 
    	}, message: '' // 必须加 message
    }
});