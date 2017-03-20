package RestApi;

import DAO.StockItemDAO;
import DAO.UserDAO;
import entities.StockItem;
import entities.User;

import javax.ws.rs.*;

@Path("/api")
public class RestApi {
    private UserDAO userDAO = new UserDAO();
    private StockItemDAO itemDao = new StockItemDAO();

    @GET
    @Produces("application/json")
    @Path("/hi")
    public String hello(){
        return "hello";
    }

    @GET
    @Produces("application/json")
    @Path("/createUserAndItem")
    public String createUser(){
        User newUser = new User();
        newUser.setAge(22);
        newUser.setPassword("root");
        newUser.setUsername("root");
        newUser.setAddress("9 Kerrymount Close");

        userDAO.createUser(newUser);

        StockItem item = new StockItem("tv", "SONY", "electronics", "", 129.50);

        itemDao.createStockItem(item);

        return "Success"+ newUser.toString();
    }
}
