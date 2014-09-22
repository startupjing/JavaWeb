package com.jing.service;
import com.jing.dao.*;
import com.jing.domain.*;

public class LoginService implements ILoginService{
	private IUserDao userDao;
	 
    public IUserDao getuserDao(){
    	return this.userDao;
    }
    public void setuserDao(IUserDao userDao){
    	this.userDao = userDao;
    }
     
    public boolean checkLogin(User user){
       User u = this.userDao.findByUsername(user.getUsername());
       if(u.getPassword()==null){
    	  return false;
       }else{
    	  return u.getPassword().equals(user.getPassword());
       }
    }
    
   
     
}
