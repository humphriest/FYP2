package RestApi;

import javax.ws.rs.*;

@Path("/api")
public class RestApi {

    @GET
    @Produces("application/json")
    @Path("/hi")
    public String hello(){
        return "hello";
    }
}
