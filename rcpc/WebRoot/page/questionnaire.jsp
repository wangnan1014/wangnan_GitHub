<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.heag.rcpc.util.ConstantsUtil"%>
<%
	String uid = request.getParameter("uid");
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>华仪360度人才评测系统</title>

  <!-- Bootstrap Core CSS -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">

  <!-- MetisMenu CSS -->
  <link href="../css/metisMenu.min.css" rel="stylesheet">

  <!-- Timeline CSS -->
<!--  <link href="../dist/css/timeline.css" rel="stylesheet"> -->

  <!-- Custom CSS 1-->
  <link href="../css/heagreport.css" rel="stylesheet">

  

  <!-- Morris Charts CSS -->
<!--  <link href="../bower_components/morrisjs/morris.css" rel="stylesheet"> -->

  <!-- Custom Fonts -->
  <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- jQuery -->
  <script src="../js/jquery.min.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="../js/bootstrap.min.js"></script>

  <!-- Metis Menu Plugin JavaScript -->
  <script src="../js/metisMenu.min.js"></script>

  <!-- Morris Charts JavaScript -->
  <!--<script src="../bower_components/raphael/raphael-min.js"></script>
  <script src="../bower_components/morrisjs/morris.min.js"></script>
  <script src="../js/morris-data.js"></script> -->

  <!-- Custom Theme JavaScript -->
  <script src="../js/menu.js"></script>
      <!-- Custom Theme JavaScript -->
  <!-- 
  <script src="../js/sb-admin-2.js"></script>
   -->
