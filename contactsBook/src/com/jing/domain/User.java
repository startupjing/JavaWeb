package com.jing.domain;

public class User {

	private Integer id;
    private String username;
    private String password;
    private String phone;
    private String city;

    public Integer getid(){
    	return this.id;
    }
    
    public String getusername(){
    	return this.username;
    }
    
    public String getpassword(){
    	return this.password;
    }
    
    public String getphone(){
    	return this.phone;
    }
    
    public String getcity(){
    	return this.city;
    }
    
    public void setid(Integer id){
    	this.id = id;
    }
    public void setusername(String username){
    	this.username = username;
    }
    
    public void setpassword(String password){
    	this.password = password;
    }
    
    public void setphone(String phone){
    	this.phone = phone;
    }
    
    public void setcity(String city){
    	this.city = city;
    }
   
}