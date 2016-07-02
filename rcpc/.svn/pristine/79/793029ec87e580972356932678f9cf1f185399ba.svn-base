<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.heag.rcpc.util.ConstantsUtil"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="../css/datatables/jquery.dataTables.css" type="text/css"></link>

  </head>
  
  <body>
             <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">用户列表</h1>
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

                            <form>
							         用户名:<input type="text" name="uname" id="uname"/>
							        姓名:<input type="text" name="realname" id="realname"/>
							        公司:<input type="text" name="cname" id="cname"/>
							        部门:<input type="text" name="deptname" id="deptname"/>
							        角色:<input type="text" name="rolename" id="rolename"/>
							   <button type="button" class="btn btn-primary btn-sm" id="query" name="query">查看</button>
  							 </form>
                                                                               
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                               
                                <table class="table table-striped table-bordered table-hover" width="100%" id="dataTables-example" >
                                    <thead>
                                        <tr>
                                        	<!--全选<th> <input type="checkbox" id="uidCheck" name="uidCheck" value="-1" /> 序号</th>  -->
                                            <th>编号</th>
                                            <th>用户名</th>
                                            <th>姓名</th>
                                            <th>公司</th>
                                            <th>部门</th>
                                            <th>角色</th>
                                            <th>操作</th>
                                             
                                        </tr>
                                    </thead>
									<tfoot>
										<div class="row col-lg-12">
				                            <button type="button" class="btn btn-sm btn-primary" id="add" name="add">新增</button>
				                            <button type="button" class="btn btn-primary btn-sm" id="del" name="del">删除</button>
				                            <!--
				                            <button type="button" class="btn btn-primary  btn-sm" id="edit" name="mod">编辑</button>	
											
											 -->
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
    <script src="../js/dataTables.bootstrap.min.js"></script>
    <script src="../js/pipelining.js"></script>   
    <script type="text/javascript">
    var table = null;
    $(document).ready(function() {
        		//点击查询
				$("#query").bind('click',function(){
					initTable();

					})
				/**输入查询
		       $("#uname,#realname,#cname,#deptname,#rolename").bind("input propertychange",function() {
		      	    initTable();
		   	   });
				*/
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
			            url: "../user/user!getDataList.action?rand="+Math.random() + "&" + paras,
						method:"POST",
			        } ), 				        
					"columns": [
						{ data: 'uid' },//隐藏 可在后面添加 "visible": false 逗号隔开
						{ data: 'uname' },
						{ data: 'realname' },
						{ data: 'cname' },
						{ data: 'deptname' },
						{ data: 'rolename' },
						{ defaultContent: "<a href='#'>修改</a>"},
					],
			        "deferRender": true,
					"bAutoWidth": true,
				
					"fnCreatedRow": function (nRow, aData, iDisplayIndex) {
						var uid = $('td:eq(0)', nRow).text();
						 //鼠标经过tr时变小手
						 $('td:eq(0)', nRow).parents("tr").css("cursor","pointer");
						 //给操作栏添加单击事件
						 $('td:eq(6)', nRow).bind("click",function(){
						 	view(nRow)
						 })
						<%
						if(ConstantsUtil.CHECKBOXOPEN){
						%>							
						if(t==1){
							if(ifCz(uid)){
								$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='uid'  id='uid' name='uid' checked=true value='"+ uid+"'  type ='checkbox'/> &nbsp; "+uid);
								$('td:eq(0)', nRow).parents("tr").addClass('selected');
								}else{
								$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='uid'  id='uid' name='uid' value='"+ uid+"'  type ='checkbox'/> &nbsp; "+uid);	
							}
						}else if(t==0){//全选状态下
							if(ifCz(uid)){
								$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='uid'  id='uid' name='uid' value='"+ uid+"'  type ='checkbox'/> &nbsp; "+uid);	
							}else{
								$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='uid'  id='uid' name='uid' checked=true value='"+ uid+"'  type ='checkbox'/> &nbsp; "+uid);
								$('td:eq(0)', nRow).parents("tr").addClass('selected');
							}
						}
						<%}%>
					},

					"aoColumnDefs": [//和aoColums类似，但他可以给指定列附近属性
					     {"bSortable": false,
						 "aTargets": [0]},
					],
	                "aaSorting": [[0, "asc"]], //默认排序 
	                "oLanguage": {
	                  "sUrl": "../js/pipelining.txt"
		             }, 
	    		});
	    		}
				//复选框单条操作           
			    $('#dataTables-example').on( 'click', '#uid', function () {
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
				$('#dataTables-example').on( 'click', '#uidCheck', function () {
				   if ($(this).is(":checked"))
				   {
					$("input[name='uid']").each(function() { //全选中
						$(this).prop("checked", true);
						$(this).parents("tr").addClass('selected');
						t=0;
						clearArr();
					});
				   }else{
					$("input[name='uid']").each(function() {//全不选中
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
					
				//查看
				function view(o){
					var uid = $('td:eq(0)',o).text();//序号
					
						var d ="uid=" + $.trim(uid) + "&actionName=view";
						into_register('register',d);
				}
				
				$('#del').click( function () {
					getCheckBoxVals();
					if(checkBoxVals!=""){
						if(confirm("你确信要删除数据？"))
						{	
							var paras = $("form").serialize();
		 					$.ajax({
		 					url:"../user/user!deleteUser.action?rand="+Math.random() + "&" + paras,
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
			                }
		 					})
						}else{
							
						}
					}else{
						alert("请选中要删除项");
					}	
				})
				$("#add").click( function () {
					
					into_register('register','actionName=add');

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
					var index = array.indexOf(checkBox.val());
					if(index>-1){
						array.splice(index,1);
					}
				}
				function clearArr(){
					array.length = 0;
				}
				function commend(){//未实现
					$().showLoading("<div>锁屏了</div>");

				}
					
});    
    
    </script> 
  </body>
</html>
