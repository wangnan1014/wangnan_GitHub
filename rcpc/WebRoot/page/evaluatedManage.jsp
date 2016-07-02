<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.heag.rcpc.util.ConstantsUtil"%>
<% 
  String aid = request.getParameter("aid");
  //System.out.println("jsp:aid======================="+aid);
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>评估名单---管理被评估人名单</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../css/metisMenu.min.css" rel="stylesheet">
    
    <!-- Social Buttons CSS -->
    <link href="../css/bootstrap-social.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="../css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../css/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery -->
  <script src="../js/jquery.min.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="../js/bootstrap.min.js"></script>

  <!-- Metis Menu Plugin JavaScript -->
  <script src="../js/metisMenu.min.js"></script>
  <script  src="../js/jquery.dataTables.min.js"></script>
 
  <script src="../js/dataTables.bootstrap.min.js"></script>
  
   <script src="../js/sb-admin-2.js"></script>

</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-11">
                    <h1 class="page-header">被评估名单管理</h1>
                </div>
			</div>   
            <div class="panel panel-primary">
				<div class="panel-heading">
					<button type="button" class="btn btn-warning" id="add" name="add" onclick="showAdd()"><i class="fa fa-plus">增加</i></button>
					<button type="button" class="btn btn-success" id="view" name="view"><i class="fa fa-pencil">编辑</i></button>
					<button type="button" class="btn btn-info" id="del" name="del" ><i class="fa fa-trash-o">刪除</i></button>
              	</div>
				<div class="panel-body">
					<div class="col-lg-12">
						<table class="table table-striped table-bordered table-hover" id="evaluateTables">
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="check_all"></th>
                                    <th>部门</th>
                                    <th>Email</th>
                                    <th>姓名</th>
                                    <th>评估人数</th>
                                    <th>完成人数</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody id="tbodyDetails">
                                <!--tr class="odd gradeX">
                                    <td>信息管理部</td>
                                    <td>test@heag.com</td>
                                    <td>test</td>
                                    <td >4</td>
                                    <td >2</td>
                                    <td><button onclick="showModal()">编辑关系</button></td>
                                </tr-->
                            </tbody>
                        </table>
                   
                    <!-- /.table-responsive -->
                      </div>
                       <!-- /.col-lg-12 -->                  
                                                                                                       
              </div>
             <!--    与其他页面风格一致 -->
              <div class="panel-footer">
                                                               
              </div>
              
             </div>
		</div>
	</div>
	

<!-- addModal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			 <div class="modal-content">
			 
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加记录</h4>
				</div>
				
				<div class="modal-body">
					<form name="addForm" id="addForm">
					    <div class="alert alert-danger alert-dismissable" id="addInfo" style="display: none">
                			<p></p>
            			</div>
					    <input type="hidden" name="aid" id="aid" value=${param.aid} />
					            姓名:<font color='red'>*</font><input class="form-control  required" hint="请填写被评估人姓名！" placeholder="输入姓名"  name="ename" id="ename" value=""/>
					            部门:<font color='red'>*</font><input class="form-control required" hint="请填写被评估人部门！" placeholder="输入部门"  name="dname" id="dname" value=""/>
					            邮箱:<font color='red'>*</font><input class="form-control required email"  hint="请填写被评估人邮箱！" placeholder="输入邮箱"  name="email" id="email" value=""/>
					           备注:<input class="form-control" placeholder="输入备注"  name="remark" id="remark" value=""/>
						
					</form>
				</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<a onclick="doModalEdit();"><button type="button" class="btn btn-primary">提交</button></a>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- addModal -->
	
	
	<!-- updateModal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			 <div class="modal-content">
			 
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改记录</h4>
				</div>
				<form name="updateForm" id="updateForm">
				<div class="alert alert-danger alert-dismissable" id="updateInfo" style="display: none">
                		<p></p>
            	</div>
				<div class="modal-body" id="updateDiv">
					
					
				</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="update" name="update">修改</button>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- updateModal -->
