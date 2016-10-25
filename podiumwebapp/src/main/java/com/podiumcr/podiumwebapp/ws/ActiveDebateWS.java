/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.ws;

import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.podiumwebapp.data.ActiveDebate;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Soler
 */
@Path("debate")
public class ActiveDebateWS {
    
      //cambiar al jpa para que sea wrapper
    @GET
    @Path("/activedebates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveDebate> getActiveDebates() {
        DebateData dd = new DebateData();
        List<ActiveDebate> debatesList = new ArrayList<>();   
        try {
            for (Debate d : dd.getActiveDebates()) {
               ActiveDebate ad = new ActiveDebate();
               ad.setName(d.getName());
               ad.setIdDebates(d.getIdDebates());
               ad.setDebateType(d.getDebateType());
               ad.setStartingDate(d.getStartingDate());
               debatesList.add(ad);
            }
           
        } catch (Exception e) {

        }

        
        return debatesList;

    }
}
