<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015-6-23 0023
  Time: 14:36:15
  To change this template use File | Settings | File Templates.
--%>
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
<html lang="zh-cn">

<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>华仪电气营销数据系统</title>

  <!-- Bootstrap Core CSS -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">

  <!-- MetisMenu CSS -->
  <link href="../css/metisMenu.min.css" rel="stylesheet">

  <!-- Timeline CSS -->
  <!--  <link href="../dist/css/timeline.css" rel="stylesheet"> -->

  <!-- Custom CSS -->
  <link href="../css/heagreport.css" rel="stylesheet">


  <!-- Custom Fonts -->
  <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <link href="../css/SyntaxHighlighter.css" rel="stylesheet" type="text/css" >


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

  <script type="text/javascript" src="../js/map/raphael-min.js"></script>
  <script type="text/javascript" src="../js/map/chinaMapConfig.js"></script>
  <script type="text/javascript" src="../js/map/map.js"></script>
  <!-- date plus -->
  <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
  <!-- 
  <script src="/js/morris.min.js"></script>
  -->
  <!--
  <script src="../js/jscharts/jscharts.js"></script>
  -->
	<!-- highcharts -->
	<script src="../js/highcharts/highcharts.js"></script>
	<script src="../js/highcharts/modules/exporting.js"></script>
<!--  <script type="text/javascript" src="../js/map/SyntaxHighlighter.js"></script>  -->

  <!-- Custom Theme JavaScript -->
  <script src="../js/menu.js"></script>
  
  <script src="../js/mapreport.js"></script>
  

</head>

<body>

<div id="wrapper">

  <%@ include file="menu.jsp"%>

  <div id="page-wrapper">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-12">
        	 <hr/>
        	 	
				 开始日期：<input name="startDate" id="startDate"  value="<%=startDate %>"/>  
				  结束日期：<input name="endDate" id="endDate"   value="<%=endDate%>"/> 
				<!-- 
				 <button type="button" name = "show_data" id="show_data" class="btn btn-outline btn-primary btn-sm"> 查询 </button>
        		 -->
        	<hr/>
         全选 <input id="typeName1" name="typeName1" class="all-select"  type="radio" value="0" />
         重置 <input id="typeName1" name="typeName1" class="no-select"  type="radio" value="0" />
         反选 <input id="typeName1" name="typeName1" class="reverse-select"  type="radio" value="0" />        
   | 查询模式：区域 <input id="typeName" name="typeName" class="typeName"  type="radio" value="0" checked/> 省 <input id="typeName" name="typeName" class="typeName" value="1" type="radio"/> 
        </div>
        <!-- /.col-lg-12 -->
        <div class="col-lg-6" id="ChinaMap"></div>
        
		 <div class="col-lg-6" style="">                	                	           
		 
            <div class="panel panel-default">
                <div class="panel-heading">
                    	数据汇总 
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                	<div class="">                	
                	 <div class="table-responsive">
                	  <table width="100%"  class="table table-striped table-bordered table-hover">
                              <thead>
                                  <tr>
                                      <th>地区</th>
                                      <th>销售收入额</th>
                                      <th>合同订单额</th>
                                      <th>货款回收额</th>
                                  </tr>
                              </thead>
                              <tbody id="data-show">
                              
                              </tbody>
                                  <tfoot>
                                   <div id="morris-bar-chart" class="carousel-inner img-responsive img-rounded" style="min-width: 310px; max-width: 800px;"></div>
								  </tfoot>
                	  </table>
                	  
                	</div>

                	</div>
                </div>
                <!-- /.panel-body -->                
            </div>
            <!-- /.panel -->
            
        </div>	        
             
         

      </div>
      <!-- /.row -->
 
    </div>
    <!-- /.container-fluid -->
  </div>
  <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->



</body>

</html>