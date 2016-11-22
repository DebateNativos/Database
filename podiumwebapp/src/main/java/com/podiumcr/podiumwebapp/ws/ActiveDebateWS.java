/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.ws;

import com.podiumcr.jpa.data.ConfirmedUserData;
import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.DebateSectionData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.ConfirmedUser;
import com.podiumcr.jpa.entities.Debate;
import com.podiumcr.jpa.entities.DebateSection;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import com.podiumcr.podiumwebapp.data.ActiveDebate;
import com.podiumcr.podiumwebapp.data.ActiveDebateSections;
import com.podiumcr.podiumwebapp.data.ConfirmedDebFromUsr;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Soler
 */
@Path("debate")
public class ActiveDebateWS {

    //cambiar al jpa para que sea wrapper
    @GET
    @Path("/getdebates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveDebate> getDebates() {
        EntityManager em = entityManagerFactory.createEntityManager();
        DebateData dd = new DebateData(em);
        List<ActiveDebate> debatesList = new ArrayList<>();
        try {
            for (Debate d : dd.getDebates()) {
                ActiveDebate ad = new ActiveDebate();
                ad.setName(d.getName());
                ad.setIdDebates(d.getIdDebates());
                ad.setDebateType(d.getDebateType().getName());
                ad.setDebateTypeId(d.getDebateType().getIdDebateTypes());
                ad.setStartingDate(d.getStartingDate());
                ad.setIsActive(d.getIsActive());
                debatesList.add(ad);
            }
            em.close();
        } catch (Exception e) {
            em.close();
        }
        return debatesList;

    }

    @GET
    @Path("/getactualdebates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveDebate> getActualDebates() {
        EntityManager em = entityManagerFactory.createEntityManager();
        DebateData dd = new DebateData(em);
        List<ActiveDebate> debatesList = new ArrayList<>();
        try {
            for (Debate d : dd.getActualDebates()) {
                ActiveDebate ad = new ActiveDebate();
                ad.setName(d.getName());
                ad.setIdDebates(d.getIdDebates());
                ad.setDebateType(d.getDebateType().getName());
                ad.setDebateTypeId(d.getDebateType().getIdDebateTypes());
                ad.setStartingDate(d.getStartingDate());
                ad.setIsActive(d.getIsActive());
                debatesList.add(ad);
            }
            em.close();
        } catch (Exception e) {
            em.close();
        }
        return debatesList;

    }

    //cambiar al jpa para que sea wrapper
    @GET
    @Path("/confirmeddebates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConfirmedDebFromUsr> getConfirmedDebates(@QueryParam("email") String email) {
        EntityManager em = entityManagerFactory.createEntityManager();
        ConfirmedUserData cud = new ConfirmedUserData(em);
        UserData ud = new UserData(em);
        List<ConfirmedDebFromUsr> lcu = new ArrayList<>();
        try {
            for (ConfirmedUser cuser : cud.getDebatesFromUser(ud.getUserByEmail(email))) {
                ConfirmedDebFromUsr cdu = new ConfirmedDebFromUsr();
                cdu.setRole(cuser.getRole().getIdRole());
                cdu.setWarning(cuser.getWarnings());
                cdu.setDebate(cuser.getDebate().getIdDebates());
                lcu.add(cdu);
            }
            em.close();
        } catch (Exception e) {
            em.close();
        }
        return lcu;
    }

    @GET
    @Path("/getsections")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveDebateSections> getSections(@QueryParam("id") int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        DebateData dd = new DebateData(em);
        DebateSectionData dsd = new DebateSectionData(em);
        List<ActiveDebateSections> sectionsList = new ArrayList<>();
        try {
            for (DebateSection ds : dsd.getAllBydebate(dd.getDebateById(id).getDebateType())) {
                ActiveDebateSections ads = new ActiveDebateSections(ds.getSections(), ds.getMinutesPerUser(), ds.getIsActiveSection());
                sectionsList.add(ads);
            }
            em.close();
        } catch (Exception e) {
            em.close();
        }
        return sectionsList;

    }
}
