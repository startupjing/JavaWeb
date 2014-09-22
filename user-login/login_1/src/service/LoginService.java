package service;
import dao.LoginDao;
import domain.User;

public class LoginService {
	
     
     public static boolean hasUser(User u){
    	 return LoginDao.query(u)!=null;
     }
     
     public static boolean isCorrect(User u){
    	 return hasUser(u) && LoginDao.query(u).equal(u);
     }
     
     public static boolean isUserInfoValid(User u){
    	 return u.getUserName().length()>0 && u.getPwd().length()>0;
     }
     
     public static boolean isValid(String s){
    	 return s.length()>0;
     }
}
