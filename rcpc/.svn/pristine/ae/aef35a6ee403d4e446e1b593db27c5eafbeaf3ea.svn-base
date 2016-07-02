<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.heag.rcpc.util.DateUtil" %>
<%@ page import="com.heag.rcpc.model.RpUser"%>
<%@ page import="com.heag.rcpc.util.ConstantsUtil"%>

<%	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String date = dateFormat.format(new Date());
	String startDate = DateUtil.getMinMonthDate(date);
	String endDate = DateUtil.getMaxMonthDate(date);
	RpUser user = (RpUser)session.getAttribute("user");
 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>营销数据列表</title>
<link rel="stylesheet" href="../css/datatables/jquery.dataTables.css" type="text/css"></link>

</head>
<body>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">合同列表</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
					<!-- 
                    <div class="panel panel-default">
                     -->
                    <div class="panel-default">
                        <div class="panel-heading">
							<!-- 
                            <button type="button" class="btn btn-primary" id="mod" name="mod">修改</button>
                            <buttn type="button" class="btn btn-primary" id="see" name="see">查看</button>
                            --> 
                            <form>
							        工程名:<input type="text" name="projectname"/>
							        合同编号(外):<input type="text" name="oContractid"/>
							        合同签订日期：<input name="signdate_startDate" id="signdate_startDate" value="<%=startDate%>"/> 至  <input name="signdate_endDate" id="signdate_endDate" value="<%=endDate%>"/>
							   <button type="button" class="btn btn-primary btn-sm" id="query" name="query">查看</button>
  							 </form>
                                                                               
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                               
                                <table class="table table-striped table-bordered table-hover" width="100%" id="dataTables-example" >
                                    <thead>
                                        <tr>
                                        	<!--全选<th> <input type="checkbox" id="pidCheck" name="pidCheck" value="-1" /> 序号</th>  -->
                                            <th>编号</th>
                                            <th>合同编号(外)</th>
                                            <th>工程名称</th>
                                            <th>客户名称</th>
                                            <th>片区</th>
                                            <th>省份</th>
                                            <th>行业类别</th>
                                            <th>销售渠道</th>
                                            <th>事业部</th>
                                            <th>合同状态</th>
                                             <!-- 
                                            <th>是否开票</th>
                                             -->
                                            <th>合同签订日期</th>
                                           
                                            <th>操作</th>
                                            
                                        </tr>
                                    </thead>
									<tfoot>
									<div class="row col-lg-12">
			                             <%if(user.getRoleid().equals(4)||user.getRoleid().equals(1)){%>
			                            <button type="button" class="btn btn-sm btn-primary" id="add" name="add">新增</button>
										<%} %>
									    <%if(user.getRoleid().equals(1)){%>
										<button type="button" class="btn btn-primary btn-sm" id="del" name="del">删除</button> 
										<%} %>
									</div>
									</tfoot>
                                </table>
                                
                            </div>
                            <!-- /.table-responsive -->

                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

    <!-- DataTables JavaScript -->
	<script  src="../js/jquery.dataTables.min.js"></script>
    <script src="../js/dataTables.bootstrap.min.js"></script>
    <script src="../js/pipelining.js"></script>   
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
    
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
	    var table = null;
		//查看
		function view(o){
			var pid = $('td:eq(0)',o).text();//序号
			//查看
				var d ="pid=" + $.trim(pid) + "&actionName=view";
				setDiv("../project/goto.action?gotoPage=/page/projectTable.jsp?rand="+Math.random() + "&" +d,0);
		}
		function clickView(pid){
			//查看
			var d ="pid=" + $.trim(pid) + "&actionName=view";
			setDiv("../project/goto.action?gotoPage=/page/projectTable.jsp?rand="+Math.random() + "&" +d,0);
		}
	    $(document).ready(function() {
				  $("#signdate_startDate,#signdate_endDate").bind("click", function () {
				  	var obj = $(this); 
				  	if(obj.attr("id")=="signdate_startDate"){
				  		//WdatePicker({dateFmt:"yyyy-MM-dd",maxDate:"$dp.$D('signdate_endDate',{d:+30})"});
				  		WdatePicker({dateFmt:"yyyy-MM-dd"});
				  	}else if(obj.attr("id")=="signdate_endDate"){
				  		WdatePicker({dateFmt:"yyyy-MM-dd"});
				  	}
				  })    
			       $("#query").click(function() {
			        //$("#dataTables-example").dataTable().fnClearTable();
			        initTable();
			   	   });
			   		initTable();
			   		
			 		function initTable() {
						var paras = $("form").serialize();
			    		table = $('#dataTables-example').DataTable( {
						"bProcessing":true,	//开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好	    
						"bServerSide": true,//开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。--一般不开 开了 都要自己设置
				        "bAutoWidth":true,
				        "sPaginationType": "full_numbers",
				        "bFilter": false,//去掉搜索框
				        "bDestroy" : true,
				        "ajax": $.fn.dataTable.pipeline( {
				            url: "../project/project!getDataList.action?rand="+Math.random() + "&" + paras,
							method:"POST",
				        } ), 				        
						"columns": [
							{ data: 'pid' },//隐藏 可在后面添加 "visible": false 逗号隔开
							{ data: 'oContractid' },
							{ data: 'projectname' },
							{ data: 'custname' },
							{ data: 'region' },
							{ data: 'province' },
							{ data: 'itypename' },
							{ data: 'channel' },
							{ data: 'deptname' },
							{ data: 'status' },
							//{ data: 'isinvoice' },
							{ data: 'signdate' },
							{ defaultContent: ""},
						],
				        "deferRender": true,
						"bAutoWidth": true,

						"fnCreatedRow": function (nRow, aData, iDisplayIndex) {
						
							var pid = $('td:eq(0)', nRow).text();
							 
							$('td:eq(0)', nRow).parents("tr").css("cursor","pointer");
							 //给操作栏添加单击事件
							 $('td:eq(11)', nRow).bind("click",function(){
							 	view(nRow)
							 })							
							<%
							if(ConstantsUtil.CHECKBOXOPEN){
							%>							
							if(t==1){
								if(ifCz(pid)){
									$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='pid'  id='pid' name='pid' checked=true value='"+ pid+"'  type ='checkbox'/> &nbsp; "+pid);
									//$(nRow).addClass('selected');
									$('td:eq(0)', nRow).parents("tr").addClass('selected');
									}else{
									$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='pid'  id='pid' name='pid' value='"+ pid+"'  type ='checkbox'/> &nbsp; "+pid);	
								}
							}else if(t==0){//全选状态下
								if(ifCz(pid)){
									$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='pid'  id='pid' name='pid' value='"+ pid+"'  type ='checkbox'/> &nbsp; "+pid);	
								}else{
									$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='pid'  id='pid' name='pid' checked=true value='"+ pid+"'  type ='checkbox'/> &nbsp; "+pid);
									$('td:eq(0)', nRow).parents("tr").addClass('selected');
								}
								
							}
							<%}%>
							//$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='pid'  id='pid' name='pid' value='"+ pid+"'  type ='checkbox'/> &nbsp; "+pid);
						},
						
						"aoColumnDefs": [//和aoColums类似，但他可以给指定列附近属性
			                 //{"bSortable": false, "aTargets": [0,4]},  //第1,5列（从0开始算） 不能排序
						     {"bSortable": false,
							 "aTargets": [0,1,2]},
							 /**		
							 {
					          "render": function ( data, type, row ) {
									if(data==0||data==""||data==null){
				                    	return '否';
									}else if(data==1){
										return '是';
									}else{
										return '否';
									}
				                },
				                "targets": 10
							  },
							  */
								 {
						          "render": function ( data, type, row ) {
								  <%if(user.getRoleid().equals(5)||user.getRoleid().equals(1)){%>
								 	  return "<a href='#')>编辑</a>";
								  <%}else{%>
									  return "<a href='#')>查看</a>";
								  <%}%>		
					                },
					                "targets": 11
								  },							  
							 /**		
								 {
						          "render": function ( data, type, row ) {
										if(data=="Z"){
					                    	return '直销';
										}else if(data=="D"){
											return '代理';
										}else{
											return '';
										}
					                },
					                "targets": 7
								  }	
							  */						  
						],
		                "aaSorting": [[0, "desc"]], //默认排序 
		                "oLanguage": {
		                  "sUrl": "../js/pipelining.txt"
			             }, 
		    		});
		    		}
					//复选框单条操作           
				    $('#dataTables-example').on( 'click', '#pid', function () {
						 if ($(this).is(":checked")){	
							addArr($(this));
						 }else{
							 if(t==0){//全选状态时
								 addArr($(this));
							 }else if(t=1){
								 rmoveArr($(this));
							 }
						 } 
						 //使多行行选中       
				        $(this).parents("tr").toggleClass('selected');
						//alert( table.rows('.selected').data().length +' row(s) selected' );
				    } ); 
    
					//复选框全选操作
					var t = 1; //0 为全选 1为 未全选
					$('#dataTables-example').on( 'click', '#pidCheck', function () {
					   if ($(this).is(":checked"))
					   {
							
						$("input[name='pid']").each(function() { //全选中
							$(this).prop("checked", true);
							//addArr($(this));
							//datatable 删除多行
							$(this).parents("tr").addClass('selected');
							t=0;
							clearArr();
						});
					   }else{
						$("input[name='pid']").each(function() {//全不选中
							$(this).prop("checked", false); 
							//rmoveArr($(this));
							$(this).parents("tr").removeClass('selected');
							t=1;
							clearArr();
						});	
					   }
					});	       

					$('#dataTables-example tbody').on( 'dblclick', 'tr', function () {		
							view(this);
					});		
/**
					$('#dataTables-example tbody').on( 'click', '#view', function () {						
						view();
					});
					$('#dataTables-example tbody').on( 'click', '#edit', function () {
						var nTds = $('td', this);
						var sBrowser = $(nTds[0]).text();//序号
						alert("序号:"+ sBrowser +" --修改--功能还没实现！" );
					});	
*/					

					$('#del').click( function () {
						getCheckBoxVals();
						if(checkBoxVals!=""){
							if(confirm("你确信要删除数据？"))
							{	
								var paras = $("form").serialize();
			 					$.ajax({
			 					url:"../project/project!deleteProject.action?rand="+Math.random() + "&" + paras,
				                data:{"data":checkBoxVals,"t":t},
				                type : 'post',
				                dataType : 'json',
				                async : false,
				                success : function(result) {
				                
				                	alert('删除成功');
		 							
		 							initTable();
				                }, 					
				                error : function(msg) {
				                	alert('删除失败，请联系相关人员！');
				                	initTable();
				                }
			 					})
							}else{
								
							}
						}else{
							alert("请选中要删除项");
						}	
					})
					$("#add").click( function () {
						setDiv("../project/goto.action?gotoPage=/page/projectTable.jsp?actionName=add",0);	
					})

					//存放选中的复选框值
					var checkBoxVals="";
					var array= new Array();
					//复选框值操作
					function getCheckBoxVals(){
						checkBoxVals = array.join(',');
						clearArr();
					}
					function ifCz(value){
						if(array.indexOf(value)>-1){
							return true;
						}	
						return false;			
					}					
					function addArr(checkBox){
						if(array.indexOf(checkBox.val())<0){
							array.push(checkBox.val());			
						}				
					}
					function rmoveArr(checkBox){
						var index = array.indexOf(checkBox.val())
						if(index>-1){
							array.splice(index,1);
						}
					}
					function clearArr(){
						array.length = 0;
					}
		  			function comparDate( startDate, endDate ) {
		  		        if(startDate==""){
		  		         alert("开始日期不能为空");
		  		        return false;
		  		        }
		  		        if(endDate==""){
		  		         alert("结束日期不能为空");
		  		        return false;
		  		        }
		
		  				if( (new Date(startDate.replace(/-/g,"\/"))) > (new Date(endDate.replace(/-/g,"\/")))){
		  					alert("开始日期不能大于等于结束日期");
		  					return false;
		  				}
		  				return true;
		  			}						
 });

    </script>

</body>

</html>

