package DAO;

import entities.User;
import persistence.persistenceUtil;

/**
 * Created by Tim on 05/12/2016.
 */
public class UserDAO {

    public void createUser(User user){
        persistenceUtil.persist(user);
    }
}
