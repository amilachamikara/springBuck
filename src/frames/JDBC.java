/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Amila Chamikara
 */
public class JDBC {

    private static Connection c = null;
    private static final String url = "jdbc:mysql://localhost:3306/mediaorg";

    private static Connection createConnection() throws Exception {
        if (c == null) {
            //Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, "root", "admin");
            return c;
        } else {
            return c;
        }
    }

    public static void startTransaction()throws Exception{
        createConnection().setAutoCommit(false);
    }
    
    public static void commitTransaction(){
        try {
            createConnection().commit();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static void rollbackTransaction(){
        try {
            createConnection().rollback();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static void setData(String query) throws Exception {
        createConnection().createStatement().executeUpdate(query);
    }

    public static ResultSet getData(String query) throws Exception {
        return createConnection().createStatement().executeQuery(query);
    }
    
    public static void deleteAllFrom(String...tableList)throws Exception{
        for(String table:tableList){
            setData("DELETE FROM "+table);
        }
    }
        

}
