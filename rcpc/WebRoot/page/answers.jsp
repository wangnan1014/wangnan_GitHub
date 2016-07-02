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

  <link href="../css/bootstrap.min.css" rel="stylesheet">

  <link href="../css/metisMenu.min.css" rel="stylesheet">


  <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <script src="../js/jquery.min.js"></script>

  <script src="../js/bootstrap.min.js"></script>

  <script src="../js/metisMenu.min.js"></script>

  <script src="../js/jquery.validate.js"></script>
<style type="text/css">
.required{required:true}
</style>
  
<script type="text/javascript">
var aid = getQueryString('aid');
var eid = getQueryString('eid');
var id = getQueryString('id');
//var evaluator = getQueryString('evaluator');
var evaluator = "";

function getQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
$(function(){
	initHtml();
	//url:"../evaluateAction/evaluateAction!getEname.action?aid="+eid+"&rand="+Math.random(),
	
	//通过Spring MVC的方式得到ename
	//$.ajax({
	//	type:'POST',
	//	url:"../eva/getEname/"+eid,
	//	async:false,
	//	success:function(data,textStatus){
			//evaluator = data;
			//$("#ename").html(data)
	//	}
	//})

	
	function initHtml(){
		$.ajax({
			type:'POST',
			url:"../questionnaire/questionnaire!getAskinfoAndQuestionAndOption.action?aid="+aid+"&rand="+Math.random(),
			async:false,
			success:function(data,textStatus){
				if(data==0){
					alert("您没有权限,数据初始化失败！")
				}else{
					var datas= $.parseJSON(data).data[0];
					//$.each(datas,function(index,arr){
						var adescribe = datas.adescribe;
						var aid = datas.aid;
			            var atitle = datas.atitle;
			            var createdate = datas.createdate;
			            var isdelete = datas.isdelete;
			            var uname = datas.uname;
			            $(".atitle").html("<h4 calss='h3_atitle'>"+atitle+"</h4>");
			            $(".atitle").next().find("p").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+datas.adescribe);
			            var ht="";
			            ht+="<input type='hidden' name='aid' id='aid' value='"+aid+"'>";
			            ht+="<input type='hidden' name='eid' id='eid' value='"+eid+"'>";
			            ht+="<input type='hidden' name='id' id='id' value='"+id+"'>";
			            ht+="<input type='hidden' name='evaluator' id='evaluator' value='"+evaluator+"'>";

			            $.each(datas.pcQuestion,function(q,arrQ){//题目信息
			            	var qid = arrQ.qid;
			            	var qname = arrQ.qname;
			            	var qtype = arrQ.qtype;	
			            	ht+="<div class='cc"+aid+" dd "+qid+"'>";
			            	ht+="<p><H5>"+eval(q+1)+"."+qname+"</H5></p><p><font class ='err' color='red'></font></p>";
			            	ht+="<input type='hidden' name='qid' id='qid' value='"+qid+"'>";
							
			            	if(qtype=="1"){//单选
				            	$.each(arrQ.pcOptions,function(o,arrO){//选项信息
				            		var oid = arrO.oid;
				            		var ooption = arrO.ooption;
				            		ht+="<div class='radio'> <label style='word-wrap: break-word; word-break: normal'>";
				            		if(o==0){
				            			ht+="&nbsp;&nbsp;<input type='radio' class='required' name='qid_"+ qid +"' id='oid_"+oid+"' value='"+oid+"'><label for='oid_"+oid+"'>"+ooption+"</label>";
				            		}else{
				            			ht+="&nbsp;&nbsp;<input type='radio' name='qid_"+ qid +"' id='oid_"+oid+"' value='"+oid+"'><label for='oid_"+oid+"'>"+ooption+"</label>";
					            	}
					                ht+="</label></div>";	
					                           				            		
					            })
			            	}else if(qtype="0"){//文本框
								
				            }
				            ht+="<hr/>";
			            	ht+="</div>";  
				        })
				        $(".dati").append(ht);
			            initEname();
			            initContext()
				        $("#upAnswers").validate({
				        	submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form
					    		if(<%=request.getParameter("hasRoot")%>){
					    			$.ajax({
					    				type:"GET",
					    				url:"../questionnaire/questionnaire!doAskInfo.action?&rand="+Math.random(),
					    				data:$("#upAnswers").serialize(),
					    				async:false,
					    				success:function(data,textStatus){
					    					if(data==0){
					    						alert("提交失败!");
					    					}else if(data==2){
					    						alert("你已经答过题，不能再提交");
					    						//window.close();
					    					}else{
					    						alert("提交成功!");
					    						//window.close();
						    				}
					    				}
					    				})
					    		}else{
					    			alert("对不起，你没有权限提交");
					    		}				        	
				        	
				        	},
				        	errorPlacement: function(error, element) {  
				    			if ( element.is(":radio") ){  
					    			error.appendTo( element.parents(".dd").find(".err") );
						    	}	
				    		},
				    		
					     });
				        
					//})
				}
				
			}
		})
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
		   		        $(".cc"+arr.aid+"."+arr.qid).before(ht);
					})
				}
			}
		})
	}
	
	function initEname(){
		if(!eid==""){
		$.ajax({
			type:'GET',
			url:"../evaluate/evaluate!getEname.action?eid="+eid+"&rand="+Math.random(),
			async:false,
			success:function(data,textStatus){
				if(data!=""){
					//alert("成功");
					//$("h3").after("&nbsp;被评估人："+data);
					$("#ename").html(data)
				}else{
					alert("被评测人名字获取失败");
				}
			}
		})
		}else{
			if(<%=request.getParameter("hasRoot")%>){
				alert("加载被评测人信息不能为空");
			}
		}

	}

		
	$("#doUp").click(function(){
	// 在表单验证 validate
	
	})
})

</script>

</head>

<body>

  <div id="page-wrapper">
  	<div class="col-lg-12">
  		<div class="col-lg-2" ></div>
  		<div class="col-lg-8" ><a class="navbar-brand" style="color:#000" href="/loginMain.action"><img src="../images/logo.jpg" /></a> 
  		</div>
  		<div class="col-lg-2" ></div>
                   
    </div>
  	 <div class="col-lg-12" >
  	 <div class="col-lg-2" ></div>
       <div class="col-lg-8" >
           <div class="panel panel-primary">
               
               		<div class="panel-heading atitle">
                   		<h4>360度问卷名称</h4>
               		</div>
                    <div class="well">
                        <h4></h4>
                        <font style="font-family:微软雅黑"><p></p></font>
                        
                    </div>               
               <form id="upAnswers" >
               <div align="left" style="margin-left: 20px"><strong>被评估人：</strong><font style="" id="ename"></font></div>
               <div class="panel-body dati" >
               			<!--
	                     <div class="cc1">
		                   <p>题目1</p>
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
				            <hr/>
	        		    </div>	
	    		            -->		    
	        		    
	               </div>
	               <div class="panel-footer">
	                         <button class="btn btn-warning btn-circle " id="doUp" name="doUp">提交</button>
	               </div>
               </form>
           </div>
       </div>  
       <div class="col-lg-2" ></div>
      </div>        
  </div>
<!-- /#page-wrapper -->


  
  </body>
</html>