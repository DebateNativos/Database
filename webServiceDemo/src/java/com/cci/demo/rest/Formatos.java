
package com.cci.demo.rest;

import com.cci.data.Cliente;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/clienteFormato")
public class Formatos {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public Cliente getFormatos(){
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("CCI CONSULTORES");
        return cliente;
            
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    public String demeMensajeHTML(){
        return "<html>"+"<title>"+"Hola Mensaje en Formato HTML"+"</title>"
                +"<body><h1>"+"Hola Mensaje en Formato HTML"+"</body></h1>"+"</html>";
    }
}
