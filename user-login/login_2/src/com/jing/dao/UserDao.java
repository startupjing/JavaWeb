package com.jing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jing.domain.User;

public class UserDao extends JdbcDaoSupport implements IUserDao{

	@Override
	public void insert(User u) {
	   Object[] obj = {u.getUsername(), u.getPassword(),u.getCity(), u.getPhone()};
	   getJdbcTemplate().update("insert into t (username,password,city,phone) values (?,?,?,?)",obj);
		
	}

	@Override
	public void update(User u) {
	    Object[] obj = {u.getPassword(),u.getCity(), u.getPhone(), u.getUsername()};    
		getJdbcTemplate().update("update t set password=?, city=?, phone=? where username=?", obj);
		
	}

	@Override
	public void delete(String username) {
		getJdbcTemplate().update("delete from t where username='"+username+"'");
		
	}

	@Override
	public List<Map> findByAll() {
		List list = getJdbcTemplate().queryForList("select * from t");
		return list;
	}

	@Override
	public User findByUsername(String username) {
		User u = new User();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList("select * from t where username='"+username+"'");
		for(int i=0; i<list.size(); i++){
			Map map = list.get(i);
			u.setUsername(map.get("username").toString());
			u.setPassword(map.get("password").toString());
			u.setCity(map.get("city").toString());
			u.setPhone(map.get("phone").toString());
		}
		return u;
	}
	
	@Override
	 public User updateSynn(User u1, User u2, String[] arr){
         u2.setUsername(u1.getUsername());
      	if(!arr[0].equals("")){
             u2.setPassword(arr[0]);
   	    }else{
   		     u2.setPassword(u1.getPassword());
   	    }
   	    if(!arr[1].equals("")){
            u2.setCity(arr[1]);
    	}else{
    		u2.setCity(u1.getCity());
    	}
     	if(!arr[2].equals("")){
           u2.setPhone(arr[2]);
    	}else{
    		u2.setPhone(u1.getPhone());
    	}
     	return u2;
   }

}
