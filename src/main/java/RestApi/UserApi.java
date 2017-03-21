package RestApi;

import DAO.UserDAO;
import entities.User;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/userApi")
public class UserApi {
    private UserDAO userDAO = new UserDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createUser")
    public String createUser(){
        User user = new User("tim", "tim", "In My Ass", 1, true);
        userDAO.createUser(user);
        return "Success"+ user.getUsername();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUser/{username}")
    public User getUser( @PathParam("username") String username){
        return userDAO.getUserByUsername(username);
    }


}
