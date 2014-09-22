package com.jing.controller;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jing.dao.*;
import com.jing.domain.*;
import com.jing.service.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpSession;

public class LoginController extends MultiActionController{
     private LoginService loginService;
     
     public LoginService getloginService(){
    	 return this.loginService;
     }
     
     public void setloginService(LoginService loginService){
    	 this.loginService = loginService;
     }
  
     public ModelAndView login(HttpServletRequest req, HttpServletResponse res){
    	 User u = new User();
    	 
    	 u.setusername(req.getParameter("username"));
     	 u.setpassword(req.getParameter("password"));
     	 
     	 if(this.loginService.checkLogin(u)){
     		List l = this.loginService.getuserDao().findByUsernamePassword(u.getusername(),u.getpassword());
     		User user = (User)l.get(0);
     		req.getSession().setAttribute("user", user);
     		List<Object> list = this.loginService.getuserDao().findByAll();
     		ModelAndView mv = new ModelAndView("display");
     		mv.addObject("list",list);
        	return mv;
     	 }else{
     		 return new ModelAndView("index", "message", "Wrong information");
     	 }
     }
}
