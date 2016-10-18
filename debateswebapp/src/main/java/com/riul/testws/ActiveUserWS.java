/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riul.testws;

import com.riul.data.ActiveUser;
import com.riuldebates.data.UserData;
import com.riuldebates.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Soler
 */    
@Path("/user")
public class ActiveUserWS {

    
    @GET
    @Path("email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ActiveUser getUserByEmail(@PathParam("email")String email){
        UserData ud = new UserData();
        User u = ud.getUserByEmail(email);
        ActiveUser au = new ActiveUser();
        au.setIdUsers(u.getIdUsers());
        au.setName(u.getName());
               
        return au;
            
    }
    
    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveUser> getUsers(){
        UserData ud = new UserData();
        List<ActiveUser> lau = new ArrayList<>();   
          for (User user : ud.getUsers()) {
            ActiveUser au = new ActiveUser();
            au.setName(user.getName());
            au.setIdUsers(user.getIdUsers());
            lau.add(au);
        }
        
        return lau;
        
    }
}
