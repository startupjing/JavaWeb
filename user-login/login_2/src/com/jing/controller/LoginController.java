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
    	 u.setUsername(req.getParameter("username"));
     	 u.setPassword(req.getParameter("password"));
     	 if(this.loginService.checkLogin(u)){
     		
     		req.getSession().setAttribute("user", this.loginService.getuserDao().findByUsername(u.getUsername()));
     		List<Map> list = this.loginService.getuserDao().findByAll();
     		ModelAndView mv = new ModelAndView("display");
     		mv.addObject("list",list);
        	return mv;
     	 }else{
     		 return new ModelAndView("index", "message", "Wrong information");
     	 }
     }
}
