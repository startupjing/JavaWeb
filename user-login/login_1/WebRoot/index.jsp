<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
     <h1 align="center">Registration</h1>
        <form method="post" action="LoginServlet">
            <p> <p>Name:<input type="text"  name="username" /> <br><br>
             <p> <p>Password:<input type="password" name="password" /><br><br>   
             <input type="submit" value="register" name="login" />
             <input type="submit" value="login" name="login" /><br></br>
        </form>
  </body>
</html>
