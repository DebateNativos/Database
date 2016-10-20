/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.ws;

import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.User;
import com.podiumcr.podiumwebapp.data.ActiveUser;
import com.podiumcr.podiumwebapp.data.LoginStatus;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Soler
 */
@Path("user")
public class ActiveUserWS {

    //cambiar al jpa para que sea wrapper
    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public LoginStatus Login(@QueryParam("email") String email, @QueryParam("password") String password) {
        LoginStatus status = new LoginStatus();
        UserData ud = new UserData();
        ActiveUser user = new ActiveUser();
        
        try {
            User u = ud.getUserByEmail(email);
            if (u.getPassword().equals(u.encryptPass(password))) {
                status.setStatus("@validLogin");
                
                user.setIdUsers(u.getIdUsers());
                user.setName(u.getName());
                user.setLastName(u.getLastName());
                user.setLastName2(u.getLastName2());
                user.setEmail(u.getEmail());
                user.setPhone(u.getPhone());
                user.setIdToken(u.getIdToken());
                user.setIdUniversity(u.getIdUniversity());
                user.setAddress(u.getAddress());
                user.setBirthday(u.getBirthday());
     
                status.setUser(user);
            } else {
                status.setStatus("@invalidPassword");
            }
        } catch (Exception e) {
            status.setStatus("@invalidEmail");
        }

        
        return status;

    }

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveUser> getUsers() {
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

    @GET
    @Path("getAll2")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersAll() {
        UserData ud = new UserData();
        return ud.getUsers();

    }

}
