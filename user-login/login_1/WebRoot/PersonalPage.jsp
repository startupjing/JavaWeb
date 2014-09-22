<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'PersonalPage.jsp' starting page</title>

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
    <h1 align="center">Your Personal Page</h1>
    <form method="post" action="PageLoginServlet">
         <p> <p>Name:<input type="text"  name="username" />
         <p> <p>Password:<input type="password" name="password" />
         <input type="submit" value="unregister" name="page" /><br><br>
         <p> <p>New Password:<input type="password" name="newpassword" />
         <input type="submit" value="updatepassword" name="page" />
         <br><br>
         <input type="submit" value="logout" name="page" /><br><br>
    </form>
  </body>
</html>
