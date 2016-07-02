<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

  <script>
    $(document).ready(function() {
		
			    	var table = $('#dataTables-example').DataTable( {
						"bProcessing":true,	//开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好	    
						//"bServerSide": true,//开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。--一般不开 开了 都要自己设置
				        //"aoColumnDefs": [{ "bVisible": false, "aTargets": [0]}]//隐藏列
				       //"bAutoWidth":true,
				       //"pagingType": "full_numbers",
				        "ajax": {
				        	url:"/project/project!getDataList.action?rand="+Math.random(),
				        	type: "POST",
				        	dataType : "json",
				        } ,
						"columns": [
							{ data: 'pid' },//隐藏 可在后面添加 "visible": false 逗号隔开
							{ data: 'iContractid' },
							{ data: 'oContractid' },
							{ data: 'projectname' },
							{ data: 'signdate' },
							//{ defaultContent: "<a id ='view' href='#' >查看</a>/<a  id ='edit' href='#'>修改</a>"},
						],
				        "deferRender": true,
						"bAutoWidth": true,
						"fnCreatedRow": function (nRow, aData, iDisplayIndex) {
							var pid = $('td:eq(0)', nRow).text();
							$('td:eq(0)', nRow).html(" &nbsp;&nbsp;<input class='pid'  id='pid' name='pid' value='"+ pid+"'  type ='checkbox'/> &nbsp; "+pid);
						},		        
	    
						"aoColumnDefs": [//和aoColums类似，但他可以给指定列附近属性
			                 {"bSortable": false, "aTargets": [0,4]},  //这句话意思是第5列（从0开始算） 不能排序
			            ],
		                "aaSorting": [[0, "desc"]], //默认排序 
		                "oLanguage": {
		                     "sProcessing": "正在加载中......",
		                     "sLengthMenu": "每页显示 _MENU_ 条记录",
		                     "sZeroRecords": "对不起，查询不到相关数据！",
		                     "sEmptyTable": "表中无数据存在！",
		                     "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条",
		                     "sInfoFiltered": " (数据表中共有 _MAX_ 条记录)",
		                     "sSearch": "搜索：",
		                     "oPaginate": {
			                        "sFirst": "首页",
			                        "sPrevious": "上一页",
			                        "sNext": "下一页",
			                        "sLast": "末页"
			                    }
			             }, 
		    		});
					//复选框单条操作           
				    $('#dataTables-example').on( 'click', '#pid', function () {			
						 if ($(this).is(":checked")){					
							addArr($(this));
						 }else{
							rmoveArr($(this));
						 } 
						 //使多行行选中       
				        $(this).parents("tr").toggleClass('selected');
						//alert( table.rows('.selected').data().length +' row(s) selected' );
				    } ); 
    
					//复选框全选操作
					$('#dataTables-example').on( 'click', '#pidCheck', function () {
					    if ($(this).is(":checked"))
					   {
							
						$("input[name='pid']").each(function() { //全选
							$(this).prop("checked", true); 
							addArr($(this));
							//datatable 删除多行
							$(this).parents("tr").addClass('selected');
						});
					   }else{
						$("input[name='pid']").each(function() {//全不选中 
							$(this).prop("checked", false); 
							rmoveArr($(this));
							$(this).parents("tr").removeClass('selected');
						
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
					//查看
					function view(o){
						var pid = $('td:eq(0)',o).text();//序号
						//查看
							var d ="pid=" + $.trim(pid) + "&actionName=view";
							setDiv("../project/goto.action?gotoPage=/page/projectTable.jsp?"+d,0);
					}
					$('#del').click( function () {
						getCheckBoxVals();
						if(checkBoxVals!=""){
							if(confirm("你确信要删除数据？"))
							{	
			 					$.ajax({
			 					url:"/project/project!deleteProject.action?rand="+Math.random(),
				                data:{data:checkBoxVals},
				                type : 'post',
				                dataType : 'json',
				                async : false,
				                success : function(result) {
				                
				                	alert('删除成功');
				                	//$('#dataTables-example').DataTable.Rows.Clear() 
				                	//window.location.reload(); 
		 							table.row('.selected').remove().draw( false );
				                }, 					
				                error : function(msg) {
				                	alert('删除失败，请联系相关人员！')
				                }
			 					})				
								
							}else{
							}
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
 });

    </script> 
    
</head>
<body>
      <!-- 标题 -->
	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">产品列表</h1>
                </div>
           <!-- /.col-lg-12 -->
    </div>
    
     <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <button type="button" class="btn btn-outline btn-primary" id="add" name="add">新增</button>
                            <!-- 
                            <button type="button" class="btn btn-primary" id="mod" name="mod">修改</button>
                             -->
                            <button type="button" class="btn btn-outline btn-primary" id="del" name="del">删除</button>                                                        
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                               
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th> <input type="checkbox" id="pidCheck" name="pidCheck" value="-1" /> 序号</th>
                                            <th>产品名称</th>
                                            <th>所属公司</th>
                                            <th>所属事业部</th>
                                            <th>型号规格</th>
                                            <!-- 
                                            <th>操作</th>
                                             -->
                                        </tr>
                                    </thead>
								    <tbody id ="dataList">
  		
								    </tbody>
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
    
 


  <script src="../js/jquery.dataTables.min.js"></script>
  <script src="../js/dataTables.bootstrap.min.js"></script>
</body>
</html>