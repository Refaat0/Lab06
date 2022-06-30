package services;

import java.util.List;
import dataaccess.UserDB;
import models.User;

public class UserService {

    // Get all users
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    // Add user
    public static void insert(User user) throws Exception {
        User newUser = user;
        UserDB userDB = new UserDB();
        userDB.insert(newUser);
    }

    // Update User
    public static void update(User newUser) throws Exception {
        UserDB userDB = new UserDB();
        userDB.update(newUser);
    }
    
    // Delete User
    public static void delete(User user) throws Exception {
        UserDB userDB = new UserDB();
        userDB.delete(user.getEmail());
    }

}