</body>




 <!-- Custom Theme JavaScript -->
    <script src="../js/menu.js"></script>
    <script src="../js/jquery.form.js"></script>
    <script src="../js/formCheck.js"></script>
    <!-- script src="../js/jquery.validate.min.js"></script -->
    <!--script src="../js/jquery.validate.js"></script-->
    
    
    <script type="text/javascript">

    $(function(){
    	initTable();

    	/*表格初始化*/
    	function initTable() {
    		$.ajax({
        		type:'get',
            	url:'../evaluate/evaluate!getDataList.action?aid='+${param.aid}+'&rand='+Math.random(),
            	async:false,
            	success : function(data, textStatus) {  
				   	if(data==0){alert("数据初始化失败！")}
				   	else{ 
				 		var typeData = $.parseJSON(data).data;
				 		var trColor="";
				 		$.each(typeData,function(index,evaluater){
					 		//alert(textStatus);
					 		if(index%2==0){trColor="even gradeX";}
					 		else{trColor="odd gradeX";}
					 		var num=(null==evaluater.num)?0:evaluater.num;
					 		var completenum=(null==evaluater.completenum)?0:evaluater.completenum;
					 		var ht="<tr class='"+trColor+" trbody'>";
					 		ht+="<td><input type='checkbox' name='check_list' value='"+evaluater.eid+"' onclick='window.event.cancelBubble=true'></td>";
					 		ht+="<td>"+evaluater.dname+"</td>";
					 		ht+="<td>"+evaluater.email+"</td>";
					 		ht+="<td>"+evaluater.ename+"</td>";
					 		ht+="<td>"+num+"</td>";
					 		ht+="<td>"+completenum+"</td>";
					 		ht+="<td><a href='evaluateRelation.jsp?aid="+${param.aid}+"&eid="+evaluater.eid+"&ename="+escape(escape(evaluater.ename))+"'>编辑关系</a>"
					 	    if(completenum!="0"){
							ht+="&nbsp;&nbsp;<a href='../collect/collect!collectToExcel.action?aid="+${param.aid}+"&eid="+evaluater.eid+"&isBCollect=1' ><i class='fa fa-user fa-fw'></i>按类别</a>";
	                        ht+="&nbsp;&nbsp;<a href='../collect/collect!collectToExcel.action?aid="+${param.aid}+"&eid="+evaluater.eid+"&isBCollect=0'><i class='fa fa-gear fa-fw'></i>按题目</a>";
					 	    }		
					 		ht+="</td>";

					 		ht+="</tr>";
					 		//alert(ht);
					 		$("#evaluateTables tbody").append(ht);
					   });
				 		
        	        }/*else結束*/
                }/*success結束*/
             });/*ajax結束*/
        	$('#evaluateTables').DataTable({
                "responsive": true,
                "bAutoWidth":true,
                "sPaginationType": "full_numbers", //分页显示类型  
                "aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, 1000]],//分页b  下拉框的自定义  
                "aoColumnDefs":[{"bSortable": false,"aTargets": [0]}],//第一列不排序
                "oLanguage": {"sUrl": "../js/pipelining.txt"}
		            
        	});
    	}
		

    	$("#check_all").click(function(){
        	//alert($(this).prop("checked"));
            $("input[name='check_list']").prop("checked",$(this).prop("checked"));
        });

    	$(".trbody").click(function(){
        	var objChecked=$(this).find("input[name='check_list']");
        	if(objChecked.prop("checked")){
            	 objChecked.prop("checked",false); 
        	     $("#check_all").prop("checked",false);
        	}
        	else{
            	objChecked.prop("checked",true);
            }
    		
    	});
    	

    	$('#view').click(function(){
    		var num=0;
    		$("input[name='check_list']:checked").each(function(){ 
        	    num+=1;
        	    if(num>2){
        	    	alert("只能选择一条信息修改");	
        	    	return;
            	}
        	    viewShow($(this).parents("tr"),$(this).val());
    		}); 
    		if(num==0){
    	    	alert("请选择一条信息进行修改");	
    	    	return;
        	}
        	
        });
    	$('#update').click(function(){
        	if(check('updateForm',$('#updateInfo'))){
    			$.ajax({
    				type:'post',
            		url:'../evaluate/evaluate!updateEvaluateById.action?rand='+Math.random(),
            		data: $("#updateForm").serialize(),
            		async : false,
               		success : function(result) {  
    				 		
						alert("修改成功");
						//alert(result);
						$("#updateModal").modal("hide"); 
						window.location.reload();
                   
		   			 
	        		}, 					
                	error : function(result) {
                		alert('修改失败，请联系相关人员！');
               		}

    		
            	});
        	}

        });

    	$('#del').click( function () {
        	 /*var arr=new Array();
        	 var n=0;*/
        	 var delIdStr="";
    		 var checkArr=$("input[name='check_list']:checked");
    		 $(checkArr).each(function(){
    		    	delIdStr+= this.value;
    		    	delIdStr+=",";  
    		    	/*arr[n]=$(this).parents("tr").index();  // 获取checkbox所在行的顺序    
    		    	n+=1;*/
    		    	     
    		  }); 
			 if(delIdStr!=""){
				delIdStr=delIdStr.substring(0,delIdStr.length-1);
				if(confirm("你确信要删除数据？"))
				{	
 					$.ajax({
 					url:'../evaluate/evaluate!delEvaluate.action?delIdStr='+delIdStr+'&?rand='+Math.random(),
	                data:{"delIdStr":delIdStr},
	                type : 'post',
	                async : false,
	                success : function(result) {
	                	/*$.each(arr,function(n,value){
	                	    //$("#evaluateTables").find("tr:eq("+value+")").remove();
		                	$("#evaluateTables tr:eq("+(value-n+1)+")").remove();
	                	});*/
	                	alert('删除成功');	
	                	window.location.reload();	
	        
	                }, 					
	                error : function(msg) {
	                	alert('删除失败，请联系相关人员！');
	                }
 					})
				}else{
					
				}
			}else{
				alert("请选中要删除项");
			}	
		});

    	
    });

    /*function selCheck(obj){
        //alert($(obj).prop("checked"));
    	if(!$(obj).prop("checked")){
        	$("#check_all").prop("checked",false);
    	}

    }*/

    
    function showAdd(){
    	$("#addModal").modal({keyboard: true});	
	}
	/*function showUpdate(){
		$("#updateModal").modal({keyboard: true});	
	}*/
	function showModal(){
		$('#relationModal').modal({keyboard: true});	
	}

	function doModalEdit(){
		if(check('addForm',$('#addInfo'))){
	     	$.ajax({
			   	type: 'post', 
			    //url:'../evaluate/evaluate!getDataList.action',
		  	    url:'../evaluate/evaluate!addEvaluate.action?rand='+Math.random(),
			    data: $("#addForm").serialize(),
			    async:false,
			    success : function(data, textStatus) { 
			   		if(data==0){alert("添加失败！");}
			   		else if(data==1){	   		
						alert("添加成功");
						$('#addModal').modal('hide');
						window.location.reload();
			   		}else{alert(data);}
		     	}
		    });
	     }/*if結束*/	
	     	    	
	 }
	function viewShow(objTr,eid){
		$("#updateDiv").empty();
		var arr=$(objTr).find("td");
		var htl="<input type='hidden' name='eid' id='eid' value='"+$(arr[0]).find('input').val()+"'/>";
		htl+="部门:<input class='form-control required' hint='请填写被评估人部门！' name='dname' id='dname' value='"+$(arr[1]).html()+"'/>";
		htl+="邮箱:<input class='form-control required email' hint='请填写被评估人邮箱！' name='email' id='email' value='"+$(arr[2]).html()+"'/>";
		htl+="姓名:<input class='form-control required' hint='请填写被评估人姓名！' name='ename' id='ename' value='"+$(arr[3]).html()+"'/>";
		//html+="备注:<input class='form-control' placeholder='输入备注'  name='remark' id='remark' value='"+$(arr[0]).html()+"'/>";
		
		//alert($(arr[1]).html());
		//alert(htl);
		$("#updateDiv").append(htl);
		$("#updateModal").modal({keyboard: true});	
	}
   	</script>
   	
</html>

