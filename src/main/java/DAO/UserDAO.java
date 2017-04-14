package DAO;

import DAO.Services.UserDAOInterface;
import entities.User;
import persistence.persistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;


public class UserDAO implements UserDAOInterface{

    public void createUser(User user){
        persistenceUtil.persist(user);
    }

    public User getUserByUsername(String username){
        EntityManager em = persistenceUtil.createEM();
        List<User> users = (List<User>)
                em.createNamedQuery("User.findByUsername").
                        setParameter("username", username).getResultList();
        em.close();

        if(users.size() == 0){
            return null;
        } else
            return users.get(0);
    }

    public List<User> getAllUsers(){
        EntityManager em = persistenceUtil.createEM();
        List<User> users = (List<User>)
                em.createNamedQuery("User.findAll").getResultList();
        em.close();

        return users;
    }
}
