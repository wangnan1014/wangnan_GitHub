<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.heag.rcpc.model.RpUser"%>
<%@taglib prefix="s" uri="/struts-tags" %>	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	RpUser user = (RpUser)session.getAttribute("user");
%>
<!-- Custom CSS 2-->
<link href="../css/heagreport2.css" rel="stylesheet">  
<script src="../js/metisMenu.min.js"></script>
<!-- Navigation -->
<div id = "modalDome">
</div>
<nav class="navbar navbar-default navbar-static-top"  role="navigation" style="margin-bottom: 0;background-color:#305286">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" style="color:#000" href="/loginMain.action"><img src="../images/logo.png" ></a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i><%=user.getRealname()%><i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
            <!--    <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户资料</a>
                </li>-->

                <li><a href="javascript:into_passwordModify('passwordModify')"  class="passwordModify"><i class="fa fa-key fa-fw"></i>修改密码</a>
                </li>
                <li class="divider"></li>
                <li><a href="/login!logout.action"><i class="fa fa-sign-out fa-fw"></i>登出</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->
    <div class="navbar-default sidebar" role="navigation" style="background-color:#305286">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">


                
                <li>
                    <a href="<%=basePath %>page/questionnaire.jsp?uid=<%=user.getUid()%>" target="_self"><i class="fa fa-file-text-o fa-fw"></i>编辑问卷</font></a>
                </li>
                <!--
                <li>
                    <a href="<%=basePath %>page/evaluatedManage.jsp" target="_self"><i class="fa fa-group fa-fw"></i>评估名单</a>
                </li>
                <li>
  <a href="<%=basePath %>page/sendInvitations.jsp" target="_self"><i class="fa fa-sign-in fa-fw"></i>发送邀请</a>
                </li>
                -->
				<!-- 
				<li>
                    <a href="javascript:setDiv('../log/goto.action',0)"><i class="fa fa-clock-o fa-fw"></i>操作日志</a>
                </li>
                
                <li>
                    <a href="#"><i class="fa fa-user fa-fw"></i>用户设置<span class="fa arrow"></span></a>
                  	  <ul class="nav nav-second-level">
                  	  	<li>
                  	  		<a href="javascript:setDiv('../page/userList.jsp',0)">用户列表</a>
                  	  	</li>
                  	  </ul>
                </li>                
				
                 <li>
                    <a href="javascript:setDiv('../page/menuManage.jsp',0)"><i class="fa fa-list-alt  fa-fw"></i>菜单管理</a>
                </li>  
                 -->
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>

 <div id ="showOrhide" class="vertical-center">
<a href="#" ><i id="sh" class="fa fa-chevron-left fa-fw"></i></a>
</div>  
<script type="text/javascript">
	//菜单栏左右滑动
	$("#showOrhide").click(function(){
		 	 $("#sh").toggleClass("fa-chevron-left");
		 	 $("#sh").toggleClass("fa-chevron-right");
		 	 
			 //$(".sidebar").animate({width: 'toggle'},{speed:'fast'});
			 $(".sidebar").toggle();
			 $("#page-wrapper").toggleClass("page-wrapper2"); 
			 $("#showOrhide").toggleClass("vertical-center1");	
	});
	//调用页面模拟框
	function into_register(cid,paras){
        //var url = "../page/register.jsp";
        var url = "../register/select.action?rand="+Math.random()+"&"+paras;
      	var i=setHtml(url,"#"+cid);
		//$('#register').modal('show');
	}
	function into_passwordModify(cid){
        var url = "../page/passwordModify.jsp?rand="+Math.random();
		var i=setHtml(url,"#"+cid);	
		//$('#passwordModify').modal('show');
	}
	
    //模板调用

	function setHtml(url,id){ 
	    $.post(url,function (value) { 
            	$('#modalDome').html(value);            	
            	$(id).modal({
            		show:true,
            		backdrop: 'static'
            	});
        });	
	}
	//调用跳转
	function setDiv(url,divid){
	        $.post(url,function (value) {
            	jQuery('#page-wrapper').html(value);
        });	
	}
	//以后统一调用 打开模拟框 
	function showSysModal(){
	$('#myModal').modal({
  		keyboard: true
	})	
	}
</script>
<!-- 模态框（Modal） -->
<!-- 
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	正文
            </h4>
         </div>
         <div class="modal-body">
			 <form name="form10" id="form10">  
				
			 </form>  
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default"
               data-dismiss="modal">关闭
            </button>
            
            <a onclick="doModalEdit();"><button type="button" class="btn btn-primary">
               	提交
            </button></a>
         </div>
      </div> 
   </div> 
</div> 
 -->