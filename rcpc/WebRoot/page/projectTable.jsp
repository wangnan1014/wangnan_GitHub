<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.heag.rcpc.model.RpUser"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
RpUser user = (RpUser)session.getAttribute("user");

%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../js/WebTool.js"></script>
 </head>
  <body>
  <br/>
	 <% 
	 String actionName = (String)request.getParameter("actionName");
	 String pid = (String)request.getParameter("pid");
	 if("add".equals(actionName)&&(user.getRoleid().equals(4)||user.getRoleid().equals(1))){
	  %> 
     <button type="button" class="btn   btn-primary btn-sm" id="add"><i class="fa fa-check-square-o"> 保存</i>
     </button>
     <%
     }else if("view".equals(actionName)){
    	 if(user.getRoleid().equals(5)||user.getRoleid().equals(1)){
     %> 
     <button type="button" class="btn   btn-primary btn-sm" id="edit"><i class="fa fa-pencil"> 编辑</i>
     </button>
     <button type="button" class="btn   btn-primary btn-sm" id="save"><i class="fa fa-pencil"> 保存</i>
     </button>
     <%} %> 
     <button type="button" class="btn   btn-primary btn-sm" id="back"><i class="fa fa-share-square-o"> 返回</i>
     </button>     
     <%}else if("edit".equals(actionName)){%>  
     <!--  
     <button type="button" class="btn   btn-primary btn-sm" id="save"><i class="fa fa-pencil"> 保存</i>
     </button>
      -->
     <%} %>  
     <!--      
     <button type="button" class="btn   btn-primary btn-sm" id="view"><i class="fa fa-eye "> 查看</i>
     </button>
     <button type="button" class="btn   btn-primary btn-sm" id="back"><i class="fa fa-share-square-o"> 返回列表</i>
     </button>
     -->   
<form name ="form1" id ="form1" action="#"  method="post" > 
<!--表修改字段-->
<input type="hidden" name="oldDate"  name="oldDate" value=""/>	  
<input type="hidden" name="changedProperty"  name="changedProperty" value=""/>	  
<input type="hidden" name="changedPropertyDate"  name="changedPropertyDate" value=""/> 
<!-- 操作类型  add ,edit, view  -->   
<input type="hidden" id="actionName" name="actionName" class=""  value="<%=actionName==null?"":actionName%>"/>  
<!--  记录主键id -->   	
 <input type="hidden" id="pid" name="rpProject.pid" class="" />
<!--片区name  -->   	
<input type="hidden" id="region" name="rpProject.region" class="" />
<!--省份name  -->	
<input type="hidden" id="province" name="rpProject.province" class="" />
<!--行业类别name  -->   	
<input type="hidden" id="itypename" name="rpProject.itypename" class="" />
<!--所属事业部id  -->   	
<input type="hidden" id="deptid" name="rpProject.deptid" class="" />
<!--产品id  -->   	
<input type="hidden" id="productid" name="rpProject.productid" class="" />
<!--是否删除  -->   	
<input type="hidden" id="isdelete" name="rpProject.isdelete" class="" />
<!--更新日期  -->   
<input type="hidden" id="updatedate" name="rpProject.updatedate" class="" />
<!-- 记录创建日期 -->   
<input type="hidden" id="createdate" name="rpProject.createdate" class="" />
<hr/>
<table class="table  table-condensed table-hover">
   <caption style="text-align: center; font-size: large">合同项目表</caption>
 <tbody>
 <tr>
