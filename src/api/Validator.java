
package api;

import frames.JDBC;
import java.sql.ResultSet;


public class Validator {
    public static boolean isValidUser(String username, String password){
        
        boolean isValid = false;
        
        try {
            ResultSet rs = new JDBC().getData("SELECT password FROM users WHERE username = '"+username+"'");
            rs.next();
            
            if(rs.getString("password").equals(password)){
                isValid = true;
            }else{
                isValid = false;
            }
            
        } catch (Exception ex) {
            isValid = false;
            System.out.println(ex);
        }
        
        
        return isValid;
    }
}
