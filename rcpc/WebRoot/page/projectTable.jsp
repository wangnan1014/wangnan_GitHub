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
     <button type="button" class="btn   btn-primary btn-sm" id="add"><i class="fa fa-check-square-o"> ����</i>
     </button>
     <%
     }else if("view".equals(actionName)){
    	 if(user.getRoleid().equals(5)||user.getRoleid().equals(1)){
     %> 
     <button type="button" class="btn   btn-primary btn-sm" id="edit"><i class="fa fa-pencil"> �༭</i>
     </button>
     <button type="button" class="btn   btn-primary btn-sm" id="save"><i class="fa fa-pencil"> ����</i>
     </button>
     <%} %> 
     <button type="button" class="btn   btn-primary btn-sm" id="back"><i class="fa fa-share-square-o"> ����</i>
     </button>     
     <%}else if("edit".equals(actionName)){%>  
     <!--  
     <button type="button" class="btn   btn-primary btn-sm" id="save"><i class="fa fa-pencil"> ����</i>
     </button>
      -->
     <%} %>  
     <!--      
     <button type="button" class="btn   btn-primary btn-sm" id="view"><i class="fa fa-eye "> �鿴</i>
     </button>
     <button type="button" class="btn   btn-primary btn-sm" id="back"><i class="fa fa-share-square-o"> �����б�</i>
     </button>
     -->   
<form name ="form1" id ="form1" action="#"  method="post" > 
<!--���޸��ֶ�-->
<input type="hidden" name="oldDate"  name="oldDate" value=""/>	  
<input type="hidden" name="changedProperty"  name="changedProperty" value=""/>	  
<input type="hidden" name="changedPropertyDate"  name="changedPropertyDate" value=""/> 
<!-- ��������  add ,edit, view  -->   
<input type="hidden" id="actionName" name="actionName" class=""  value="<%=actionName==null?"":actionName%>"/>  
<!--  ��¼����id -->   	
 <input type="hidden" id="pid" name="rpProject.pid" class="" />
<!--Ƭ��name  -->   	
<input type="hidden" id="region" name="rpProject.region" class="" />
<!--ʡ��name  -->	
<input type="hidden" id="province" name="rpProject.province" class="" />
<!--��ҵ���name  -->   	
<input type="hidden" id="itypename" name="rpProject.itypename" class="" />
<!--������ҵ��id  -->   	
<input type="hidden" id="deptid" name="rpProject.deptid" class="" />
<!--��Ʒid  -->   	
<input type="hidden" id="productid" name="rpProject.productid" class="" />
<!--�Ƿ�ɾ��  -->   	
<input type="hidden" id="isdelete" name="rpProject.isdelete" class="" />
<!--��������  -->   
<input type="hidden" id="updatedate" name="rpProject.updatedate" class="" />
<!-- ��¼�������� -->   
<input type="hidden" id="createdate" name="rpProject.createdate" class="" />
<hr/>
<table class="table  table-condensed table-hover">
   <caption style="text-align: center; font-size: large">��ͬ��Ŀ��</caption>
 <tbody>
 <tr>
<!--��ͬ���(��)  -->   	
<td>��ͬ��ţ��ڣ�</td><td><input type="text" id="iContractid" name="rpProject.iContractid" class="" /></td>
<td>��ͬ��ţ��⣩</td><td><input type="text" id="oContractid" name="rpProject.oContractid" class="" /></td>
<td>��ͬǩ������</td><td><input type="text" id="signdate" name="rpProject.signdate" class=""/><font color="red"> *</font></td>
</tr><tr>
<td>�б굥λ</td><td><input type="text" id="buycorp" name="rpProject.buycorp" class="" /></td>
<td>�б�����</td><td><input type="text" id="buyno" name="rpProject.buyno" class="" /></td>
<td>�ͻ�����</td><td><input type="text" id="custname" name="rpProject.custname" class="" /> <font color="red"> *</font></td>
</tr><tr>
<td>��������</td><td><input type="text" id="projectname" name="rpProject.projectname" class="" /> <font color="red"> *</font></td>
<td>��ҵ���</td><td><select id="itypeid"  name="rpProject.itypeid"></select><font color="red"> *</font></td>
<td>����Э�鷵��ʱ��	</td><td><input type="text" id="techdate" name="rpProject.techdate" class="" /></td>
</tr><tr>
<td>Ƭ��</td><td><select id="regionid"  name="rpProject.regionid"></select> <font color="red"> *</font></td>
<td>ʡ��</td><td><select id="provinceid"  name="rpProject.provinceid" disabled="disabled"></select> <font color="red"> *</font></td>

 <td>��������</td><td>
 <select id="channel" name="rpProject.channel" class="">
 <option value=""  selected="selected">��ѡ��</option>
 <option value="D">����</option>
 <option value="Z">ֱ��</option>
 </select>
 <font color="red"> *</font></td>
