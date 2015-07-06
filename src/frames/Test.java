/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amila
 */
public class Test {

    public static void main(String[] args) {

//        try {
//            ResultSet rs = JDBC.getData("select time_slot.start_time, time_slot.end_time,application.file_path,frequency,media_file.title,media_file.artist, media_file.genre from event_log, application,time_slot,media_file where application.application_id = event_log.application_id and time_slot.timeslot_id=event_log.timeslot_id and media_file.file_id=event_log.media_id");
//            while(rs.next()){
//                System.out.println(rs.getString(3).replace("&", "\\"));
//            }
//        } catch (Exception e) {
//        }
        System.out.println(new Test().isConnected(null));
        
    }

    private boolean isConnected(String url) {

        Socket socket = null;
        boolean reachable = false;
        try {
            socket = new Socket("www.google.lk", 80);
            reachable = true;
        }catch(Exception e){
            System.out.println("Error");
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
        return reachable;
    }
}
