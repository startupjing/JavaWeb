package com.jing.dao;
import com.jing.domain.User;
import java.util.*;

public interface IUserDao {
    public void insert(User u);
    public void update(User u);
    public void delete(String username);
    public List<Map> findByAll();
    public User findByUsername(String usernmae);
	public User updateSynn(User userNow, User u, String[] arr);
}
