/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;


import com.podiumcr.jpa.data.DebateData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.User;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.Professor;
import static com.podiumcr.podiumwebapp.common.EntityListener.em;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static org.glassfish.grizzly.http.server.Constants.a;
import static org.glassfish.grizzly.http.util.Constants.a;
import org.primefaces.event.RowEditEvent;
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
