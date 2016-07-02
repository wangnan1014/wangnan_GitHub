<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.heag.rcpc.model.RpUser"%>

<%
	RpUser user = (RpUser)session.getAttribute("user");
%>
<script type="text/javascript" src="../js/passwordModify.js"></script>
<body>
<form id="form1" name="form1" action="../register/pwMod.action" method="post" >
<!-- 模态框（Modal） -->
<div class="modal fade" id="passwordModify" tabindex="-1" role="dialog" data-backdrop="static"
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" 
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	用户密码修改
            </h4>
         </div>
         <div class="modal-body">
					<input type="hidden" id = "result" name ="result" value="${result}">
					<div class="form-group">
					<label for="uname" class="col-sm-2 control-label">用户名:</label>
						<div class="">
							<p href="#" id ="u1" class="uname"  data-placement="top" data-toggle="popover" title="用户名不能为空,请输入用户名" ></p>
							<p href="#" id ="u2" class="uname"  data-placement="top"  data-toggle="popover" title="用户名不能超过10个字符！"></p>
							<p href="#" id ="u3" class="uname"  data-placement="top"  data-toggle="popover" title="对不起，没有找到用户名!"></p>
							<INPUT class="form-control" type="text" id = "uname" name ="rpuser.uname" placeholder="请输入用户名" readonly="readonly" value="<%=user.getUname()%>"/> 
						</div>		 
					</div>
					<div class="form-group">
					<label for="uname" class="col-sm-2 control-label">原始密码:</label>
						<div class="">
							<p href="#" id ="op1" class="o_password"  data-placement="top" data-toggle="popover" title="原始密码不能为空,请输入原始密码" ></p>
							<p href="#" id ="op2" class="o_password"  data-placement="top" data-toggle="popover" title="原始密码不正确！" ></p>
							
							<INPUT class="form-control" type="text" id = "o_password" name ="o_password" placeholder="请输入原始密码" value=""/> 

						</div>		 
					</div>
					
					<div class="form-group">
					<label for="password" class="col-sm-2 control-label">新密码:</label>
						<div class="">
							<p href="#" id = "p1" class="password" data-placement="top" data-toggle="popover" title="新密码不能为空,请重新输入！"></p>
							<INPUT class="form-control" id="password" name ="rpuser.password" type="password" placeholder="请输入新密码" value=""/>		
						</div>
					</div>
					
					<div class="form-group">
					<label for="repassword" class="col-sm-2 control-label">密码确认:</label>
						<div class="">
							<p href="#" id = "rp1"  class="repassword" data-placement="top"  data-toggle="popover" title="确认密码与新密码不一致！"></p>
							<INPUT class="form-control" id="repassword"  name ="repassword" type="password" placeholder="请输入密码确认" value=""/>   
						</div>
					</div>
         </div>
         <div class="modal-footer" >

	            <button type="button" class="btn btn-primary  btn-sm btn-outline" onclick="passwordMod()">
	              	修&nbsp&nbsp&nbsp改
	            </button>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</form>
</body>
