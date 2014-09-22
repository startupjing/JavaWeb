package com.jing.dao;
import com.jing.domain.User;
import java.util.*;

public interface IUserDao {
    public void insert(User u);
    public void update(User u);
    public void delete(Integer id);
    public List<Object> findByAll();
    public User findById(Integer id);
	public User updateSynn(User userNow, User u, String[] arr);
	public List findByUsernamePassword(String username, String password);

}