<!--合同编号(内)  -->   	
<td>合同编号（内）</td><td><input type="text" id="iContractid" name="rpProject.iContractid" class="" /></td>
<td>合同编号（外）</td><td><input type="text" id="oContractid" name="rpProject.oContractid" class="" /></td>
<td>合同签订日期</td><td><input type="text" id="signdate" name="rpProject.signdate" class=""/><font color="red"> *</font></td>
</tr><tr>
<td>招标单位</td><td><input type="text" id="buycorp" name="rpProject.buycorp" class="" /></td>
<td>招标批次</td><td><input type="text" id="buyno" name="rpProject.buyno" class="" /></td>
<td>客户名称</td><td><input type="text" id="custname" name="rpProject.custname" class="" /> <font color="red"> *</font></td>
</tr><tr>
<td>工程名称</td><td><input type="text" id="projectname" name="rpProject.projectname" class="" /> <font color="red"> *</font></td>
<td>行业类别</td><td><select id="itypeid"  name="rpProject.itypeid"></select><font color="red"> *</font></td>
<td>技术协议返回时间	</td><td><input type="text" id="techdate" name="rpProject.techdate" class="" /></td>
</tr><tr>
<td>片区</td><td><select id="regionid"  name="rpProject.regionid"></select> <font color="red"> *</font></td>
<td>省份</td><td><select id="provinceid"  name="rpProject.provinceid" disabled="disabled"></select> <font color="red"> *</font></td>

 <td>销售渠道</td><td>
 <select id="channel" name="rpProject.channel" class="">
 <option value=""  selected="selected">请选择</option>
 <option value="D">代理</option>
 <option value="Z">直销</option>
 </select>
 <font color="red"> *</font></td>
</tr><tr>
<td>产品名称</td><td><input type="text" id="productname" name="rpProject.productname" class="" /></td>
<td>规格、型号</td><td><input type="text" id="model" name="rpProject.model" class="" /></td>
<td>单位</td><td><input type="text" id="danwei" name="rpProject.danwei" class="" /></td>
</tr><tr>
<td>数量</td><td><input type="text" id="count" name="rpProject.count" class="" /></td>
<td>单价</td><td><input type="text" id="price" name="rpProject.price" class="" /></td>
<td>单价（结算）</td><td><input type="text" id="realprice" name="rpProject.realprice" class="" /></td>
</tr><tr>
<td>合同价</td><td><input type="text" id="contractprice" name="rpProject.contractprice" class="" /></td>
<td>结算价</td><td><input type="text" id="totalprice" name="rpProject.totalprice" class="" /></td>
<td>报价金额</td><td><input type="text" id="offerprice" name="rpProject.offerprice" class="" /></td>
</tr><tr>
<!-- 
<td>所属事业部</td><td><input type="text" id="deptname" name="rpProject.deptname" class="" /></td>
 -->
<td>所属事业部</td><td><select id="deptname" name="rpProject.deptname" class="" >
<option value="" selected="selected">请选择</option>
<option value="成套" >成套</option>
<option value="箱变">箱变</option>
<option value="开关元件">开关元件</option>
<option value="科技">科技</option>
<option value="高压开关">高压开关</option>
</select>
<font color="red"> *</font>
</td>
<!-- 
<td>合同状态</td><td><input type="text" id="status" name="rpProject.status" class="" /></td>
 -->
<td>合同状态</td><td><select id="status" name="rpProject.status" class="" >
<option value="" selected="selected">请选择</option>
<option value="预中标">预中标</option>
<option value="暂停">暂停</option>
<option value="记账产品">记账产品</option>
<option value="库存">库存</option>
</select>
<font color="red"> *</font>
</td>
 
<td>业务员</td><td><input type="text" id="salesman" name="rpProject.salesman" class="" /></td>
</tr><tr>
<td>已回款日期</td><td><input type="text" id="refundsdate" name="rpProject.refundsdate" class="" /></td>
<!-- 
<td>是否已开发票</td><td><input type="text" id="isinvoice" name="rpProject.isinvoice" class="" /></td>
 -->
<td>是否已开发票</td><td><select  id="isinvoice" name="rpProject.isinvoice" class="" >
<option value ="1" selected="selected">否</option>
<span style="display: display"><option value ="0" >是</option><sapn>

</select></td>

