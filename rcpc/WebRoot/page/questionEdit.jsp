<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.heag.rcpc.util.ConstantsUtil"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>华仪360测评系统</title>

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
function refresh(){
    window.location.reload();//刷新当前页面.
    // opener.location.reload()刷新父窗口对象（用于单开窗口）
}	
var aid = getQueryString('aid');
function getQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}	
//对字段做处理,并生成需要的控件形式
function doModalEdit(){
	if($("#options").val()==undefined||$("#options").val()==''||$("#qname").val()==undefined||$("#qname").val()==''){
		$(".tishi").find("p").empty().append("题目或选项输入不能为空");
		$(".tishi").show(500);
		setTimeout(function(){$(".tishi").hide(500)},5000);
		return ;
	}
	if($("#qid").val()==''){//qid为空字符时 则添加
		var qname = $("#qname").val();
		var options = $("#options").val();
		var optionsArr = options.split("\n");
		var viewHtml = getViewHtml(qname,optionsArr);
		var bulidHtml = getBulidHtml(qname,optionsArr);
		$(".context").append(viewHtml);
		$(".footmodal:last").append(bulidHtml);
		$('#myModal').modal('hide');
		$('#form10')[0].reset();
		
	}
	$(window).scrollTop($('.context')[0].scrollHeight);
}
//生成观赏栏（不可编辑）
function getViewHtml(qname,optionsArr){
	var ht = "<div class='col-lg-12' id='v_qname'>";
	ht +="<div class='panel panel-primary'><div class='panel-heading'>";
	ht +=$(".guding").size()+1+"."+qname+"</div> <div class='panel-body'><p><div class='col-lg-8'>";
	$.each(optionsArr,function(i,data){
		if(data!=""){
			ht +="<div class='radio'><label>";
			ht +="<input type='radio' name='v_option' id='v_option' value='"+data+"' >";
			ht +=data;
			ht +="</label> </div>";			
		}
		
	});
	ht +="</div> <div class='col-lg-2 col-md-offset-1 '><div class='panel-body'><button class='btn btn-warning btn-circle' href='#collapseTwo' title='删除' onclick='removeQ()'><i class='fa fa-times'></i></button> </div></div>  </p> </div>";
	ht +=" <div class='modal-footer footmodal'> </div> </div> </div>";
	return ht;
}

//生成编辑栏
function getBulidHtml(qname,optionsArr){
	var ht ="<div class='panel panel-info q_edit'><div class='panel-body'><div class='col-lg-3'><label class='control-label'>标题：</label>";
	ht +="<input class='form-control' id='e_qname' name ='e_qname' value='"+qname+"'>";
	ht +="</div> <div class='col-lg-3'> <label class='control-label'>选项：</label>";
	$(optionsArr).each(function(i,data){
		if(data!=""){
			ht +=buildRadio(data);
		}
	})
	ht +="</div> <div class='col-lg-2 col-md-offset-2'> <div class='panel-body'>";
	ht +="<button data-toggle='collapse' data-parent='#accordion' href='#collapse1' class='btn btn-info btn-circle btn-lg' title='保存' onclick='doSave(this)' ><i class='fa fa-check'></i></button>";
	//ht +="<button data-toggle='collapse' data-parent='#accordion' href='#collaps'   class='btn btn-warning btn-circle btn-lg closeBulid' title='关闭' onclick='closeBulidHtml()'><i class='fa fa-bitbucket'></i></button>";
	ht +="</div></div></div></div>";
	return ht;
}
//追加编辑栏radio 控件
function addAfter(obj){
		$(obj).parent().parent(".input-group").after(buildRadio(""));
}

//生成编辑栏radio控件
function buildRadio(data){
	var ht="<div class='form-group input-group'>";
	ht +="<input type='text' class='form-control e_option' id='e_option' name='e_option' value='"+data+"'>";
	ht +="<span class='input-group-addon'><a href='javascript:void(0);' onclick='addAfter(this)'><i class='fa fa-plus-circle'></i></a>&nbsp;&nbsp;";
	ht +="<a href='javascript:void(0);' onclick='removeRadio(this)'><i class='fa fa-minus-circle'></i></a></span></div>";
	return ht;
}
//删除编辑栏radio控件
function removeRadio(obj){
	$(obj).parent().parent(".input-group").remove();
	
}
//关闭编辑栏
function closeBulidHtml(){
	$(".footmodal").empty();
}
//逻辑删除题目
function removeQ(){
	$("#v_qname").remove();	
}
//保存题目和选项
function doSave(obj){
	var m= $(obj).parent().parent().parent(".panel-body");
	var e_qname =$(m).find("#e_qname");
	var e_options =$(m).find(".e_option");
	
    $.ajax({
		   type: 'POST', 
	  	   url:"../questionnaire/question!doSave.action?rand="+Math.random(),
		   data: "aid="+aid+"&"+$(e_options).serialize()+'&'+$(e_qname).serialize(),
		   async:false,
		   success : function(data, textStatus) {  
		   	if(data==0){
		   		alert("保存失败！")
		   	}else if(data==1){	   		
		   		refresh();
		   	}else{
				
			}
	   }
	});		
}
//更新pc_question de remark
function doBulidContext(){
	 var qid =$("#modalContext").find("#qid").val();
	 var context =$("#modalContext").find("#context").val();
	 $.ajax({
			type:'GET',
			url:"../questionnaire/question!doBulidContext.action?rand="+Math.random(),
			data:$("#form11").serialize(),
			async:false,
			success:function(data,textStatus){
				if(data==0){
					alert("提交失败！")
				}else{
					refresh()
				}
			}
	})
}

