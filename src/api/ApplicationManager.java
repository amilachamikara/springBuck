/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api;

import frames.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ravinda
 */
public class ApplicationManager {
    
    public static void setApplication(int userId,JTable table){
          DefaultTableModel dtm=(DefaultTableModel)table.getModel();
        for(int i=0;i<dtm.getRowCount();i++){
            String name=dtm.getValueAt(i, 0).toString();
            String path=dtm.getValueAt(i, 1).toString().replace('\\', '?');
                
           JDBC jdbc =new JDBC();
                try {
                    jdbc.setData("INSERT INTO Application(userid,appname,path,priority) values("+userId+",'"+name+"','"+path+"',"+i+1+")");
                } catch (Exception ex) {
                    System.out.println(" sql statement error");
                }
    }
    }
    
    
    
    
    public static void getApplication(int userId,JTable table){
        DefaultTableModel dtm=(DefaultTableModel)table.getModel();
          JDBC jdbc =new JDBC();
        try { 
            ResultSet rs= jdbc.getData("select appname,path from application where userid="+userId+"");
            for(int i=0;i<dtm.getRowCount();i++){
                dtm.removeRow(0);
            }
             while(rs.next()){
               Vector v=new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2).replace('?','\\'));
                dtm.addRow(v);
           }
        } catch (Exception ex) {
            System.out.println(ex);
        }
          
    }
    
    
}
    

