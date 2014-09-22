package com.jing.service;
import com.jing.dao.*;
import com.jing.domain.*;
import java.util.*;

public class LoginService implements ILoginService{
	private IUserDao userDao;

    public IUserDao getuserDao(){
    	return this.userDao;
    }
    public void setuserDao(IUserDao userDao){
    	this.userDao = userDao;
    }
     
    public boolean checkLogin(User user){
       List list = this.userDao.findByUsernamePassword(user.getusername(), user.getpassword());	
       return !list.isEmpty();
    }
    
    
   
     
}