</tr><tr>
<td>��Ʒ����</td><td><input type="text" id="productname" name="rpProject.productname" class="" /></td>
<td>����ͺ�</td><td><input type="text" id="model" name="rpProject.model" class="" /></td>
<td>��λ</td><td><input type="text" id="danwei" name="rpProject.danwei" class="" /></td>
</tr><tr>
<td>����</td><td><input type="text" id="count" name="rpProject.count" class="" /></td>
<td>����</td><td><input type="text" id="price" name="rpProject.price" class="" /></td>
<td>���ۣ����㣩</td><td><input type="text" id="realprice" name="rpProject.realprice" class="" /></td>
</tr><tr>
<td>��ͬ��</td><td><input type="text" id="contractprice" name="rpProject.contractprice" class="" /></td>
<td>�����</td><td><input type="text" id="totalprice" name="rpProject.totalprice" class="" /></td>
<td>���۽��</td><td><input type="text" id="offerprice" name="rpProject.offerprice" class="" /></td>
</tr><tr>
<!-- 
<td>������ҵ��</td><td><input type="text" id="deptname" name="rpProject.deptname" class="" /></td>
 -->
<td>������ҵ��</td><td><select id="deptname" name="rpProject.deptname" class="" >
<option value="" selected="selected">��ѡ��</option>
<option value="����" >����</option>
<option value="���">���</option>
<option value="����Ԫ��">����Ԫ��</option>
<option value="�Ƽ�">�Ƽ�</option>
<option value="��ѹ����">��ѹ����</option>
</select>
<font color="red"> *</font>
</td>
<!-- 
<td>��ͬ״̬</td><td><input type="text" id="status" name="rpProject.status" class="" /></td>
 -->
<td>��ͬ״̬</td><td><select id="status" name="rpProject.status" class="" >
<option value="" selected="selected">��ѡ��</option>
<option value="Ԥ�б�">Ԥ�б�</option>
<option value="��ͣ">��ͣ</option>
<option value="���˲�Ʒ">���˲�Ʒ</option>
<option value="���">���</option>
</select>
<font color="red"> *</font>
</td>
 
<td>ҵ��Ա</td><td><input type="text" id="salesman" name="rpProject.salesman" class="" /></td>
</tr><tr>
<td>�ѻؿ�����</td><td><input type="text" id="refundsdate" name="rpProject.refundsdate" class="" /></td>
<!-- 
<td>�Ƿ��ѿ���Ʊ</td><td><input type="text" id="isinvoice" name="rpProject.isinvoice" class="" /></td>
 -->
<td>�Ƿ��ѿ���Ʊ</td><td><select  id="isinvoice" name="rpProject.isinvoice" class="" >
<option value ="1" selected="selected">��</option>
<span style="display: display"><option value ="0" >��</option><sapn>

</select></td>

<td>�ѻؿ���</td><td><input type="text" id="refunds" name="rpProject.refunds" class="" /></td>
</tr><tr>
<td>��Ʊ���</td><td><input type="text" id="invoicecount" name="rpProject.invoicecount" class="" /></td>
<td>��Ʊ����</td><td><input type="text" id="invoicedate" name="rpProject.invoicedate" class="" /></td>
<!-- 
<td>������ʽ</td><td><input type="text" id="supplytype" name="rpProject.supplytype" class="" /></td>
 -->
