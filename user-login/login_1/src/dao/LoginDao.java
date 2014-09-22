package dao;
import java.sql.*;

import domain.User;

public class LoginDao {
   public static User query(User u){
	   try{  
		    Statement stat = buildConnection();
		    String query = "select * from test where username= '"+u.getUserName()+ "'";
		    System.out.println(query);
		    ResultSet rs =  stat.executeQuery(query);
		    while(rs.next()){
		        String result = rs.getString("username");
		        String result2 = rs.getString("password");
		        System.out.println(result);
		        System.out.println(result2);
		        rs.close();
			    stat.close();
			    return new User(result,result2);
		    }
		    return null;
	     }catch(SQLException ex) {        
	        while (ex != null) {  
	           ex.printStackTrace();
	           ex = ex.getNextException();
	        }         
	     }catch(Exception e){
	         System.out.println("unknown error");
	         e.printStackTrace();
	     }
	     return null;
	  }
   
   
   public static void insert(User u){
	   try{   
		   Statement stat = buildConnection();
		    String query = "insert into test (username,password) values ('"+u.getUserName()+"', "+u.getPwd()+")";
		    stat.executeUpdate(query);
		    stat.close();
	     }catch(SQLException ex) {        
	        while (ex != null) {  
	           ex.printStackTrace();
	           ex = ex.getNextException();
	        }         
	     }catch(Exception e){
	         System.out.println("unknown error");
	         e.printStackTrace();
	     }
   }
   
   public static void delete(User u){
	   try{  
		    Statement stat = buildConnection();
		    String query = "delete from test where username = '"+u.getUserName()+"'";
		    stat.executeUpdate(query);   
		    stat.close();
	     }catch(SQLException ex) {        
	        while (ex != null) {  
	           ex.printStackTrace();
	           ex = ex.getNextException();
	        }         
	     }catch(Exception e){
	         System.out.println("unknown error");
	         e.printStackTrace();
	     }
   }
   
   public static void update(User u, String newPwd){
	   try{ 
		    Statement stat = buildConnection();
		    String query = "update test set password="+newPwd+" where username= '"+u.getUserName()+"'";
		    stat.executeUpdate(query);	    
		    stat.close();
	     }catch(SQLException ex) {        
	        while (ex != null) {  
	           ex.printStackTrace();
	           ex = ex.getNextException();
	        }         
	     }catch(Exception e){
	         System.out.println("unknown error");
	         e.printStackTrace();
	     }
   }
   
   public static void printResult(ResultSet rs) {
		try {
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int numberOfColumns = rsmd.getColumnCount();
		    int rowCount = 1;
		    while (rs.next()) { 
			System.out.print("Row " + rowCount + ":  ");
			for (int i = 1; i <= numberOfColumns; i++) {
			    System.out.print(rs.getString(i)+" ");
			}
			System.out.println("");
			rowCount++;
		    }
		} catch (SQLException e) {
		    System.out.println("SQLException: " + e.getMessage());
		    e.printStackTrace();
		    System.exit(-1);
		}
  }
   
  public static Statement buildConnection(){
	  try{  
	   		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();		
	   		String url = "jdbc:oracle:thin:@your_address:1521:orcl";
	   		String user ="your_username";
	   		String password = "your_password";			
			Connection conn = DriverManager.getConnection(url,user,password); 
		    return conn.createStatement();    
	     }catch(ClassNotFoundException en){
	     	 System.out.println("cannot find driver");
	     	 en.printStackTrace(); 
	     }catch(SQLException ex) {        
	        while (ex != null) {  
	           ex.printStackTrace();
	           ex = ex.getNextException();
	        }         
	     }catch(Exception e){
	         System.out.println("unknown error");
	         e.printStackTrace();
	     }
	     return null;
  }
	    
   
  
}
	
	

