package Services;


import entities.User;

import java.util.List;

public interface UserDAOInterface {

    public void createUser(User user);

    public User getUserByUsername(String username);

    public List<User> getAllUsers();
}