<td>������ʽ</td><td><select id="supplytype" name="rpProject.supplytype" class="" >
<option value="" selected="selected">��ѡ��</option>
<option value="Ԥ�б�">Ԥ�б�</option>
<option value="����Ʒ">����Ʒ</option>
<option value="���">���</option>
<option value="���˲�Ʒ">���˲�Ʒ</option>
</select></td>
 
</tr>
</tbody>
</table>
</form> 
<hr>
<div id="zy">
<font color="red" size="2">ע�⣺ ���� * Ϊ������</font>
</div>      
  </body>
  <script type="text/javascript">
	var region = {
  		  	"����":["����","���","�ӱ�","ɽ��","���ɹ�"],
  		  	"����":["����","����","������"],
  		  	"����":["�Ϻ�","����","�㽭","����","����","ɽ��"],
  		  	"����":["����","����","����","����"],
  		  	"����":["�㶫","����","����"],
  		  	"����":["����","�Ĵ�","����","����","����"],
  		  	"����":["����","����","�ຣ","����","�½�"],
  		  	//"̨�۰�":["̨��","���","����"]
  		  	"��ͻ�":["����","���","�ӱ�","ɽ��","���ɹ�","����","����","������","�Ϻ�","����","�㽭","����","����","ɽ��","����","����","����","����","�㶫","����","����","����","�Ĵ�","����","����","����","����","����","�ຣ","����","�½�","̨��","���","����"]
 		  	};  
	$(document).ready(function() {
	    //�ؼ���ʼ��
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
			    alert("����ʧ��");
		    }
		        
		}
			getColData("itypeid","getIndustryList","selcet","rid","industry","itypename");
			getColData("provinceid","getProvinceList","selcet","pid","provincename","province");			
			getColData("regionid","getRegionList","selcet","rid","region","region");
			
		if($("#actionName").val()=="view"){
			getData();
			showSelectOption(region[$('#regionid').find("option:selected").text()],"provinceid");		
		}
		//��ʼ������
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
			   	   alert("���ݴ�������ϵ�����Ա��")
			   }
		   });			
		}

		
		//����
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
						   alert("����ʧ�ܣ�");
						   	}else if(d==1){
						   alert("�����ɹ���");
						  
						   if(confirm("�����ɹ�,�Ƿ����������")){
							   $("#form1")[0].reset();
							  }else{
							   setDiv("../project/goto.action?gotoPage=/page/projectList.jsp?rand="+Math.random(),0);
							}
						}			   		
					   },
					   error : function(d){
						   alert("��������ʧ�ܣ�");
					   },			   
				});
			}

		})

		//�༭����
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
					   alert("�༭ʧ�ܣ�");
					   	}else if(d==1){
					   if(confirm("�༭�ɹ�,�Ƿ�������ͬ�б�")){
					   	setDiv("../project/goto.action?gotoPage=/page/projectList.jsp?rand="+Math.random(),0);
					   }else{
					   }
					}			   		
				   },
				   error : function(d){ 
					   alert("�༭����ʧ�ܣ�");
				   },			   
			   });
			}	
		})
		//regionid���� <������provinceid>
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
				if(data_arr.indexOf($(this).text())>-1){//���� ��ʾ
				}else{
					$(this).remove();
				}
			})
			$("#provinceid").get(0).selectedIndex=1;
			$("#province").val($("#provinceid").find("option:selected").text());			
		}
		
		function  bc_success(data) {
			if(data==0){
			   alert("����ʧ�ܣ�");
			   	}else if(data==1){
			   alert("����ɹ���");
			   	}
	   	}
		function  cb_error(data) {
			   alert("����ʧ�ܣ�");
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
				alert('����������');
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
						alert($(ids).parent().prev().html()+' ����Ϊ��');
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
		//array�еı���numλС��
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
		//�����ֶ�
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
