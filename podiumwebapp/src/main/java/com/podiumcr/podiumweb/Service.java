/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;


import com.podiumcr.jpa.data.DebateData;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.User;
import com.podiumcr.jpa.entities.Debate;
import static com.podiumcr.podiumwebapp.common.EntityListener.em;
import java.util.List;
/**
 *
 * @author Joss
 */
@ManagedBean(name="service")
@ApplicationScoped

public class Service {

    UserData data = new UserData(em);
    DebateData dData = new DebateData(em);
    
   
    public Service() {
    }

    /**
     * Creates a new instance of Service
     * @return 
     */
    
    public List<User> createUser() {
        List<User> list = data.getUsers();
        
        return list;
    }

    public List<Debate> createDebate() {
        List<Debate> dList = dData.getDebates();
        return dList;
    }

  
  
    
    
}
