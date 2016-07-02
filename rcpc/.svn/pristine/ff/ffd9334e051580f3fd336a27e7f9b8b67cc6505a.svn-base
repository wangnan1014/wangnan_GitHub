<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.heag.rcpc.service.impl.RpRoleServiceImpl"%>
<%@ page import="com.heag.rcpc.service.IRpRoleService"%>
<%@ page import="com.heag.rcpc.model.RpRole"%>
<%@ page import="com.heag.rcpc.model.RpCompany"%>
<%@ page import="com.heag.rcpc.model.RpDepartment"%>
<%@ page import="com.heag.rcpc.util.ConstantsUtil" %>
<%@page import="com.heag.rcpc.model.RpUser"%>

<%
RpUser user = (RpUser)session.getAttribute("user");
ArrayList<RpCompany> al_comp = (ArrayList<RpCompany>)request.getAttribute("al_comp");
ArrayList<RpDepartment> al_dept = (ArrayList<RpDepartment>)request.getAttribute("al_dept");
ArrayList<RpRole> al_role = (ArrayList<RpRole>)request.getAttribute("al_role");
String actionName = (String)request.getParameter("actionName");
String uid = (String)request.getParameter("uid");


%>
<script type="text/javascript" src="../js/WebTool.js"></script>
<script type="text/javascript" src="../js/register.js"></script>
  
<body>
<form id="form1" name="form1" action="../register/register.action" method="post" >
<!-- 模态框（Modal）1 -->
<div class="modal fade" id="register" tabindex="-1" role="dialog"  data-backdrop="static"
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" 
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">用户注册</h4> 
         </div>
         <div class="modal-body">
					<!--表修改字段-->
					<input type="hidden" name="oldDate"  name="oldDate" value=""/>	  
					<input type="hidden" name="changedProperty"  name="changedProperty" value=""/>	  
					<input type="hidden" name="changedPropertyDate"  name="changedPropertyDate" value=""/> 
					<!-- 操作类型  add ,edit, view  -->   
					<input type="hidden" id="actionName" name="actionName" class=""  value="<%=actionName==null?"":actionName%>"/>  
					
					<input type="hidden" id="uid" name="rpuser.uid" class=""  value="<%=uid==null?"":uid%>"/> 
					<input type="hidden" id = "result" name ="result" value="${result}">
					
					<input type="hidden" id = "cname" name ="rpuser.cname" value="">
					<input type="hidden" id = "deptname" name ="rpuser.deptname" value="">
					<input type="hidden" id = "rolename" name ="rpuser.rolename" value="">
					
					<div class="form-group">
					<label for="uname" class="col-sm-2 control-label">用户名:</label>
						<div class="">
							<p href="#" id ="u1" class="uname"  data-placement="top" data-toggle="popover" title="用户名不能为空,请输入用户名" ></p>
							<p href="#" id ="u2" class="uname"  data-placement="top"  data-toggle="popover" title="用户名不能超过10个字符！"></p>
							<p href="#" id ="u3" class="uname"  data-placement="top"  data-toggle="popover" title="该用户已存在！"></p>
							<INPUT class="form-control" type="text" id = "uname" name ="rpuser.uname" placeholder="请输入用户名" value=""> 
						</div>		 
					</div>
					<div class="form-group">
					<label for="uname" class="col-sm-2 control-label">姓名:</label>
						<div class="">
							<INPUT class="form-control" type="text" id = "realname" name ="rpuser.realname" placeholder="请输入姓名" value=""> 
						</div>		 
					</div>	
				
					<div class="form-group">
					<p href="#" id ="cid1" class="cid"  data-placement="top"  data-toggle="popover" title="请选择所属公司！"></p>
					<label   class="col-sm-2 control-label">所属公司:</label>
						 
						<select class="form-control" name="rpuser.cid" id="cid">
							 <option value="">默认选择</option>
							 
				        </select>		 
				 	 
					</div>	
					<div class="form-group">		
					<p href="#" id ="deptid1" class="deptid"  data-placement="top"  data-toggle="popover" title="请选择所属部门！"></p>
							
					<label  class="col-sm-2 control-label">所属部门:</label>
						<select class="form-control" name="rpuser.deptid"  id="deptid">
							 <option value="">默认选择</option>
							
				        </select>
					</div>	
					<div class="form-group">
					<p href="#" id ="roleid1" class="roleid"  data-placement="top"  data-toggle="popover" title="请选择角色！"></p>
					
					<label  class="col-sm-2 control-label">角色:</label>
						<select class="form-control" name="rpuser.roleid"  id="roleid">
							 <option value="">默认选择</option>
			
				        </select>

					</div>
					<%if("add".equals(actionName)){ %>	
					<div class="form-group">
					<label for="password" class="col-sm-2 control-label">密码:</label>
						<div class="">
							<p href="#" id = "p1" class="password" data-placement="top" data-toggle="popover" title="密码不能为空,请输入密码！"></p>					
							<INPUT class="form-control" id="password" name ="rpuser.password" type="password" placeholder="请输入密码" value="<%=ConstantsUtil.INITPASSWOER %>" readonly="readonly">		
						</div>
					</div>

					<div class="form-group">
					<label for="repassword" class="col-sm-2 control-label">密码确认:</label>
						<div class="">
							<p href="#" id = "rp1"  class="repassword" data-placement="top"  data-toggle="popover" title="确认密码与密码不一致！"></p>
							<INPUT class="form-control" id="repassword"  name ="repassword" type="password" placeholder="请输入密码确认" value="<%=ConstantsUtil.INITPASSWOER %>" readonly="readonly">   
						</div>
					</div>
					<%} %>
         </div>
         <div class="modal-footer" >
         <%if("add".equals(actionName)){ %>
	            <button type="button" class="btn btn-primary btn-sm btn-outline" onclick="register('add')">注&nbsp&nbsp&nbsp册</button>
         <%}else if("view".equals(actionName)){ %>
         	    <button type="button" class="btn btn-primary btn-sm btn-outline" onclick="register('save')">保&nbsp&nbsp&nbsp存</button>
         <%} %>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</form>
</body>
