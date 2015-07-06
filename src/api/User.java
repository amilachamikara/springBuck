package api;

import frames.JDBC;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

public class User {

    public static void createUser(String username, String password, String imageURL) {
        int nextUserId = 0;
        try {
            ResultSet rs = new JDBC().getData("SELECT MAX(user_id) as userid FROM users");
            rs.next();
            nextUserId = rs.getInt("userid")+1;
        } catch (Exception e) {
        }
        
        
        try {
            new JDBC().setData("INSERT INTO users(user_id,username, password, image_url) VALUES("+nextUserId+",'"+username+"','"+password+"','"+imageURL+"')");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        try {
            File f = new File("src/settings/"+username+".properties");
            f.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    
    
    public static void removeUser(String username){
        try {
            new JDBC().setData("DELETE FROM users WHERE username = '"+username+"'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
