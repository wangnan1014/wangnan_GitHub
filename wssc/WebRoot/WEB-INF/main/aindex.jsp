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
	
    <style type="text/css">  
        #menu {  
            width:auto;  
            /*border:1px solid red;*/  
        }  
        #menu ul {  
            list-style: none;  
            padding: 0px;  
            margin: 0px;  
            width:auto; 
        }  
        #menu ul li {  
            border-bottom: 1px solid #fff;  
              
        }  
        #menu ul li a {  
            /*先将a标签转换为块级元素，才能设置宽和内间距*/  
            display: block;  
            background-color: #00a6ac;  
            color: #fff;  
            padding: 5px;  
            text-decoration: none;  
        }  
        #menu ul li a:hover {  
            background-color: #008792;  
        }  
          
    </style>	

	<script type="text/javascript">  
	    $(function(){  
	        $("a[title]").click(function(){  
	        
	            var text = $(this).text();  
	            var href = $(this).attr("title");  
	            //判断当前右边是否已有相应的tab  
	            if($("#tabs").tabs("exists", text)) {  
	                $("#tabs").tabs("select", text);  
	            } else {  
	                //如果没有则创建一个新的tab，否则切换到当前tag  
	                $("#tabs").tabs("add",{  
	                    title:text,  
	                    closable:true,  
	                    content:'<iframe title=' + text + ' src=' + href + ' frameborder="0" width="100%" height="100%" />'  
	                    //href:默认通过url地址加载远程的页面，但是仅仅是body部分  
	                    //href:'send_category_query.action'  
	                });  
	            }  
	                  
	        });  
	    });  
	</script>      

  </head>
<body class="easyui-layout">   
	    <div data-options="region:'north',title:'欢迎来到我的购物后台管理',split:true" style="height:100px;"></div>   
	    <div data-options="region:'west',title:'系统菜单',split:true" style="width:300px;">
			<div id="menu" class="easyui-accordion" style="width:auto;height:auto;">   
			    <div title="基本操作" data-options="iconCls:'icon-save'">   
			    <ul>
					<li><a href="javascript:void(0)" title="send_main_aindex.action">类别管理</a>
					<li><a href="javascript:void(0)" title="send_main_aindex.action">商品管理</a>
				</ul>    
			    </div>   
			    <div title="其他操作" data-options="iconCls:'icon-reload',selected:true" >  
			    <ul> 
			        <li><a href="javascript:void(0)" title="send_main_aindex.action">类别管理</a>
					<li><a href="javascript:void(0)" title="send_main_aindex.action">商品管理</a>   
			    </div>   
 				</ul>
			</div>	    
	    </div>   
	    <div data-options="region:'center',title:'后台操作页面'" style="padding:5px;background:#eee;">
	    	<div id="tabs" class="easyui-tabs"  data-options="fit:true">
	    		<div title="首页" style="padding:20px">
	    			<H1>欢迎！</H1>
	    		</div>
	    	</div>
	    </div>   
	</body>	 
    
</html>
