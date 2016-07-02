	function passwordMod(){
		var i = 0 ; 
		if(document.form1.uname.value == "") {
		  	//alert("用户名不能为空,请输入用户名！");  
		  	$('#u1').popover('show');
		  	document.form1.uname.focus();  
		  	i = 1;
		  	return false;
		}
		if(document.form1.uname.value.length >10) {
		    //alert("用户名不能超过10个字符！");
		    $('#u2').popover('show');
		    document.form1.uname.focus();  
		    i=2;
		    return false;
		} 		
		if(document.form1.o_password.value == ""){
		  	//alert("原始密码不能为空,请重新！");  
		  	$('#op1').popover('show');
		  	document.form1.password.focus();  
		  	i=3;
		  	return false;		
		}
		if(document.form1.password.value == ""){
		  	//alert("密码不能为空,请输入密码！");
		  	$('#p1').popover('show');  
		  	document.form1.password.focus();  
		  	i=3;
		  	return false;		
		}	
		if(document.form1.password.value!=document.form1.repassword.value) {
			//alert("确认密码与密码不一致");
			$('#rp1').popover('show');
		    document.form1.repassword.focus(); 	    
            i=4; 
            return false;
		} 	
		if(i==0){
			
		   htmlobj=$.ajax({
			   type: 'POST', 
			   url:"../register/pwMod.action?rand="+Math.random(),
			   data:  $("#form1").serialize(),
			   async:false,
			   success : function(data, textStatus) {  
			   
			   //history.back()
			   	if(data==0){
			   		//alert("原始密码不正确！")
			   		$('#op2').popover('show');
			   		
			   	}else if(data==1){
			   		alert("修改成功！")
			   		$('#passwordModify').modal('hide');
			   	}else if(data==2){
			   		
			   		$('#u3').popover('show');
			   		document.form1.uname.focus();  
			   	}
			   
		   }
		   });		 
		}	
	}
/**
 * 
	var  result=document.getElementById('result');
	if("1"==result.value){
		alert("注册成功！")
		result.value="";
		//window.close();
	}else if("0"==result.value){
		alert("注册失败，该用户已存在！")
		//result.value="";
	}
*/
	
   $(function () { 
   		$('#passwordModify').modal('hide');
 		$(".form-control").blur(function(){ 
 			var name = '.'+this.id
 			$(name).popover('hide');
 		}) 		
   });

