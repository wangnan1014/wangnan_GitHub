<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//String result 
//System.out.println(result);
//if(result==null||result==""){
//	result = "-1";
//}
%>
<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>	
<html> 
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="用户注册页面">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	<link rel="stylesheet" type="text/css" href="css/register.css">
	<SCRIPT src="js/jquery-2.1.4.min.js" type="text/javascript"></SCRIPT>
  	
</head>

<body>
<div class="top_div1">

<strong>用户注册页面</strong>
</div>
<DIV class="top_div">
</DIV> 
<DIV class="div1">
<DIV style="width: 165px; height: 96px; position: absolute;">
<DIV class="tou"></DIV>
<DIV class="initial_left_hand" id="left_hand"></DIV>
<DIV class="initial_right_hand" id="right_hand"></DIV></DIV>
<input type="hidden" id = "result" name ="result" value="${result}">
	<s:form id="form1" name="form1" action="register/register" method="post" >
		<P style="padding: 30px 0px 10px; position: relative;">
		<SPAN class="u_logo"></SPAN>
		 <INPUT class="ipt" type="text" id = "uname" name ="rpuser.uname" placeholder="请输入用户名" value=""> 
		 
		</P>
		<P style="position: relative; padding: 0px 0px 10px"><SPAN class="p_logo"></SPAN>   
		 
		<INPUT class="ipt" id="password" name ="rpuser.password" type="password" placeholder="请输入密码" value="">
			
		</P>
		<P style="position: relative;"><SPAN class="p_logo"></SPAN>
		<INPUT class="ipt" id="repassword"  name ="repassword" type="password" placeholder="请输入密码确认" value="">   
		</P>
		
		<DIV  class="div2">
			<P style="margin: 0px 35px 20px 45px;"><SPAN style="float: right;">
 				
				
				<A  href="javascript:register()">注&nbsp&nbsp&nbsp册</A>  
				<A  href="javascript:reset()">重&nbsp&nbsp&nbsp置</A> 		
			</P>
			
		</DIV>
</s:form>
</DIV>
</body>
<SCRIPT type="text/javascript">
	var  result=document.getElementById('result');
	if("1"==result.value){
		alert("注册成功！")
		result.value="";
		window.close();
	}else if("0"==result.value){
		alert("注册失败，该用户已存在！")
		result.value="";
	}


	function reset(){
		document.form1.reset();	
	}
	//validate
	function register(){
		var i = 0 ;
		if(document.form1.uname.value == "") {
		  	alert("用户名不能为空,请输入用户名！");  
		  	document.form1.uname.focus();  
		  	i = 1;
		  	return false;
		}
		if(document.form1.uname.value.length >10) {
		    alert("用户名不能超过10个字符！");
		    document.form1.uname.focus();  
		    i=2;
		    return false;
		} 		
		if(document.form1.password.value == ""||document.form1.repassword.value == ""){
		  	alert("密码不能为空,请输入密码！");  
		  	document.form1.password.focus();  
		  	i=3;
		  	return false;		
		}
		if(document.form1.password.value!=document.form1.repassword.value) {
			alert("确认密码与密码不一致");
		    document.form1.repassword.focus(); 	    
            i=4; 
            return false;
		} 	
		if(i==0){
		 document.form1.submit();   
		}	
	}
$(function(){
	//password得到焦点
	$("#password").focus(function(){
		$("#left_hand").animate({
			left: "150",
			top: " -38"
		},{step: function(){
			if(parseInt($("#left_hand").css("left"))>140){
				$("#left_hand").attr("class","left_hand");
			}
		}}, 2000);
		$("#right_hand").animate({
			right: "-64",
			top: "-38px"
		},{step: function(){
			if(parseInt($("#right_hand").css("right"))> -70){
				$("#right_hand").attr("class","right_hand");
			}
		}}, 2000);
	});
	//password失去焦点
	$("#password").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
	//repassword得到焦点
	$("#repassword").focus(function(){
		$("#left_hand").animate({
			left: "150",
			top: " -38"
		},{step: function(){
			if(parseInt($("#left_hand").css("left"))>140){
				$("#left_hand").attr("class","left_hand");
			}
		}}, 2000);
		$("#right_hand").animate({
			right: "-64",
			top: "-38px"
		},{step: function(){
			if(parseInt($("#right_hand").css("right"))> -70){
				$("#right_hand").attr("class","right_hand");
			}
		}}, 2000);
	});
	//失去焦点
	$("#repassword").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
});
</script>
</html>
