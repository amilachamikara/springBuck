/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ravinda
 */
public class TimeSlotManager {
    
    public static void setTimeSlots(int userId,JTable table){
        
           DefaultTableModel dtm = ( DefaultTableModel)table.getModel();
            int s=dtm.getRowCount();
//            System.out.println(s);
            for(int i=0;i<s;i++){
            String title=dtm.getValueAt(i, 0).toString();
            String startTime=dtm.getValueAt(i, 1).toString();
            String duration=dtm.getValueAt(i, 2).toString();
            String day=dtm.getValueAt(i, 3).toString();

           frames.JDBC jdbc =new frames.JDBC();
                try {
                    jdbc.setData("INSERT INTO time_slot(title,start_time,end_time,isWeekday) values('"+title+"','"+startTime+"','"+duration+"','"+day+"')");
                } catch (Exception ex) {
                    System.out.println(" sql statement error");
                }
            }
    }   
    
    public static void getApplicaton(int userId,JTable table){
        
         frames.JDBC jdbc = new frames.JDBC();
         try {
            ResultSet rs= jdbc.getData("select title,starttime,duration,day from TimeSlot");
            DefaultTableModel dtm=(DefaultTableModel)table.getModel();
            
            for(int i=0;i<dtm.getRowCount();i++){
                dtm.removeRow(0);
            }
           while(rs.next()){
               Vector v=new Vector();
               
             
                  v.add(rs.getString(1));
                  v.add(rs.getString(2));
                  v.add(rs.getString(3));
                  v.add(rs.getString(4));
                    dtm.addRow(v);
           }
            
            
        } catch (Exception ex) {
            System.out.println("getting data error");
        }
        
        
    }
    }
    

