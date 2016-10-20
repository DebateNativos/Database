/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.ws;

import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.User;
import org.apache.commons.codec.digest.DigestUtils;


/**
 *
 * @author Soler
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserData ud = new UserData();  
        String encripted = DigestUtils.md5Hex("123");
        //System.out.println(""+ud.getUserByEmail("@gmail").getName())
        System.out.println("pass: " + encripted);
        for (User user : ud.getUsers()) {
            
            System.out.println("Usuario: ");
            System.out.println("- "+user.getName() + " " + user.getLastName() + " " + user.getEmail() + " " );
            //+ user.getDebates().get(0).getName()   probar en el proximo build
            
        }
        
    }
    
}
