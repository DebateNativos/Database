/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riul.testws;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/mensaje")
public class MensajeRest {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
        public String demeMensajeGET(){
            return "Mi Mensaje GET";
        }
        
    @POST
    @Produces(MediaType.TEXT_PLAIN)
        public String demeMensajePOST(){
            return "Mi mensaje POST";
        }
        
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
        public String demeMensajePUT(){
            return "Mi mensaje PUT"
                    ;
        }
        
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
        public String demeMensajeDELETE(){
            return "Mi mensaje DELETE"
                    ;
        }
        
}
