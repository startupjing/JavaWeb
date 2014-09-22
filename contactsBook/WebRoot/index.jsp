<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <c:choose>
    <c:when test="${empty sessionScope.user}">
     <h1 align="center">Welcome Page</h1>
     <c:if test="${!empty message}">${message}</c:if>
    <form method="post" action="LoginController.html?method=login">
        <p><p>Username:<input type="text" name="username" /> <br><br>
        <p><p>Password:<input type="password" name="password" /><br><br>
        <p><p><input type="submit" value="login"><br><br>
        <p><p><a href="insert.jsp">New User? Click to Register</a><br><br>  
     </form>
     </c:when>
     <c:otherwise>
        <p><p>Welcome! ${sessionScope.user.username}<br><br>
        <p><p><c:if test="${!empty message}">${message}</c:if><br><br>
        <p><p><a href="UserController.html?method=findByAll">return</a><br><br>
        <p><p><a href="logout.jsp">logout</a><br><br>
     </c:otherwise>
     </c:choose>
  </body>
</html>