<script type="text/javascript">
		function showModal(){
			$("#myModal").find("#adescribe").val("");
			$("#myModal").find("#atitle").val("");
			showSysModal();
		}
		function showModalBegin(){
			//showSysModal();//在munu.jsp
			//dotabledate();
			$('#myModal').modal({
		  		keyboard: true
			})
		}
		function refresh(){
		    window.location.reload();//刷新当前页面.
		    // opener.location.reload()刷新父窗口对象（用于单开窗口）
		}		
		function doModalEdit(){
			 var aid = $("#form10").find("#aid").val();
			 if(aid!=''&&aid!=null){

				doEditAskinfo();	
			 }else{
			     $.ajax({
					   type: 'POST', 
				  	   url:"../questionnaire/questionnaire!addAskInfo.action?rand="+Math.random(),
					   data: $("#form10").serialize(),
					   async:false,
					   success : function(data, textStatus) {  
					   	if(data==0){
					   		alert("添加失败！")
					   	}else if(data==1){	   		
					   		//alert("添加成功！")
					   		refresh();
					   		//$('#myModal').modal('hide');
					   	}else{
							
						}
				   },
				   beforeSend: function(XMLHttpRequest){
	                   //ShowLoading();
	               },			   
	               complete: function(XMLHttpRequest, textStatus){
	                   //HideLoading();
	              },			   
				   
				});	
			 }	    	
		}
		function doEditAskinfo(){
			var adescribe= $("#adescribe").val();
			$("#adescribe").val($("#adescribe").val().split('\n').join('<br/>'));
		     $.ajax({
				   type: 'POST', 
			  	   url:"../questionnaire/questionnaire!editAskInfo.action?rand="+Math.random(),
				   data: $("#form10").serialize(),
				   async:false,
				   success : function(data, textStatus) {  
				   	if(data==0){
				   		alert("编辑失败！")
				   	}else if(data==1){	   		
				   		alert("编辑成功！")
				   		refresh();
				   		//$('#myModal').modal('hide');
				   	}else{
						
					}
			   },
			   beforeSend: function(XMLHttpRequest){
                 //ShowLoading();
             },			   
             complete: function(XMLHttpRequest, textStatus){
                 //HideLoading();
            },			   
			   
			});				
		}
		function updateAskinfoState(upAid){
			if(confirm('确定要关闭吗?如果关闭评估人将不能进行答卷')){
			 if(upAid==""){
				alert("编号为空,不能回收");
				return ;
			 }
		     $.ajax({
				   type: 'POST', 
			  	   url:"../questionnaire/questionnaire!updateAskinfoState.action?rand="+Math.random(),
				   data: {"aid":upAid},
				   async:false,
				   success : function(data, textStatus) {  
				   	if(data==0){
				   		alert("关闭失败！")
				   	}else if(data==1){	   		
				   		alert("关闭成功！")
				   		refresh();
				   	}else{
						
					}
			   }			   
			   
			});
		}					
		}
		
		$(function(){
			initAskinfo();
			function initAskinfo(){
			     $.ajax({
					   type: 'GET', 
					   url:"../questionnaire/questionnaire!getDataList.action?rand="+Math.random(),
					   data:{"uid":<%=uid%>},
					   async:false,
					   success : function(data, textStatus) {  
					   	if(data==0){
					   		alert("数据初始化失败！")
					   	}else{
					   		$.each($.parseJSON(data).data,function(index,arr){
								var ht = "<div class='col-lg-12' id='"+ arr.aid +"'>";
								ht+="<div class='panel panel-primary'><div class='panel-heading'>";
								ht+=arr.atitle;
								ht+="</div> <div class='panel-body'> <p> <div class='col-lg-8'>  预览：<a href='answers.jsp?aid="+arr.aid+"&hasRoot=false' target='_blank'>";
								ht+=arr.atitle;
								ht+="</a><input type='hidden' class='adescribe' value='"+ arr.adescribe+"'></input><br/> 创建时间：";
								ht+=arr.createdate+"</div> ";
								ht+="<div class='col-lg-2 col-md-offset-2'> <div class='panel-body'>";
								ht+="<button type='button' class='btn btn-primary btn-circle editAskinfo'  title='编辑'  value='"+arr.aid+"'><i class='fa fa-list'></i></button>&nbsp;";
								ht+="<button type='button' class='btn btn-warning btn-circle deleteAskinfo'  title='删除' value='"+arr.aid+"'><i class='fa fa-times'></i></button>";

								ht+="</div> </div>  </p> </div> <div class='panel-footer'>  <ul class='navbar-top-links '>  <li class='dropdown'>";
								ht+=" <a class='dropdown-toggle' data-toggle='dropdown' href='#'>";
								ht+="<i class='fa fa-user fa-fw'></i> 1.编辑问卷<i class='fa fa-long-arrow-right '></i></a><ul class='dropdown-menu dropdown-user'><li>"
								ht+="<a href='javascript:showModal();' >"
								//ht+="<i class='fa fa-user fa-fw'></i>开始</a></li> <li>";
								ht+="<a href='questionEdit.jsp?aid="+arr.aid+"'>";
								ht+="<i class='fa fa-gear fa-fw'></i>问卷题目</a></li></ul></li><li class='dropdown'>";
								ht+="<a class='dropdown-toggle' href='evaluatedManage.jsp?aid="+arr.aid+"'>";
								ht+="<i class='fa fa-user fa-fw'></i>2.评估名单<i class='fa fa-long-arrow-right '></i></a></li><li class='dropdown'>";
								ht+="<a class='dropdown-toggle'  href='sendInvitations.jsp?aid="+arr.aid+"&atilte="+arr.atitle+"'>";
								ht+="<i class='fa fa-user fa-fw'></i> 3.发送邀请<i class='fa fa-long-arrow-right '></i></a></li><li class='dropdown'>";
								ht+="<a class='dropdown-toggle' href='progress.jsp?aid="+arr.aid+"&atilte="+arr.atitle+"'  > <i class='fa fa-user fa-fw'></i> 4.问卷进度";
								//if(arr.isopen=="0"){
								//	ht+="<a class='dropdown-toggle' data-toggle='dropdown' href='javascript:void(0)' onclick='updateAskinfoState("+ arr.aid +")'> <i class='fa fa-user fa-fw'></i> 4.关闭问卷";
								//}else{
								//	ht+="<a class='dropdown-toggle' data-toggle='dropdown' 
								//href='javascript:void(0);'
								// > <i class='fa fa-user fa-fw'></i> <font color='#CCCCCC'> 4.关闭问卷</font>";
								//}


								ht+="</a></li></ul> </div></div></div>";
								$(".context").append(ht);
							   	})
						}
				   }
				   });
			}
			$(".deleteAskinfo").click(function(){
				if(confirm('确定要删除纪录吗?')){
					var aid =$(this).attr("value");
				     $.ajax({
						   type: 'GET', 
					  	   url:"../questionnaire/questionnaire!deleteAskInfo.action?rand="+Math.random(),
						   data: {"aid":aid},
						   async:false,
						   success : function(data, textStatus) {  
						   	if(data==0){
						   		alert("删除失败！")
						   	}else if(data==1){	   		
						   		alert("删除成功！")
						   		$("#"+aid).remove();
						   	}else{
								
							}
					   }
					});						
				}
			})
			$(".editAskinfo").click(function(){
				var aid =$(this).attr("value");
				var atitle =$("#"+aid).find(".panel-heading").text();
				var adescribe =$("#"+aid).find(".adescribe").val();
				$("#form10").find("#aid").val(aid);
				$("#form10").find("#atitle").val(atitle);
				$("#form10").find("#adescribe").val(adescribe.split('<br/>').join('\n'));
				showSysModal();
			})
		})
   	</script>
   
