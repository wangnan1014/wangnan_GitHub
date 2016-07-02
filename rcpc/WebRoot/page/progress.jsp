<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.heag.rcpc.util.ConstantsUtil"%>
<% 
  String aid = request.getParameter("aid");
  String atilte =   request.getParameter("atilte");
%>
<!DOCTYPE html>
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
   <script src="../js/nicEdit.js"></script>
</head>

<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-11">
                    <h1 class="page-header">问卷进度</h1>
                </div>
			</div>
			<div class="panel panel-primary">

				
         	    <div class="panel-body">
	      			<div class="col-lg-12">
	                    <table class="table table-striped table-bordered table-hover " id="sendInvitationTable" >
	                       <thead>
	                            <tr>
	                                <th><input type="checkbox" id="check_all"/></th>
	                                <th>评估人Email</th>
	                                <th>评估人姓名</th>
	                                <th>评估关系</th>
	                                <th>邮件状态</th>
	                                <th>邮件发送时间</th>
	                                <th>完成状态</th>
	                                <th>完成时间</th>
	                                <th>操作</th>
	                            </tr>
	                        </thead>  
                       
	                        <tbody id="peopleDetails" >
	                        
	                        </tbody>  
                   	    </table><!-- /.table-responsive -->
               		 </div><!-- /.col-lg-12 -->
            	 </div><!-- pannel body -->
             <!--    与其他页面风格一致 -->
			<div class="modal-footer" >
	            
	         </div>
	         
	      </div><!-- /.modal-content -->
	   </div><!-- /.page-wrapper -->
	</div><!-- /.wrapper -->  
	
		<!-- 模态框（Modal） 发送时确认-->
		<div class="modal fade" id="mySendModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal"
		               aria-hidden="true">×
		            </button>
		            <h4 class="modal-title" id="myModalLabel">
		    		         <b>  发送邀请邮件</b>
		            </h4>
		         </div>
		         <div class="modal-body">
					 <form name="form11" id="form11">
						<input type="hidden"  name="aid" id="aid" value="<%=aid%>"/>
						<input type="hidden" name="checkId" id="checkId" value=""/>
						<input type="hidden"  name="id" id="id" value=""/> 
						<input type="hidden"  name="eid" id="eid" value=""/> 
						<input type="hidden"  name="sendEmail" id="sendEmail" value=""/>
						<input type="hidden"  name="dataEname" id="dataEname" value=""/> 
						
						<label> 邮件标题 </label>
	                    <input class="form-control" placeholder="输入邮件标题"  name="mailname" id="mailname" value="请参与此次360评估"/>
	                    <label>邮件内容 </label>
	                    <textarea class="form-control" rows="9" cols="60" placeholder="输入邮件内容"  name="mailcontent" id="mailcontent" >	
	                    </textarea>
		         </div>
		         <div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
					<button type="button" class="btn btn-primary" onclick="doSend()">发送</button>
	        	 </div>
		       		 </form> 
		      </div><!-- /.modal-content -->
		   </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->  
		<!-- updateModal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			 <div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">被评估人信息</h4>
				</div>
				<form name="updateForm" id="updateForm">
				<div class="modal-body updateDiv" id="updateDiv">
					<label>被评估人Email : </label>
					<label class="bpgreEmail"></label><br/>
					<label >被评估人姓名  :</label>
                    <label class="bpgreName"></label> 
				</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- updateModal -->
	
