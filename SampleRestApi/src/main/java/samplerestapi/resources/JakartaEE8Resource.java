package samplerestapi.resources;

import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("rest")
public class JakartaEE8Resource {

    @GET
    // Two types to give argument to @Produces
    // Arg - Mime type what type of data it will return
    //@Produces(MediaType.TEXT_HTML) 
    @Produces("text/html")
    public String sayHello() {
        return "Hello world of REST !!";
    }

    @GET
    @Path("someone/{name}")
    @Produces("text/html")
    public String sayHellotoSomeone(@PathParam("name") String name) {
        return "Hello " + name;
    }
    
    @Path("getups")
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Collection<String> ucases(Collection<String> strs) {
        Collection<String> uppers = new ArrayList<>();
        for(String s: strs) {
            uppers.add(s.toUpperCase());
        }
        
        return uppers;
    } 
}
