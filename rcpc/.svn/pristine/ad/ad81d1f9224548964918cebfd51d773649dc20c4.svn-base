	$(document).ready(function() {	
		getColData("deptid","getDepartmentList","selcet","did","dname","deptname");
		getColData("roleid","getUserRoleList","selcet","roleid","rolename","rolename");
		getColData("cid","getCompanyList","selcet","cid","cname","cname");

		if($("#actionName").val()=="view"){	
			getData();
		}
	})
	//注册
	function register(obj){
		if($("#cid").find("option:selected").val()==""){
		  	$('#cid1').popover('show');
		  	document.form1.uname.focus();  
		  	i = 1;
		  	return false;			
		}
		
		if($("#deptid").find("option:selected").val()==""){
		  	$('#deptid1').popover('show');
		  	document.form1.uname.focus();  
		  	i = 1;
		  	return false;		
		}

	    if($("#roleid").find("option:selected").val()==""){
		  	$('#roleid1').popover('show');
		  	document.form1.uname.focus();  
		  	i = 1;
		  	return false;	    	
	    }	
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
		if($('#actionName').val()=="add"){
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
		}
		if(i==0){
		   if(obj=="add"){
			   htmlobj=$.ajax({
				   type: 'POST', 
			  	   url:"../register/register.action?rand="+Math.random(),
				   data: $("#form1").serialize(),
				   async:false,
				   success : function(data, textStatus) {  
				   	if(data==0){
				   		alert("注册失败！")
				   	}else if(data==1){	   		
				   		if(confirm("用户新增成功,是否继续新增！")){
				   			  setDiv('/page/userList.jsp',0);
							  $("#form1")[0].reset();
						}else{
							  $('#register').modal('hide');
							  setDiv('/page/userList.jsp',0);
						}
				   	}else if(data==3){
				   		$('#u3').popover('show');
				   		document.form1.uname.focus();  
				   	}
			   }
			   });
		   }else if(obj=="save"){
		   	   setChangedProperty();
			   htmlobj=$.ajax({
				   type: 'POST', 
				   url:"../user/user!saveUser.action?rand="+Math.random(),
				   data: $("#form1").serialize(),
				   async:false,
				   success : function(data, textStatus) {  
				   	if(data==0){
				   		alert("保存失败！")
				   	}else if(data==1){	   		
				   		if(confirm("保存成功,是否继续编辑！")){
				   			  setDiv('/page/userList.jsp',0);
						}else{
							  $('#register').modal('hide');
							  setDiv('/page/userList.jsp',0);
						}
				   	}else if(data==3){
				   		$('#u3').popover('show');
				   		document.form1.uname.focus();  
				   	}
			   }
			   });			   
			   
		   }
		}	
	}

	//数据初始化
	function getData(){
		$.ajax({
		   type: 'POST', 
		   url:"/user/user!getDataOne.action?uid="+$('#uid').val(),
		   data: {},
		   dataType: "json",
		   async:false,
		   success : function(d){
			if(!d){
			}else{
				setData(d);
			}
		   },
		   error:function(d){
		   	   alert("数据错误，请联系相关人员！")
		   }
	   });			
	}

	
	var  result=document.getElementById('result');
	
	if("1"==result.value){
		alert("注册成功！")
		result.value="";
		//window.close(); 
	}else if("0"==result.value){
		alert("注册失败，该用户已存在！")
		//result.value="";
	}
	   $(function () { 
	   		$('#register').modal('hide');
	 		$(".form-control").blur(function(){ 
	 			var name = '.'+this.id
	 			$(name).popover('hide');
	 		}) 		
	   });	
	   