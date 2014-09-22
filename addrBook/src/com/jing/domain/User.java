package com.jing.domain;

public class User {
    private String username;
    private String password;
    private String phone;
    private String city;
 
    public String getUsername(){
    	return this.username;
    }
    
    public String getPassword(){
    	return this.password;
    }
    
    public String getPhone(){
    	return this.phone;
    }
    
    public String getCity(){
    	return this.city;
    }
    
    public void setUsername(String s){
    	this.username = s;
    }
    
    public void setPassword(String s){
    	this.password = s;
    }
    
    public void setPhone(String s){
    	this.phone = s;
    }
    
    public void setCity(String s){
    	this.city = s;
    }
    
    public String toString(){
    	return "username is "+getUsername()+"  password is "+getPassword()
    			+"  city is "+getCity() + " phone is "+getPhone();
    }
}
