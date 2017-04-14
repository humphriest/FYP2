package DAO;


import Services.CartDAOInterface;
import entities.Cart;
import entities.User;
import persistence.persistenceUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDao implements CartDAOInterface {

    public void createCart(Cart cart){
        persistenceUtil.persist(cart);
    }

    public void updateCart(Cart cart){
        persistenceUtil.merge(cart);
    }

    public List<Cart> findAllCarts(){
        EntityManager em = persistenceUtil.createEM();
        List<Cart> carts = (List<Cart>)
                em.createNamedQuery("cart.findAll").getResultList();
        em.close();

        return carts;
    }

    public List<Cart> getCartByUser(User user){
        EntityManager em = persistenceUtil.createEM();
        List<Cart> carts = (List<Cart>)
                em.createNamedQuery("cart.findByUser").
                        setParameter("user", user).getResultList();
        em.close();

        if(carts.size() == 0){
            return null;
        } else {
            List<Cart> paid = new ArrayList<>();
            for(Cart c : carts){
                if(c.getPaid()){
                    paid.add(c);
                }
            }
            return paid;}
    }

    public List<Cart> getCartById(int id){
        EntityManager em = persistenceUtil.createEM();
        List<Cart> carts = (List<Cart>)
                em.createNamedQuery("cart.findById").
                        setParameter("id", id).getResultList();
        em.close();

        if(carts.size() == 0){
            return null;
        } else
            return carts;
    }

    public void deleteCart(Cart cart){
        persistenceUtil.remove(cart);
    }
}
