package DAO;

import entities.User;
import persistence.persistenceUtil;


public class UserDAO {

    public void createUser(User user){
        persistenceUtil.persist(user);
    }
}
