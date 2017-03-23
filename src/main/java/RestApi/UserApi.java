package RestApi;

import DAO.UserDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/userApi")
public class UserApi {
    private UserDAO userDAO = new UserDAO();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createUser")
    public User createUser(String jsonUser){
        User user = null;

        try {
            user = mapUser(jsonUser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userDAO.createUser(user);
        return user;
    }

    private User mapUser(String userJson) throws IOException {
        User user = null;

        user = new ObjectMapper().readValue(userJson, User.class);

        return user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUser/{username}")
    public User getUser( @PathParam("username") String username){
        return userDAO.getUserByUsername(username);
    }


}