</body>
<script type="text/javascript">
		
		//发送按钮
		function doSend(){
			 var context = nee.nicInstances[0].getContent();
			 var od = $("#mailcontent").val();
			 $("#mailcontent").val(context)
			 $.ajax({
				   type: 'POST', 
			  	   url:'../sendinvitations/sendinvitations!doSendPeople.action?id=${param.id}&rand='+Math.random(),
				   data:$("#form11").serialize(),// $("#peopleDetails").serialize(),
				   async:false,
				   success : function(data, textStatus) {  
				   	if(data.indexOf("0")>-1){
				   		alert("发送失败测试");
				   		$("#mySendModal").modal("hide");
				   		window.location.reload();
				   	}else{	   		
				   		alert("发送成功");
				   		$("#mySendModal").modal("hide"); 
				   		window.location.reload();
				   	}
			   }
			});		
		}
		
		//获取接收人数量
		function getSendPeople(){
			var tb = document.getElementById("table11");    //获取table对像
			var rows = tb.rows;
			var cells;
			var sendcheck = document.getElementByName("sendcheck");
			var sendnum = 0;
			for(var i=0;i<rows.length;i++){    //--循环所有的行
				var cells=rows[i].cells; 
				for(var j=0;j<cells.length;j++){   //--循环所有的列
					if(sendcheck.checked){
						sendnum += 1;
					}
				}
			} 
	        document.getElementById("sendnum").value = sendnum;
		}
		

		$(function(){
			initSendIn(); 
			//初始化
			function initSendIn(){
			     $.ajax({
					   type: 'GET', 
					   url:'../relation/relation!getPrograssDataList.action?aid='+${param.aid}+'&rand='+Math.random(),
					   async:false,                                               
					   success : function(data, textStatus) {  
					   	if(data==0){
					   		alert("数据初始化失败！")
					   	}else{
					   	
				   			var typeData = $.parseJSON(data).data;
					 		var trColor="";
					 		var emailstatus="";
					   		$.each(typeData,function(index,evaluater){
						   		if(index%2==0){
						   			trColor="even gradeX";
						   		}else{
						   			trColor="odd gradeX";
						   		}
						   		
						   		var ht = "<tr class='"+trColor+" trbody'>";
					   		    //大括号内已编辑 
					   		    if(evaluater.emailstatus==0){
					   		    	emailstatus="未处理";
					   		    	ht += "<td><input type='checkbox' name='check_list' value='"+evaluater.id+"' onclick='window.event.cancelBubble=true' eid='"+evaluater.eid+"' eename='"+evaluater.ename+"'/>";
					   		   }else if(evaluater.emailstatus==1){
					   		   		emailstatus="已发送";
					   		   		ht += "<td><input type='hidden'  name='check_list' value='"+evaluater.id+"' onclick='window.event.cancelBubble=true' eid='"+evaluater.eid+"' eename='"+evaluater.ename+"'/>";
					   		   }else if(evaluater.emailstatus==2){
					   		   		emailstatus="发送失败";
					   		   		ht += "<td><input type='checkbox' name='check_list' value='"+evaluater.id+"' onclick='window.event.cancelBubble=true' eid='"+evaluater.eid+"' eename='"+evaluater.ename+"'/>";
					   		   }
							   
								
								ht += "<input type='hidden' name='dataeid' id='dataeid' value='"+evaluater.eid+"'/></td>";
								ht += "<td>"+evaluater.email+"</td>";
		                        ht += "<td>"+evaluater.evaluator+"</td>";
		                        ht +=  "<td>"+evaluater.relation+"</td>";
		                        ht += "<td>"+emailstatus+"</td>";
		                        if(evaluater.emailSendtime==""|| evaluater.emailSendtime==undefined){
		                         ht += "<td></td>";
		                        }else{
		                         ht += "<td>"+evaluater.emailSendtime+"</td>";
		                        }
		                        var completestatus ="未完成";
		                        if(evaluater.completestatus=="1"){
		                        	completestatus ="已完成";
			                    }
		                        ht += "<td>"+completestatus+"</td>";
		                        if(evaluater.completetime==undefined)evaluater.completetime=""

		                        ht += "<td>"+evaluater.completetime+"</td>";
		                        ht += "<td>";
		                        ht += "<button type='button' class='btn btn-primary btn-circle' title='查看' ename='"+evaluater.ename+"' eemail='"+evaluater.email+"' id='updatepp' onclick='showEditeModal(this)'><i class='fa fa-list'></i></button>";
								//根据保密制度不应该可以看答案的
		                        //if(evaluater.completestatus=="1"){
		                        //	ht += "&nbsp;<button type='button' class='btn btn-danger btn-circle' title='详细' aid='"+evaluater.aid+"' eid='"+evaluater.eid+"' id='"+evaluater.id+"'ename='"+evaluater.ename+"'evaluator='"+evaluater.evaluator+"' onclick='viewDetail(this)'><i class='fa fa-eye'></i></button>"; 
		                        //}else{
		                        //	ht += "&nbsp;<button type='button' class='btn btn-default  btn-circle disabled' title='详细' disabled='true'><i class='fa fa-eye'></i></button>";
			                    //}

		                        ht += "&nbsp;<button type='button' class='btn  btn-success btn-circle' title='邮件发送' ename='"+evaluater.ename+"' eemail='"+evaluater.email+"' id='updatepp' onclick='sendEmail(this)'><i class='fa fa-envelope-o'></i></button>";
			          			ht += "</td></tr>";
								$("#sendInvitationTable tbody").append(ht); 
							})
						}
				     }
				     
				});	
				//表格分页代码，需导入css
				$('#sendInvitationTable').DataTable({
	                "responsive": true,
	                "bAutoWidth":true,
	                "sPaginationType": "full_numbers", //分页显示类型  
	                "aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, 1000]],//分页b  下拉框的自定义  
	                "aoColumnDefs":[{"bSortable": false,"aTargets": [0]}],//第一列不排序
	                "oLanguage": {"sUrl": "../js/pipelining.txt"}
	        	});
	    	}
			
			//全选联动
	    	$("#check_all").click(function(){
        	//实现全选
            	$("input[name='check_list']").prop("checked",$(this).prop("checked"));
	        });
			//取消全选
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
	    	//全选联动
	    	

		});

	   //查看弹出  
	   function showEditeModal(obj){
		   var ename = $(obj).attr("ename");
		   var eemail = $(obj).attr("eemail");
		   $("#updateForm").find(".bpgreName").text(ename);
		   $("#updateForm").find(".bpgreEmail").text(eemail);
		   $("#updateModal").modal({keyboard: true});	
		}
	    function  sendEmail(obj){
	    	showSendModal(obj)
	    }
	    var nee = null;
		//发送弹出
		function showSendModal(obj){
			var htl = "评估试卷题目: <%=atilte%> , ";
			var checkId = $(obj).parents("tr").find("td").find("input[name='check_list']").val();
			var sendEmail = $(obj).parents("tr").find("td:eq(1)").text();
			var checkEid = $(obj).parents("tr").find("input[name='check_list']").attr("eid");
			var checkEname = $(obj).parents("tr").find("input[name='check_list']").attr("eename");;
			var checkArr = $("input[name='check_list']:checked");

    		htl += "被评估人姓名：{被评估人姓名} ，  " ;
    		htl += "链接地址：{链接地址} ，  ";
			htl += "如有疑问，请和人力资源部门联系。"
			$('#mailcontent').text(htl);
    		//alert(checkEname);
			if(checkId!=""&&sendEmail!=""){

			}else{
				alert("请选择要发送的对象");
				return;
			}
			$("#sendEmail").val(sendEmail);
			$("#checkId").val(checkId);
			//var dataeid= document.getElementById("dataeid").value;
			//alert(dataeid);
			$("#eid").val(checkEid);
			$("#dataEname").val(checkEname);
			$('#mySendModal').modal({
		  		keyboard: true
			})
			if(nee==null){
				nee= new nicEditor({buttonList:['fontFamily','fontSize','bold','italic','underline','link','unlink','forecolor','left','center','right'],iconsPath : '../images/nicEditorIcons.gif'}).panelInstance('mailcontent');
			}
			
		}

        //问卷道题详情
		function viewDetail(obj){
			var aid = $(obj).attr("aid");
			var eid = $(obj).attr("eid");
			var id = $(obj).attr("id");
			var ename = $(obj).attr("ename");
			var evaluator =$(obj).attr("evaluator");
		
			window.open("personAnswers.jsp?aid="+aid+"&eid="+eid+"&id="+id+"&ename="+escape(escape(ename))+"&evaluator="+escape(escape(evaluator)));
			//window.location.href("personAnswers.jsp?aid="+aid+"&eid="+eid+"&id="+id);
			//url:'../pcresult/pcresult!getPersonAnswer.action?rand='+Math.random(),
			 
		}
		
   	</script>

</html>

