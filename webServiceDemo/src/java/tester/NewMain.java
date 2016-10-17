/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import com.riuldebates.data.UserData;
import com.riuldebates.entities.User;

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
        for (User user : ud.getUsers()) {
            
            System.out.println("Usuario: ");
            System.out.println("- "+user.getName() + " " + user.getLastName() + " " + user.getEmail());
            System.out.println("");
            
        }
    
    }
    
}
