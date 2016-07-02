<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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
var ename = unescape(unescape(getQueryString('ename')));
var evaluator = unescape(unescape(getQueryString('evaluator')));
function getQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
$(function(){
	initHtml();
	function initHtml(){
		$.ajax({
			type:'GET',
			url:"../pcresult/pcresult!getPersonAnswer.action?aid="+aid+"&eid="+eid+"&id="+id+"&rand="+Math.random(),
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
			            $(".atitle").html("<h3 calss='h3_atitle'>"+atitle+"</h3>");
			            $(".atitle").next().find("p").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+datas.adescribe);
			            var ht="";

			            $.each(datas.pcQuestion,function(q,arrQ){//题目信息
			            	var qid = arrQ.qid;
			            	var qname = arrQ.qname;
			            	var qtype = arrQ.qtype;	
			            	ht+="<div class='cc"+aid+" dd "+qid+"'>";
			            	ht+="<p><H4>"+eval(q+1)+"."+qname+"</H4></p><p><font class ='err' color='red'></font></p>";
			            	ht+="<input type='hidden' name='qid' id='qid' value='"+qid+"'>";
							
			            	if(qtype=="1"){//单选
				        
				            	$.each(arrQ.pcOptions,function(o,arrO){//选项信息
					            
				            		var oid = arrO.oid;
				            		var ooption = arrO.ooption;
				            		var orresult = arrO.optionResult;
				            		//alert('oid='+oid+"   orresult="+orresult);
				            		ht+="<div class='radio'> <label style='word-wrap: break-word; word-break: normal'>";
				            		if(oid==orresult){
				            			ht+="&nbsp;&nbsp;<input type='radio' checked='checked'><label for='oid_"+oid+"'>"+ooption+"</label>";
				            		}else{
				            			ht+="&nbsp;&nbsp;<input type='radio' disabled='true'><label for='oid_"+oid+"'>"+ooption+"</label>";
					            	}
					                ht+="</label></div>";	
					                           				            		
					            })
			            	}else if(qtype="0"){//文本框
								
				            }
				            ht+="<hr/>";
			            	ht+="</div>";  
				        })
				        $(".dati").append(ht);
			            $("h3").after("&nbsp;评估人："+evaluator+"&nbsp;&nbsp;&nbsp;&nbsp;被评估人："+ename);
			            initContext();
			 
				        
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
	

	 
})

</script>

</head>

<body>

  <div id="page-wrapper">
  	<div class="col-lg-12">
  		<div class="col-lg-3" ></div>
  		<div class="col-lg-6" > <h4 class="page-header"></h4></div>
  		<div class="col-lg-3" ></div>
                   
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
                        <p></p>
                        
                    </div>               
               <div class="panel-body dati" >
               			 
	        		    
	               </div>
	              
           </div>
       </div>  
       <div class="col-lg-2" ></div>
      </div>        
  </div>
<!-- /#page-wrapper -->


  
  </body>
</html>
