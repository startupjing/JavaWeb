package com.jing.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.jing.domain.User;

public class UserDao extends HibernateDaoSupport implements IUserDao{

	@Override
	//@Transactional(propagation=Propagation.REQUIRED)
	public void insert(User u) {
	   getHibernateTemplate().save(u);

	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED)
	public void update(User u) {
	   getHibernateTemplate().update(u);
	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Integer id) {
		User u =(User)getHibernateTemplate().load(User.class, id);
		getHibernateTemplate().delete(u);
	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED)
	public List<Object> findByAll() {
		return  getHibernateTemplate().find("from User u order by id asc");
	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public User findById(Integer id) {
		return (User)getHibernateTemplate().get(User.class, id);
	}


	@Override
	public List findByUsernamePassword(String username, String password){
		return (List)getHibernateTemplate().find("from User u where u.username='"+username+"' and u.password='"+password+"'");	
	}

	@Override
	 public User updateSynn(User u1, User u2, String[] arr){
         u2.setusername(u1.getusername());
         u2.setid(u1.getid());
         
      	if(!arr[0].equals("")){
             u2.setpassword(arr[0]);
   	    }else{
   		     u2.setpassword(u1.getpassword());
   	    }
      	
   	    if(!arr[1].equals("")){
            u2.setcity(arr[1]);
    	}else{
    		u2.setcity(u1.getcity());
    	}
   	    
     	if(!arr[2].equals("")){
           u2.setphone(arr[2]);
    	}else{
    		u2.setphone(u1.getphone());
    	}
     	
     	return u2;
   }

}