<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="/public/head.jspf" %>
  </head>
	<body class="easyui-layout">   
	    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>   
	    <div data-options="region:'west',title:'West',split:true" style="width:300px;">
			<div id="aa" class="easyui-accordion" style="width:300px;height:auto;">   
			    <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">   
			        <h3 style="color:#0099FF;">Accordion for jQuery</h3>   
			        <p>Accordion is a part of easyui framework for jQuery.     
			        It lets you define your accordion component on web page more easily.</p>   
			    </div>   
			    <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
			        content2    
			    </div>   
			    <div title="Title3">   
			        content3    
			    </div>  
			    <div title="Title4">   
			       <a href="send_main_aindex.action">测试到后台</a>
			    </div>  
			</div>	    
	    </div>   
	    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>   
	</body> 
    
</html>
