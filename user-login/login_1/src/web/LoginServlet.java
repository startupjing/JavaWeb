package web;
import service.LoginService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import dao.LoginDao;
import domain.User;

public class LoginServlet extends HttpServlet{
 

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doGet(request, response);
	}
	 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	User u = new User(request.getParameter("username"), request.getParameter("password"));
    	
    	if(request.getParameter("login").equals("register")){		
        	if(LoginService.hasUser(u)){
        		response.getWriter().write("<a href='http://localhost:8082/WebApp/index.jsp'>You have registered before(click to return)</a>");
        		//request.getRequestDispatcher("Error.jsp").forward(request, response);
        	}else if(!LoginService.isUserInfoValid(u)){
        		response.getWriter().write("<a href='http://localhost:8082/WebApp/index.jsp'>Invalid input</a>");
        	}else{
        		LoginDao.insert(u);
        	    response.getWriter().write("<a href='http://localhost:8082/WebApp/index.jsp'>You are successfully registered!</a>");
        	    //request.getRequestDispatcher("Welcome.jsp").forward(request, response);
        	}
    	}else if(request.getParameter("login").equals("login")){
    		if(LoginService.isCorrect(u)){
    	        //response.sendRedirect("PersonalPage.jsp");
    		
    		    request.getRequestDispatcher("PersonalPage.jsp").forward(request,response);
    		}else{
    			response.getWriter().write("<a href='http://localhost:8082/WebApp/index.jsp'>No user found(click to return)</a>");
    		}
    	}else if(request.getParameter("page").equals("logout")){
    		response.sendRedirect("index.jsp");
    	}
   }
   
   
}
