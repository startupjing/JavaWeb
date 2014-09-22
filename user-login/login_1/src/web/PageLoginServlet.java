package web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;
import domain.User;
import dao.LoginDao;
public class PageLoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = new User(request.getParameter("username"), request.getParameter("password"));
		
		if(request.getParameter("page").equals("logout")){
			response.sendRedirect("index.jsp");
	    }else if(request.getParameter("page").equals("unregister")){
	    	if(LoginService.isCorrect(u)){
	    	   LoginDao.delete(u);
	    	   response.getWriter().write("<a href='http://localhost:8082/WebApp/index.jsp'>Your account has been deleted</a>");
	    	}else{
	    		response.getWriter().write("<a href='http://localhost:8082/WebApp/PersonalPage.jsp'>Wrong information. Please enter again.</a>");
	    	}
	    }else if(request.getParameter("page").equals("updatepassword")){
	    	if(LoginService.isCorrect(u) && LoginService.isValid(request.getParameter("newpassword"))){
	    	   LoginDao.update(u, request.getParameter("newpassword"));
	    	   response.getWriter().write("<a href='http://localhost:8082/WebApp/PersonalPage.jsp'>Your password has been updated</a>");
	    	}else if(!LoginService.isValid(request.getParameter("newpassword"))){
	    		response.getWriter().write("<a href='http://localhost:8082/WebApp/PersonalPage.jsp'>Invalid new password</a>");
	    	}else{
	    		response.getWriter().write("<a href='http://localhost:8082/WebApp/PersonalPage.jsp'>Wrong user information</a>");
	    	}
	    }else{
	    	response.sendRedirect("PersonalPage.jsp");
	    }
   }
}
