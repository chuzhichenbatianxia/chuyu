$(function(){
	document.onkeydown=function(event){
		var e = event || window.event || arguments.callee.caller.arguments[0];
		if(e && e.keyCode==13){ // enter 键
			$("#btnLogin").trigger("click");
		}
	};

	$("#btnLogin").click(function(){
		var username=$.trim($("#username").val());
		var password =$.trim($("#password").val())
		var returnurl =$.trim($("#returnurl").val());
		if(username=="") {
			alert("用户名不能为空");
			return;
		}
		if(password=="") {
			alert("密码不能为空");
			return;
		}
		$.ajax({
            type: "post",
            url: "doLogin.do",
            data: {username:username, password:password,returnurl:returnurl},
            dataType:"json",
            success: function(data){
            	var data2=JSON.parse(data);
                if(data2.code==0) {
                	if(returnurl.indexOf("?")>=0) {
						returnurl+="&";
            		} else {
						returnurl+="?"
                	}
                	location.href=returnurl+"ticket="+ data2.ticket;
	        	} else {
                	alert(data2.msg);
                }
            }
        });
	});
	
})