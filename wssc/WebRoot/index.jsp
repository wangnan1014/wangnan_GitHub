<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="/public/head.jspf" %>
  </head>
  
  <body>
    This is my JSP page. <br>
    
    <br>
    <a href="${pageContext.request.contextPath}/category_update.action?category.id=2&category.type=gga&category.hot=false">访问update</a> 
    <a href="category_save.action">访问save</a> 
    ${category.getType()} 
    <a href="category_query.action">查询所有类别</a><br/>
    <label>requestScope</label></br>
    <c:forEach items="${requestScope.categoryList}" var="category">
    	${category.getId()} | ${category.getType()} | ${category.getHot()} <br/>
    </c:forEach>
    <label>sessionScope</label></br>
    <c:forEach items="${sessionScope.categoryList}" var="category">
    	${category.getId()} | ${category.getType()} | ${category.getHot()} <br/>
    </c:forEach>
    <label>applicationScope</label></br>
    <c:forEach items="${applicationScope.categoryList}" var="category">
    	${category.getId()} | ${category.getType()} | ${category.getHot()} <br/>
    </c:forEach>    
  </body>
</html>
