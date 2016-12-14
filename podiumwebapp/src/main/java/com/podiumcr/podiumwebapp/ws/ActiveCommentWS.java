/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.ws;

import com.podiumcr.jpa.data.CommentData;
import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.jpa.data.DebateData;
import com.podiumcr.jpa.data.UserCourseData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Comment;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import com.podiumcr.podiumwebapp.data.ActiveComment;
import com.podiumcr.podiumwebapp.data.ActiveUser;
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
@Path("comment")
public class ActiveCommentWS {

    @GET
    @Path("/getcomments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveComment> getDebatesCourseComments(@QueryParam("course") String course, @QueryParam("debate") int debate) {
        EntityManager em = entityManagerFactory.createEntityManager();
        CommentData cd = new CommentData(em);
        CourseData coursed = new CourseData(em);
        DebateData dd = new DebateData(em);
        List<ActiveComment> aucl = new ArrayList<>();
        try {
            for (Comment c : cd.getCommentByDebateCourse(coursed.getCourseByCode(course), dd.getDebateById(debate))) {

                aucl.add(new ActiveComment(new ActiveUser(c.getUser()), c.getText()));
            }
            em.close();
        } catch (Exception e) {
            em.close();
        }
        return aucl;

    }

    @GET
    @Path("/pushcomment")
    @Produces(MediaType.TEXT_PLAIN)
    public String pushComment(@QueryParam("course") String course, @QueryParam("debate") int debate,
            @QueryParam("email") String email, @QueryParam("text") String text) {

        EntityManager em = entityManagerFactory.createEntityManager();
        UserData ud = new UserData(em);
        CommentData cd = new CommentData(em);
        DebateData dd = new DebateData(em);
        CourseData coursed = new CourseData(em);
        String status;
        try {
            Comment c = new Comment(dd.getDebateById(debate), ud.getUserByEmail(email), text, coursed.getCourseByCode(course));
            if (cd.persistComment(c)) {
                em.close();
                status = "@sent";
            } else {
                em.close();
                status = "@notSent";
            }

        } catch (Exception e) {
            em.close();
            status = "@notSent";
        }
        return status;

    }
}
