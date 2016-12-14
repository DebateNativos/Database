/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.ws;

import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.QuestionData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Question;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
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
@Path("question")
public class ActiveQuestionWS {
    
    @GET
    @Path("/pushquestion")
    @Produces(MediaType.TEXT_PLAIN)
    public String pushQuestion(@QueryParam("debate") int debate, @QueryParam("email") String email, @QueryParam("text") String text) {

        EntityManager em = entityManagerFactory.createEntityManager();
        UserData ud = new UserData(em);
        QuestionData qd = new QuestionData(em);
        DebateData dd = new DebateData(em);
        String status = "";
        try {
            Question q = new Question(dd.getDebateById(debate), ud.getUserByEmail(email), text, false);
            if (qd.persistQuestion(q)) {
                em.close();
                status = "@questionSent";
            } else {
                em.close();
                status = "question@notSent";
            }

        } catch (Exception e) {
            em.close();
            status = "question@notSent";
        }
        return status;

    }
}
