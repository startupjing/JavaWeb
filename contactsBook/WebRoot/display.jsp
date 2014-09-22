<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'display.jsp' starting page</title>

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
    <table>
     
       <tr>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;ID</td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;Username</td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;Password</td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;City</td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;Phone</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="row">
           <tr>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;${item.id}</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;${item.username}</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;${item.password}</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;${item.city}</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;${item.phone}</td>
              <%-- <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="UserController.html?method=findById&id=${item.id}">update</a></td>
                <td>&nbsp;&nbsp;<a href="UserController.html?method=delete&id=${item.id}">delete</a></td> --%>
                
              <c:if test ="${sessionScope.user.id == item.id}">
                <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="UserController.html?method=findById&id=${item.id}">update</a></td>
                <td>&nbsp;&nbsp;<a href="UserController.html?method=delete&id=${item.id}">delete</a></td>
              </c:if>
            </tr>
        </c:forEach>
    </table>
  </body>
</html>
