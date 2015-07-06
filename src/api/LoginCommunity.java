/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Ravinda Lakshan
 */
public class LoginCommunity {

    /**
     * @param args the command line arguments
     */
    
    
   

    public int log(String u_name,String pwd) throws LoginFailedException{
        
        String uname=u_name;
        String pass=pwd;
        int userid=0;
        try {
            // open a connection to the site
            URL url = new URL("http://ravindalakshan-learningwithme.rhcloud.com/jasonexample.php");
            //URLConnection con = url.openConnection();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // activate the output
            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());
            // send your parameters to your site
            ps.print("username="+u_name+"");
            ps.print("&password="+pass+"");
            
            // we have to get the input stream in order to actually send the request
            // con.getInputStream();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            try {
                  
                line= in.readLine();
               // System.out.println(line);
                if(line.equals(""))
                {
                    System.out.println("not logged");
                    throw new LoginFailedException();
                }  else {
                    userid=Integer.parseInt(line);
                    PlaylistFile.writeFile(userid);
                }            
                
               return userid;
            } catch (IOException ex) {
                    System.out.println(ex);
                }
            
            // close the print stream
            ps.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
   
    
    
 }
    

