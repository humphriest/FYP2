package Services;

import entities.Cart;
import entities.User;
import java.util.List;

/**
 * Created by Tim on 13/04/2017.
 */
public interface CartDAOInterface {

    public void createCart(Cart cart);

    public List<Cart> findAllCarts();

    public void updateCart(Cart cart);

    public List<Cart> getCartByUser(User user);

    public List<Cart> getCartById(int id);

    public void deleteCart(Cart cart);
}