<td>已回款金额</td><td><input type="text" id="refunds" name="rpProject.refunds" class="" /></td>
</tr><tr>
<td>开票金额</td><td><input type="text" id="invoicecount" name="rpProject.invoicecount" class="" /></td>
<td>开票日期</td><td><input type="text" id="invoicedate" name="rpProject.invoicedate" class="" /></td>
<!-- 
<td>供货方式</td><td><input type="text" id="supplytype" name="rpProject.supplytype" class="" /></td>
 -->
<td>供货方式</td><td><select id="supplytype" name="rpProject.supplytype" class="" >
<option value="" selected="selected">请选择</option>
<option value="预中标">预中标</option>
<option value="在制品">在制品</option>
<option value="库存">库存</option>
<option value="记账产品">记账产品</option>
</select></td>
 
</tr>
</tbody>
</table>
</form> 
<hr>
<div id="zy">
<font color="red" size="2">注意： 表中 * 为必填项</font>
</div>      
  </body>
  <script type="text/javascript">
	var region = {
  		  	"华北":["北京","天津","河北","山西","内蒙古"],
  		  	"东北":["辽宁","吉林","黑龙江"],
  		  	"华东":["上海","江苏","浙江","安徽","福建","山东"],
  		  	"华中":["湖北","湖南","河南","江西"],
  		  	"华南":["广东","广西","海南"],
  		  	"西南":["重庆","四川","贵州","云南","西藏"],
  		  	"西北":["陕西","甘肃","青海","宁夏","新疆"],
  		  	//"台港澳":["台湾","香港","澳门"]
  		  	"大客户":["北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江","上海","江苏","浙江","安徽","福建","山东","湖北","湖南","河南","江西","广东","广西","海南","重庆","四川","贵州","云南","西藏","陕西","甘肃","青海","宁夏","新疆","台湾","香港","澳门"]
 		  	};  
	$(document).ready(function() {
	    //控件初始化
	    initControl();
	    function initControl(){
		    var actionName= $("#actionName").val();
		    if(actionName=="view"){
			    controlSet('input,select,textarea',0);
			    controlSet('button:not(#edit,#back)',0);
		    }else if(actionName=="edit"){
			    controlSet('input,select,textarea',0);    		
		    }else if(actionName=="add"){
		    
		    }else{
			    $('input,select,textarea,button').each(function() {
			        $(this).prop("disabled", "true");
			    });
			    controlSet('input,select,textarea,button',0);
			    alert("加载失败");
		    }
		        
		}
			getColData("itypeid","getIndustryList","selcet","rid","industry","itypename");
			getColData("provinceid","getProvinceList","selcet","pid","provincename","province");			
			getColData("regionid","getRegionList","selcet","rid","region","region");
			
		if($("#actionName").val()=="view"){
			getData();
			showSelectOption(region[$('#regionid').find("option:selected").text()],"provinceid");		
		}
		//初始化数据
		function getData(){
			$.ajax({
			   type: 'POST', 
			   url:"../project/project!getDataOne.action?pid=<%=pid==null?"":pid%>",
			   data: {},
			   dataType: "json",
			   async:false,
			   success : function(d){
				if(!d){
				}else{
					setData(d);
				}
			   },
			   error:function(d){
			   	   alert("数据错误，请联系相关人员！")
			   }
		   });			
		}

		
		//新增
		$("#add").click(function(){ 
			if(!decideNull()){
				return false;
			}else{
				leftDecimal(2);
				$.ajax({
					   type: 'POST', 
					   url:"../project/project!addProject.action",
					   data: $("#form1").serialize(),
					   dataType: "json",
					   async:false,
					   success : function(d){
						if(d==0){
						   alert("新增失败！");
						   	}else if(d==1){
						   alert("新增成功！");
						  
						   if(confirm("新增成功,是否继续新增！")){
							   $("#form1")[0].reset();
							  }else{
							   setDiv("../project/goto.action?gotoPage=/page/projectList.jsp?rand="+Math.random(),0);
							}
						}			   		
					   },
					   error : function(d){
						   alert("新增操作失败！");
					   },			   
				});
			}

		})

		//编辑保存
		$("#save").click(function(){
			if(!decideNull()){
				return false;
			}else{
				leftDecimal(2);
				setChangedProperty();
				$.ajax({
				   type: 'POST', 
				   url:"../project/project!saveProject.action",
				   data: $("#form1").serialize(),
				   dataType: "json",
				   async:false,
				   success : function(d){
					if(d==0){
					   alert("编辑失败！");
					   	}else if(d==1){
					   if(confirm("编辑成功,是否跳到合同列表")){
					   	setDiv("../project/goto.action?gotoPage=/page/projectList.jsp?rand="+Math.random(),0);
					   }else{
					   }
					}			   		
				   },
				   error : function(d){ 
					   alert("编辑操作失败！");
				   },			   
			   });
			}	
		})
		//regionid联动 <用屏蔽provinceid>
		$("#regionid").bind("change", function () {
			var province_data = region[$(this).find("option:selected").text()];
			getColData("provinceid","getProvinceList","selcet","pid","provincename","province");
 			showSelectOption(province_data,"provinceid");
 			$("#provinceid").removeAttr("disabled");
 			
 		});	
		
		function showSelectOption(data_arr,key){
			if(data_arr==undefined){
				$("#provinceid option").each(function(i){
					$(this).remove();
				})
				return false;			
			}
			var keyName ="#"+key+ " option";

			$(keyName).each(function(i){
				if(data_arr.indexOf($(this).text())>-1){//包含 显示
				}else{
					$(this).remove();
				}
			})
			$("#provinceid").get(0).selectedIndex=1;
			$("#province").val($("#provinceid").find("option:selected").text());			
		}
		
		function  bc_success(data) {
			if(data==0){
			   alert("保存失败！");
			   	}else if(data==1){
			   alert("保存成功！");
			   	}
	   	}
		function  cb_error(data) {
			   alert("操作失败！");
	   	} 
		$("#back").click(function(){
			 setDiv("../project/goto.action?gotoPage=/page/projectList.jsp?rand="+Math.random(),0);
		})
		
		$("#signdate,#techdate,#refundsdate,#invoicedate").click(function(){
			WdatePicker();
		})

		$(":input").bind("input onpropertychange", function () {
			if(isNum($(this).attr("id"), $.trim($(this).val()))){
				$(this).focus();
				$(this).select();
				alert('请输入数字');
				return false;

			}
		});
		
		function  decideNull(){ 
			var cc = 0;//  
			$.each(val_str,function(i){
					if(isNull(val_str[i])){
						var ids = "#"+val_str[i];
						$(ids).focus();
						$(ids).select();
						alert($(ids).parent().prev().html()+' 不能为空');
						cc=1;
						return false;
					}
			})
			if(cc==0){
				return true;
			}else if(cc==1){
				return false;
			}
		}
		//array中的保留num位小数
		function leftDecimal(num){
			$(val_num).each(function(index){
				if($("#"+this).val()!=""&&$("#"+this).val()!=undefined){
					$("#"+this).val(eval($("#"+this).val()).toFixed(num));
				}
				

			});
		}
		var val_num =new Array();
		val_num.push('count');
		val_num.push('price');
		val_num.push('realprice');
		val_num.push('contractprice');
		val_num.push('totalprice');
		val_num.push('offerprice');
		val_num.push('refunds');
		val_num.push('invoicecount');
		function isNum(idStr,obj){
			if(val_num.indexOf(idStr)>-1&&obj!=""){
				var r = $.isNumeric(obj);
				return !r;
			}else{
				return false;
			}				
		}
		//必填字段
		var val_str =new Array();
		val_str.push('projectname');
		val_str.push('custname');
		val_str.push('regionid');
		val_str.push('provinceid');
		val_str.push('itypeid');
		val_str.push('channel');
		val_str.push('deptname');
		val_str.push('status');
		val_str.push('isinvoice');	
		val_str.push('signdate');	
		function isNull(idObj){
			var idStr = "#"+idObj;
			return $(idStr).val().trim()=="";
 		
		}	
		})
  </script>
</html>
