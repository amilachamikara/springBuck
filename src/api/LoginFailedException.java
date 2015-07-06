/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api;

/**
 *
 * @author Amila
 */
public class LoginFailedException extends Exception{

    @Override
    public String toString() {
        return "Login to online server faild exception";
    }
    
}
