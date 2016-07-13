<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="/public/head.jspf" %>
	<script>
 $(function(){  
            $('#dg').datagrid({     
                //请求数据的url地址，后面会改成请求我们自己的url  
                url:'jquery-easyui-1.4.5/demo/datagrid/datagrid_data1.json',  
                loadMsg:'Loading......',  
                queryParams:{type:''},//参数  
                //width:300,  
                fitColumns:true,//水平自动展开，如果设置此属性，则不会有水平滚动条，演示冻结列时，该参数不要设置  
                //显示斑马线  
                striped:true,  
                //当数据多的时候不换行  
                nowrap:true,  
                singleSelect:true, //如果为真，只允许单行显示，全显功能失效  
                //设置分页  
                pagination:true,  
                rowStyler: function(index,row){  
                    console.info("index" + index + "," + row)  
                    if(index % 2 == 0) {  
                        return 'background-color:#fff;';  
                    } else {  
                        return 'background-color:#ff0;';  
                    }  
                      
                },  
                //同列属性，但是这些列将会冻结在左侧,大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内  
                frozenColumns:[[  
                    {field:'checkbox',checkbox:true},  
                    {field:'code',title:'编号',width:200}                   
                ]],  
                //配置datagrid的列字段   
                //field：列字段的名称，与json的key捆绑  
                //title：列标题，是显示给人看的  
                columns:[[                       
                    {field:'productname',title:'类别名称',width:100,  
                        //用来格式化当前列的值，返回的是最终的数据  
                        formatter: function(value,row,index){  
                        return "<span title=" +　value + ">" + value + "</span>";  
                    }  
                },      
                    {field:'listprice',title:'价格',width:100,  
                    styler: function(value,row,index){  
                        //设置当前单元格的样式，返回的字符串直接交给 style属性  
                        //console.info("val:" + value + ",row:" + row + ",index:" + index)  
                        if (value < 20){  
                            return 'color:red;';  
                        }  
                    }     
                    }  
                ]]      
            });   
        }); 
	</script>
  </head>
  
  <body>
   <table id="dg"></table>  
  </body>
</html>
