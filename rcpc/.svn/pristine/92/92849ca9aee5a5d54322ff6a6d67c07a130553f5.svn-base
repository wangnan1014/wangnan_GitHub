<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.heag.rcpc.util.DateUtil" %>
<%	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String date = dateFormat.format(new Date());
	String startDate = DateUtil.getMinMonthDate(date);
	String endDate = DateUtil.getMaxMonthDate(date);
 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>日志记录列表</title>
<link rel="stylesheet" href="../css/datatables/jquery.dataTables.css" type="text/css"></link>
<script  src="../js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script src="../js/pipelining.js"></script>

</head>
<body>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">日志记录列表</h1>
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
							       用户名:<input type="text" name="uname"/>
							       涉及的数据库表:<input type="text" name="tablename"/>
							        操作时间：<input name="startDate" id="startDate" value="<%=startDate%>"/> 至  <input name="endDate" id="endDate" value="<%=endDate%>"/>
							   <buttn type="button" class="btn btn-primary btn-sm" id="query" name="query">查看</button>
  							 </form>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">

                               
                                <table  width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>    
                                        	<th>编号</th> 
                                            <th>公司</th>
                                            <th>部门</th>
                                            <th>用户名</th>
                                            <th>操作</th>
                                            <th>涉及页面</th>
                                            <th>涉及表</th>             
                                            <th>涉及记录编号</th>
                                            <th>涉及字段</th>
                                            <th>原数据</th>
                                            <th>新数据</th>
                                            <th>操作时间</th>
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

    <!-- DataTables JavaScript -->
    <script src="../js/jquery.dataTables.min.js"></script>
    <script src="../js/dataTables.bootstrap.min.js"></script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
 	    
    $(document).ready(function() {
       $("#query").click(function() {
        //$("#dataTables-example").dataTable().fnClearTable();
        initTable();
    });
    
    initTable();
    function initTable() {
		var paras = $("form").serialize();
	    var table1 = $('#dataTables-example').DataTable( {
			"bProcessing":true,	//开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好	    
			"bServerSide": true,//开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。--一般不开 开了 都要自己设置
	        "bAutoWidth":true,
	        "deferRender": true,
			"bAutoWidth": true,
			"sPaginationType" : "full_numbers",
			"bFilter": false,//去掉搜索框
			"bDestroy" : true,//服务器分页时 必须加  不然表重建不了
			"aoColumnDefs": [//和aoColums类似，但他可以给指定列属性
                  {"bSortable": false, "aTargets": [0]},  //第5列（从0开始算） 不能排序  
            ],
	        "columnDefs": [ {
	            "searchable": false,
	            "orderable": false,
	            "targets": 0
	        } ],
	        "order": [[ 0, 'desc' ]],     
            //"aoColumnDefs": [{ "bVisible": false, "aTargets": [0]}]//隐藏列
            //"aaSorting": [[0, "desc"]], //默认排序 		
	        "ajax": $.fn.dataTable.pipeline( {
	            url: "../log/log!getDataList.action?rand="+Math.random() + "&" + paras,
				method:"POST",
	        } ),     
			"columns": [
				//{ defaultContent: ""},
				{ data: 'lid' },//隐藏 可在后面添加逗号隔开  "visible": false 
				{ data: 'cname' },
				{ data: 'deptname' },
				{ data: 'uname' },
				{ data: 'action' },
				{ data: 'page' },
				{ data: 'tablename' },
				{ data: 'dataid' },
				{ data: 'dataname' },
				{ data: 'beforeupdate' },
				{ data: 'afterupdate' },
				{ data: 'createdate' },
			],
			"fnCreatedRow": function (nRow, aData, iDisplayIndex) {
				//action 4	
				var val = $('td:eq(4)', nRow).text();
				if(val=='1'){
					$('td:eq(4)', nRow).html("登录");
				}else if(val=='2'){
					$('td:eq(4)', nRow).html("登出");
				}else if(val=='3'){
					$('td:eq(4)', nRow).html("查询");
				}else if(val=='4'){
					$('td:eq(4)', nRow).html("新增");
				}else if(val=='5'){
					$('td:eq(4)', nRow).html("修改");
				}else if(val=='6'){
					$('td:eq(4)', nRow).html("删除");
				}else if(val=='7'){
					$('td:eq(4)', nRow).html("导出数据");
				}
				//dataid 7
				var dataids = $('td:eq(7)', nRow).text();
				if(dataids.length>10){
					$('td:eq(7)', nRow).attr("title",dataids);
					$('td:eq(7)', nRow).html(dataids.substr(1,10)+"...");	
				}
				
			},
            "oLanguage": {
				"sUrl": "../js/pipelining.txt"
           },
   
    } );
    
    }
	
	//自动显示序号还有问题
/**
	table1.on( 'order.dt search.dt', function () {
	
        table1.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {

            cell.innerHTML = i+1;

        } );
    } ).draw();
*/ 
/**  
$.fn.dataTable.ext.search.push(
    function( settings, data, dataIndex ) {
        if($('#startDate').val()==""){
         alert("开始时间不能为空");
        return false;
        }
        if($('#endDate').val()==""){
         alert("结束时间不能为空");
        return false;
        }
        var min = parseInt( $('#startDate').val(), 20 );
        var max = parseInt( $('#endDate').val(), 20 );
        var date = parseFloat( data[11]) || 0; // use data for the data column
        if (!checkEndTime(date,"#startDate","#endDate"))
        {
        	alert("结束时间必须晚于开始时间！");  
            return  true;  
        }
        return false;
    }
); 
	$("#sear").bind("click", function() {
	 table1.search("startDate="+$('#startDate').val(),"endDate="+$('#endDate').val()).draw();
    } );
    
$.fn.dataTable.ext.search.push(
	    function( settings, data, dataIndex ) {
	        var min = parseInt( $('#min').val(), 10 );
	        var max = parseInt( $('#max').val(), 10 );
	        var age = parseFloat( data[7] ) || 0; // use data for the age column
	 
	        if ( ( isNaN( min ) && isNaN( max ) ) ||
	             ( isNaN( min ) && age <= max ) ||
	             ( min <= age   && isNaN( max ) ) ||
	             ( min <= age   && age <= max ) )
	        {
	            return true;
	        }
	        return false;
	    }
	);    
*/
  $("#startDate,#endDate").bind("click", function () {
  
  	WdatePicker({dateFmt:'yyyy-MM-dd'});
  
  })
     
    // Event listener to the two range filtering inputs to redraw on input
    $('#min, #max').keyup( function() {
        $('#dataTables-example').DataTable().draw();
    } );

 });


    </script>

</body>

</html>

