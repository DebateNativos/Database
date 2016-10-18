/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riul.testws;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author chang
 */

@Path("/cliente")
public class Parametros {
    
    
    //Obteniendo por directorios
    
    @GET 
    @Path("/nombre")
    @Produces(MediaType.TEXT_PLAIN)
    public String demeNombre(){
        return "CCI CONSULTORES SA";
    }
    
    //parametro
    @GET 
    @Path("saludo/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String demeSaludo(@PathParam("id")String nombre){
        return "Bienvenido "+ nombre.toUpperCase();
    }
    
    //por url nombre=algo
    @GET 
    @Path("otroSaludo")
    @Produces(MediaType.TEXT_PLAIN)
    public String demeOtroSaludo(@DefaultValue("Juan")@QueryParam("nombre") String nombre){
        return "Bienvenido.... "+ nombre.toUpperCase();
    }
    
    
    
    
}