</head>

<body>

<div id="wrapper">

  <%@ include file="menu.jsp"%>

  <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-11">
                    <h1 class="page-header">360度评估管理</h1>
                </div>  
                  <!--
                 <div class="col-lg-2">
					<button type="button" class="btn btn-sm btn-primary" id="add" name="add">360度评估管理</button>
                </div>                             
                 -->
            </div>  
				<div class="col-lg-12" style="margin-bottom: 5px">
					   <button type="button" class="btn btn-sm btn-danger" id="add" name="add" onclick="showModal()">创建360度评估</button>
					   
					   <br/>
				</div>
				<!-- 主题内容 -->
				<div class="context">
					<!-- 模板 -->
					<!-- 
	                 <div class="col-lg-12" id="1">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                               	问卷题目一
	                        </div>
	                        <div class="panel-body">
	                            <p>
	                            	<div class="col-lg-8">
	                            	 预览：<a herf="#">问卷题目一</a><br/>
	                            	 创建时间：2016-04-18 09:27:06，最后状态时间：2016-04-18 09:27:06
	                            	</div> 
	                            	
	                            	<div class="col-lg-2 col-md-offset-2">
	                            	<div class="panel-body">
	                            		<button type="button" class="btn btn-primary btn-circle" title="编辑" ><i class="fa fa-list"></i></button>
	                            	 	<button type="button" class="btn btn-warning btn-circle" title="删除"><i class="fa fa-times"></i></button>
	                            	</div>
	                            	</div>
	                            </p>
	                        </div>
	                        <div class="panel-footer">
	                        <ul class="navbar-top-links ">    	
				                <li class="dropdown">
				                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
				                        <i class="fa fa-user fa-fw"></i> 1.编辑问卷<i class="fa fa-long-arrow-right "></i>
				                    </a>
				                    <ul class="dropdown-menu dropdown-user">
				                        <li><a href="questionEditbegin.jsp" ><i class="fa fa-user fa-fw"></i>开始</a>
				                        </li>
				                        <li><a href="questionEdit.jsp"><i class="fa fa-gear fa-fw"></i>问卷题目</a>
				                        </li>
				                    </ul>
				                </li>
								<li class="dropdown">
				                    <a class="dropdown-toggle" href="evaluatedManage.jsp">
				                        <i class="fa fa-user fa-fw"></i>2.评估名单<i class="fa fa-long-arrow-right "></i>
				                    </a>
				                </li>
								<li class="dropdown">
				                    <a class="dropdown-toggle"  href="sendInvitations.jsp">
				                        <i class="fa fa-user fa-fw"></i> 3.发送邀请<i class="fa fa-long-arrow-right "></i>
				                    </a>
				                </li>	
								<li class="dropdown">
				                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
				                        <i class="fa fa-user fa-fw"></i> 4.关闭问卷
				                    </a>
				                </li>					                				                			                	                            	
	                        </ul>   	
	                        </div>
	                    </div>
	                </div> 
	                 -->
	                 
                </div> 
         <br/>
<br/>
<br/>            
  </div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->    

<!-- 模态框（Modal） -->
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
					 <input type="hidden"  name="uname" id="uname" value="<%=user.getUname() %>"/>
					 <input type="hidden"  name="uid" id="uid" value="<%=user.getUid() %>"/>
					 <input type="hidden"  name="aid" id="aid" value=""/>
					 
					<label>标题(最多50个字):</label>
					<input class="form-control" placeholder="输入标题"  name="atitle" id="atitle"/>
					<label>填写说明(最多200个字)</label>
                    <textarea class="form-control" rows="10" name="adescribe" id="adescribe"></textarea>
                    <!-- 
					<label>前导页(最多200个字)</label>
                    <textarea class="form-control" rows="10" name="aleadpage" id="aleadpage"></textarea>
					<label>问卷结束说明(最多200个字)</label>
                    <textarea class="form-control" rows="10" name="aendpage" id="aendpage"></textarea>                    
                     -->                    					
			  
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default"
               data-dismiss="modal">关闭
            </button>
            
            <a onclick="doModalEdit();"><button type="button" class="btn btn-primary">
               	提交
            </button></a>
         </div>
         </form> 
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  </body>
</html>
