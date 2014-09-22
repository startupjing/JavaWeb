package domain;

public class User {
   private String username;
   private String password;
  
   public User(String s, String n){
	   this.username = s;
	   this.password = n;
   }
  
   public String getUserName(){
	   return this.username;
   }
   
   public String getPwd(){
	   return this.password;
   }
   
   public void setUserName(String s){
	   this.username = s;
   }
   
   public void setPwd(String n){
	   this.password = n;
   }
   
   public String toString(){
	   return "Username: " + getUserName() + "; Password: " + getPwd() + ". ";
   }
   
   public boolean equal(User u){
	   return (this.username.equals(u.getUserName()) && this.password.equals(u.getPwd()));
   }
   
}
