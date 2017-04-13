package DAO.Services;


import entities.User;

public interface UserDAOInterface {

    public void createUser(User user);

    public User getUserByUsername(String username);
}
