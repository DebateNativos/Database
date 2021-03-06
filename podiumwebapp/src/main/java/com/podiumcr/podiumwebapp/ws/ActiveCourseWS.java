/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.ws;

import com.podiumcr.jpa.data.CourseData;
import com.podiumcr.podiumwebapp.data.ActiveUserCourse;
import com.podiumcr.jpa.data.UserCourseData;
import com.podiumcr.jpa.data.UserData;
import com.podiumcr.jpa.entities.Course;
import com.podiumcr.jpa.entities.UserCourse;
import static com.podiumcr.podiumwebapp.common.EntityListener.entityManagerFactory;
import com.podiumcr.podiumwebapp.data.ActiveCourse;
import com.podiumcr.podiumwebapp.data.CourseStatus;
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
@Path("course")
public class ActiveCourseWS {

    @GET
    @Path("/getusercourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActiveUserCourse> getUsersCourses(@QueryParam("email") String email) {
        EntityManager em = entityManagerFactory.createEntityManager();
        UserCourseData ucd = new UserCourseData(em);
        UserData ud = new UserData(em);
        List<ActiveUserCourse> aucl = new ArrayList<>();
        try {
            for (UserCourse uc : ucd.getUserCourses(ud.getUserByEmail(email))) {
                ActiveUserCourse auc = new ActiveUserCourse(new ActiveCourse(uc.getCourse()), uc.getQualification());
                aucl.add(auc);
            }
            em.close();
        } catch (Exception e) {
            em.close();
        }
        return aucl;

    }

    @GET
    @Path("/getcoursebycode")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseStatus getCourseByCode(@QueryParam("code") String code) {
        EntityManager em = entityManagerFactory.createEntityManager();
        CourseStatus cs = new CourseStatus();
        CourseData cd = new CourseData(em);
        Course c = cd.getCourseByCode(code);
        try {
            if (c != null) {
                ActiveCourse ac = new ActiveCourse(c);
                cs.setStatus("@validCode");
                cs.setCourse(ac);
            } else {
                cs.setStatus("@invalidCode");
            }
            em.close();
        } catch (Exception e) {
            em.close();
            cs.setStatus("@invalidCode");
        }

        return cs;

    }

    @GET
    @Path("/registerusercourse")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseStatus registerUserWithCourse(@QueryParam("email") String email, @QueryParam("coursecode") String code) {
        EntityManager em = entityManagerFactory.createEntityManager();
        CourseStatus cs = new CourseStatus();
        CourseData cd = new CourseData(em);
        UserData ud = new UserData(em);
        UserCourseData ucd = new UserCourseData(em);
        //Pending reg
        UserCourse uc = new UserCourse();
        uc.setCourse(cd.getCourseByCode(code));
        uc.setUser(ud.getUserByEmail(email));
        uc.setQualification(0);
        boolean reg = true;

        try {
            for (UserCourse ucFromList : ucd.getUserCourses(uc.getUser())) {
                if (ucFromList.getCourse().equals(uc.getCourse())) {
                    reg = false;
                }
            }
            if (reg) {
                if (ucd.persistUserCourse(uc)) {
                    cs.setStatus("@validRegistration");
                    cs.setCourse(new ActiveCourse(uc.getCourse()));
                    em.close();
                }
            } else {
                cs.setStatus("@courseAlreadyRegistrated");
                em.close();
            }

        } catch (Exception e) {
            em.close();
            cs.setStatus("@invalidRegistration");
        }

        return cs;

    }
}
