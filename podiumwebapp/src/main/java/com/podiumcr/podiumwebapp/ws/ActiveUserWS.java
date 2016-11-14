/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.ws;

import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.User;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import com.podiumcr.podiumwebapp.data.ActiveUser;
import com.podiumcr.podiumwebapp.data.LoginStatus;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public LoginStatus loginUser(@QueryParam("email") String email, @QueryParam("password") String password) {
        EntityManager em = entityManagerFactory.createEntityManager();
        LoginStatus status = new LoginStatus();
        UserData ud = new UserData(em);
        ActiveUser user = new ActiveUser();

        try {
            User u = ud.getUserByEmail(email);
            if (u.getPassword().equals(u.encryptPass(password))) {
                status.setStatus("@validLogin");

                user.setName(u.getName());
                user.setLastName(u.getLastName());
                user.setLastName2(u.getLastName2());
                user.setEmail(u.getEmail());
                user.setPhone(u.getPhone());
                user.setIdToken(u.getIdToken());
                user.setIdUniversity(u.getIdUniversity());
                user.setAddress(u.getAddress());

                status.setUser(user);
                em.close();
            } else {
                status.setStatus("@invalidPassword");
                em.close();
            }
        } catch (Exception e) {
            status.setStatus("@invalidEmail");
            em.close();
        }

        return status;

    }
 
    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveUser> getUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        UserData ud = new UserData(em);
        List<ActiveUser> lau = new ArrayList<>();
        for (User user : ud.getUsers()) {
            ActiveUser au = new ActiveUser();
            au.setName(user.getName());
            au.setEmail(user.getEmail());
            lau.add(au); 
        }
        em.close();
        return lau;
    }

    @GET
    @Path("registeruser")
    @Produces(MediaType.TEXT_PLAIN)
    public String registerUser(@QueryParam("name") String name, @QueryParam("lastname") String lastname,
            @QueryParam("lastname2") String lastname2, @QueryParam("email") String email,
            @QueryParam("password") String password, @QueryParam("phone") String phone,
            @QueryParam("address") String address,
            @QueryParam("idUniversity") int idUniversity){
        String status = "";
        EntityManager em = entityManagerFactory.createEntityManager();
        UserData ud = new UserData(em);
            //DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            //Date birthdateFormated = df.parse(birthday);
            if (ud.registerUser(new User(email, password, address, name, lastname, lastname2,  idUniversity, false, phone))) {
                 status = "@validRegistration";    
            }else{
            status = "@invalidRegistration";
            }
        return status;

    }
}
