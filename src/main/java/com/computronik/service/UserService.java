package com.computronik.service;

import com.computronik.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexis on 09/01/2017.
 */
public interface UserService {

    User findById(int id);

    boolean findByUsrEmail(String email);




    User findByUsrEmailAndUsrPassword(String username, String email);
    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(String user);

}
