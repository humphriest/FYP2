package RestApi;

import DAO.CartDao;
import DAO.Services.CartDAOInterface;
import DAO.UserDAO;
import Factory.CartFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Cart;
import entities.StockItem;
import entities.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/cartApi")
public class CartApi {
    private CartDao cartDao = new CartDao();
    private UserDAO userDao = new UserDAO();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createCart")
    public Cart createItem(String jsonItem){
        Cart cart = null;
        try {
            cart = mapCart(jsonItem);
        } catch (IOException e) {
            e.printStackTrace();
        }

        cartDao.createCart(cart);
        return cart;
    }


    @POST
    @Produces(value = {"application/json"})
    @Path("/getCartByUser/{purchased}")
    public List<Cart> getCartByUser(
            @PathParam("purchased") boolean purchased,
            String itemJson){
        User user = null;
        User newUser = null;
        try {
            user = mapUser(itemJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (user != null) {
            newUser = userDao.getUserByUsername(user.getUsername());
        }
        if(newUser != null){
            CartFactory cartFactory = new CartFactory();
            CartDAOInterface daoInterface = cartFactory.getMethod(purchased);

            return daoInterface.getCartByUser(newUser);
        }else{
            return null;
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updatePaid")
    public List<Cart> updateCart(String cartsJson){
        List<Cart> carts = null;

        try {
            carts = mapMultipleCarts(cartsJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (carts != null) {
            for(Cart c: carts){
                c.setPaid(true);
                cartDao.updateCart(c);
            }
        } else{
            return null;
        }
        return carts;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addItemToCart")
    public Cart addItemToCart(String itemJson){
        Cart cart = null;

        try {
            cart = mapCart(itemJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cartDao.createCart(cart);
        return cart;
    }

    private User mapUser(String jsonItem) throws IOException {
        User user = null;
        user = new ObjectMapper().readValue(jsonItem, User.class);

        return user;
    }

    private Cart mapCart(String jsonItem) throws IOException {
        Cart cart = null;
        cart = new ObjectMapper().readValue(jsonItem, Cart.class);

        return cart;
    }

    private List<Cart> mapMultipleCarts(String jsonCarts) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<Cart> carts = mapper.readValue(jsonCarts, new TypeReference<List<Cart>>(){});

        return carts;
    }
}
