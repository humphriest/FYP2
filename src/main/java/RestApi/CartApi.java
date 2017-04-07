package RestApi;

import DAO.CartDao;
import DAO.UserDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Cart;
import entities.StockItem;
import entities.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getCartByUser")
    public List<Cart> getCartByUser(String itemJson){
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
            List<Cart> allUsersCarts = cartDao.getCartByUser(newUser);
            List<Cart> realCart = new ArrayList<>();
            if (allUsersCarts != null){
                for(Cart c : allUsersCarts){
                    if(!c.getPaid()){
                        realCart.add(c);
                    }
                }
                return realCart;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updatePaid")
    public Cart updateCart(String cartJson){
        Cart cart = null;

        try {
            cart = mapCart(cartJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (cart != null) {
            cartDao.getCartById(cart.getId());
        }else{
            return null;
        }
        return cart;
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
}
