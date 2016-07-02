$(function (){
//start by wn
	 //读取cookie 
	var srn ="";
    var srp ="";
    if($.cookie("save_report_name")&& $.cookie("save_report_password")){
   	  srn = $.cookie("save_report_name") ;
   	  srp = $.cookie("save_report_password");
  	  if(srn!=''&&srn!=undefined){
	   	  $("#username").val(unescape(srn));
	  	  $("#password").val(unescape(srp));
	  	  $("#cookiesave").attr('checked',true);
  	  }
    } 
	//记住用户, 只留最后个用户
	  $("#cookiesave").click(function(){
	  	 if(this.checked){
		  	 $.cookie("save_report_name",escape($("#username").val()),{ path: '/', expires: 7 });    
		  	 $.cookie("save_report_password",escape($("#password").val()),{ path: '/', expires: 7 });
	  	 }else{
	  	 	 $.cookie("save_report_name",null,{path:'/',expires: -1}); //删除cookie   
	  	 	 $.cookie("save_report_password",null,{path:'/',expires: -1}); //删除cookie   
	  	 }
	  })
	 //
	  $("#username,#password").bind("input onpropertychange", function () {
	  	if(escape($("#username").val())==srn&&escape($("#password").val())==srp){
	  		 $("#cookiesave").prop('checked',true);
	  	}else{
	  		 $("#cookiesave").prop('checked',false);
	  	 }
	  })	
	
//end 
	
  //  $("#loginin").attr("data-content","hello!");
 //   $("[data-toggle='popover']").popover();
    $("#info").hide();
//    $("#check").hide();
    $("#loginin").click(function() {
        if (check()) {
            submit();
        }
    });

    window.document.onkeypress=function(e){
        if(e && e.keyCode == 13){
            submit();
        }
    };

    function submit(){
        jQuery.ajax({
            async: false,
            type: "POST",
            url: "/login!login.action",
            data: {
                'username':$("#username").val(),
                'password':$("#password").val(),
                'remember':$("#remember").val()
            },
            success: function(data){

                if(data==1){
                  //  $("#loginin").attr("data-content","登录成功!").popover();

                    document.location.href="/loginMain.action";
                }else{
                    if(data==0){
                     //   $("#loginin").attr("data-content","用户名或密码错!").popover();
                        $("#info").text("用户名或密码错！").show();

                    }

                }
            }

        });
    }

});

function check(){

    if($.trim($("#username").val())==''){
      //  $("#loginin").attr("data-content","请填写用户名!");
        $("#info").text("请填写用户名！").show();
        $("#username").val("");
        $("#username").focus();
        //$("[data-toggle='popover']").popover();

        return  false;
    }
    if($.trim($("#password").val())==''){
    //    $("#loginin").attr("data-content","请填写密码!");
        $("#info").text("请填写密码！").show();
        $("#password").val("");
        $("#password").focus();
    //    $("[data-toggle='popover']").popover();

        return  false;
    }
    return true;
}


/*$(function() {
    $("#loginin").click(function(){
        submit();
    });

    function submit(){

         //   if(login()){
         //       if($("#cookiesave").attr("checked")){
         //           addCookie($("#cookieId").val(),$("#username").attr("id"),$("#username").val(),null);
         //       }else delCookie($("#cookieId").val(),$("#username").attr("id"));
                document.location.href="/login!login.action";
         //   }

    }
    window.document.onkeypress=function(e){
        if(e && e.keyCode == 13){
            submit();
        }
    };

});*/

function login(){
  /*  var loginFrom = location.href;
    var tf=false;
    jQuery.ajax({
        async: false,
        type: "POST",
        url: "/login!login.action",
        data: {
        }

    });*/
  //  document.location.href="/login!mainpage.action";
  //  return tf;
}