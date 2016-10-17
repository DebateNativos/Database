
package com.cci.demo.rest;

import com.cci.data.Cliente;
import com.riuldebates.data.UserData;
import com.riuldebates.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/clienteFormato")
public class Formatos {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getFormatos(){
        List<Cliente> ac = new ArrayList<>();
        Cliente cliente = new Cliente();
        Cliente cliente2 = new Cliente();
        cliente.setId(1);
        cliente.setNombre("CCI CONSULTORES");
        ac.add(cliente);
        cliente2.setId(2);
        cliente2.setNombre("Carlos");
        ac.add(cliente2);
        
        return ac;
            
    }
    
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getUsers(){
        UserData ud = new UserData();
        List<Cliente> lc = new ArrayList<>();   
        for (User user : ud.getUsers()) {
            Cliente c = new Cliente();
            c.setNombre(user.getName());
            c.setId(user.getIdUsers());
            lc.add(c);
        }
        
        return lc;
        
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    public String demeMensajeHTML(){
        return "<html>"+"<title>"+"Hola Mensaje en Formato HTML"+"</title>"
                +"<body><h1>"+"Hola Mensaje en Formato HTML"+"</body></h1>"+"</html>";
    }
}