$(function(){

	//初始化加载数据提取
	initQuestion()
	function initQuestion(){
	     $.ajax({
			   type: 'GET', 
			   url:"../questionnaire/question!getDataList.action?aid="+aid+"&rand="+Math.random(),
			   async:false,
			   success : function(data, textStatus) {  
			   	if(data==0){
			   		alert("数据初始化失败！");
			   	}else{
			   		$.each($.parseJSON(data).data,function(index,arr){
			   			var ht="";
			   			//if(arr.remark!=""&&arr.remark!=undefined){
			   			//	ht+="<div class='well well-sm col-lg-12'><h4></h4><p><label>";
			   		    // 	ht+=arr.remark  ;
			   		    //    ht+="</label></p></div>";
				   		//}
						ht += "<div class='col-lg-12 guding' id='"+ arr.qid +"'>";
						ht +="<div class='panel panel-primary'><div class='panel-heading'>";
						ht += index+1+"."+arr.qname+"</div> <div class='panel-body'><p><div class='col-lg-8'>";
						$.each(arr.pcOptions,function(i,os){
							ht += "<div class='radio'><label>";
							ht +=" <input type='radio' class=cc_'"+arr.qid+"' name='"+arr.qid+"' id='"+os.oid+"' value='"+os.oid+"' >";
							ht +=os.ooption;
							ht +=" </label> </div>";
						});
						ht +="</div> <div class='col-lg-2 col-md-offset-1 '><div class='panel-body'>";
						if(arr.remark==undefined){
							arr.remark="";
						}
						ht +="<button data-toggle='collapse' data-parent='#accordion' data='"+arr.qid+"' remark='"+arr.remark +"'  class='btn btn-primary btn-circle doInsertContext' title='插入分段内容'><i class='fa fa-print'></i></button>&nbsp;&nbsp;"
						ht+="<button class='btn btn-warning btn-circle doDelete' data='"+arr.qid+"'><i class='fa fa-times' ></i></button>";
						ht+=" </div></div>  </p> </div>";
						ht +="<div class='modal-footer'> </div> </div> </div>";
						$(".context").append(ht);
					})
					initContext();
				}
		   }
		   });		
	}
	//初始化分段内容
	function initContext(){
		$.ajax({
			type:'GET',
			url:"../questionnaire/question!getContextDataList.action?aid="+aid+"&rand="+Math.random(),
			async:false,
			success:function(data,textStatus){
				if(data==0){
					alert("题目分类错误失败！");
				}else{
					$.each($.parseJSON(data).data,function(index,arr){
		   				var ht="<div class='alert alert-warning col-lg-12'><h4></h4><p><label>";
		   		      	ht+=arr.remark;
		   		        ht+="</label></p></div>";
		   		        $(".guding#"+arr.qid).before(ht);
					})
				}
			}
		})
	}

	
	//删除一条题目和与其相关的选项
	$(".doDelete").click(function(){
		if(confirm('确定要删除纪录吗?')){
		var qid = $(this).attr("data");
			 $.ajax({
					type:'GET',
					url:"../questionnaire/question!doDelete.action?qid="+qid+"&rand="+Math.random(),
					async:false,
					success:function(data,textStatus){
						if(data==0){
							alert("数据初始化失败！")
						}else{
							refresh()
						}
					}
			})
		}
	});	
	
	//弹出分段内容编辑框
	$(".doInsertContext").click(function(){
		$('#modalContext').modal({
	  		keyboard: true
		})
		$("#form11")[0].reset();
		var qid = $(this).attr("data");
		var remark = $(this).attr("remark");
		$("#modalContext").find("#qid").val(qid);
		if(remark!=""&&remark!=undefined){
			$("#modalContext").find("#context").val(remark);
		}
	})
	
	//生成分段内容
	function bulidContext(obj,context){
		if(context!=""&&context!=undefined){
			var ht = "<div class='alert alert-warning col-lg-12'><h4></h4><p> ";
			ht+="<label>";
	      	ht+=context  ;
	        ht+="</label></p></div>";
			$(obj).parents(".guding").before(ht);
		}
	}
	
	$("#addQuesttion").click(function(){
		$("#aid").val(aid);
		showSysModal();
	});
		
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
                  
            </div>  
                 <div class="col-lg-11" style="margin-bottom: 5px">
                       	<button class="btn tn-sm btn-danger" id="addQuesttion">添加题目</button> 
						<button type="button" class="btn btn-sm btn-default" id="back" name="back" onclick="history.go(-1)">返回</button>                       	
                       	<br/> 
                 </div>				
				<!-- 主题内容 -->
				<div class="context panel panel-body">

	                 
	            
	                 <!-- 蓝色框框 panel panel-primary -->
 				<!--
				<div class="col-lg-12" id="1">               
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                        	1.问卷题目一
	                        </div>
	                        <div class="panel-body">
	                            <p><div class="col-lg-8">
									<div class="radio">
                                       <label>
                                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Radio 1
                                       </label>
                                    </div>	                            	
									<div class="radio">
                                       <label>
                                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Radio 2
                                       </label>
                                    </div>
                                    <div class="radio">
                                       <label>
                                          <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Radio 2
                                       </label>
                                    </div>                                    
                                      	                            
	                            	
	                            	</div>
	                            	<div class="col-lg-2 col-md-offset-2">
	                            		<div class="panel-body">
		                            	    <button data-toggle="collapse" data-parent="#accordion" href="#collapse1" class="btn btn-primary btn-circle" title="点击可在下方编辑"  ><i class="fa fa-list"></i></button>
	                            			<button class="btn btn-warning btn-circle" href="#collapseTwo"><i class="fa fa-times"></i></button>
		                            	</div>
	                            	</div> 
	                            </p>
	                        </div>
							 <div class="panel-footer">
			                    <div class="panel panel-info q_edit">
			                        <div class="panel-body">
				                        <div class="col-lg-2">
				                        	<label class="control-label">标题：</label>
				                        	<input class="form-control" id="">
				                        </div>
				                        <div class="col-lg-3">
				                        	<label class="control-label">选项：</label>
				                        	<div class="form-group input-group"><input type="text" class="form-control" id="" name=""><span class="input-group-addon"><a href="#"><i class="fa fa-plus-circle"></i></a>&nbsp;&nbsp;<a href="#"><i class="fa fa-minus-circle"></i></a></span></div>
				                        	<div class="form-group input-group"><input type="text" class="form-control" id="" name=""><span class="input-group-addon"><a href="#"><i class="fa fa-plus-circle"></i></a>&nbsp;&nbsp;<a href="#"><i class="fa fa-minus-circle"></i></a></span></div>
				                        	<div class="form-group input-group"><input type="text" class="form-control" id="" name=""><span class="input-group-addon"><a href="#"><i class="fa fa-plus-circle"></i></a>&nbsp;&nbsp;<a href="#"><i class="fa fa-minus-circle"></i></a></span></div>
				                        </div>
	                            	<div class="col-lg-2 col-md-offset-2">
	                            		<div class="panel-body">
		                            	    <button data-toggle="collapse" data-parent="#accordion" href="#collapse1" class="btn btn-info btn-circle btn-lg" title="保存"  ><i class="fa fa-check"></i></button>
	                            			<button data-toggle="collapse" data-parent="#accordion" href="#collaps"   class="btn btn-warning btn-circle btn-lg" title="关闭"><i class="fa fa-bitbucket"></i></button>
		                            	</div>
	                            	</div> 

			                        				                       			                            
			                        </div>

			                    </div>
                    									
					         </div>	 	                        
	                    </div>
			 </div>
				 -->

				
               </div>             
  </div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->    
<!-- 模态框（Modal）题目生成 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	生成
            </h4>
         </div>
         <div class="modal-body">
             <div class="alert alert-danger alert-dismissable tishi" style="display: none">
                 <p></p>
             </div>
			 <form name="form10" id="form10">
					 <input type="hidden"  name="aid" id="aid" value=""/>
					 <input type="hidden"  name="qid" id="qid" value=""/>
					 <input type="hidden"  name="qtype" id="qtype" value="1"/>
					 <input type="hidden"  name="orderid" id="orderid" value="0"/>
					 <div>
					 <h5> 自动创建单选题，新增到现在题目后面。</h5>
					 </div>
					<label>标题： </label>
					<textarea class="form-control" rows="10" name="qname" id="qname"></textarea>
					<label>选项(一个选项一行)： </label>
                    <textarea class="form-control" rows="10" name="options" id="options"></textarea>
         </div>
         <div class="modal-footer">
            <a onclick="doModalEdit()"><button type="button" class="btn btn-primary">生成</button></a>
         </div>
         </form> 
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->    

<!-- 模态框（Modal）分段内容生成 -->
<div class="modal" id="modalContext" tabindex="-1" role="dialog"
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	分段内容
            </h4>
         </div>
         <div class="modal-body">
             <div class="alert alert-danger alert-dismissable tishi" style="display: none">
                 <p></p>
             </div>
			 <form name="form11" id="form11">
					 <input type="hidden"  name="qid" id="qid" value=""/>
					 <div>
					 <h5> </h5>
					 </div>
					<label>题目类别 </label>
					<textarea class="form-control" rows="10" name="context" id="context"></textarea>
					
         </div>
         <div class="modal-footer">
            <a onclick="doBulidContext()" ><button type="button" class="btn btn-primary">生成</button></a>
         </div>
         </form> 
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal --> 

  </body>
</html>
