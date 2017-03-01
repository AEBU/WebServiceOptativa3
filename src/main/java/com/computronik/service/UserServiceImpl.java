package com.computronik.service;

import com.computronik.model.User;
import com.computronik.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexis on 09/01/2017.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User findById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean findByUsrEmail(String email)
    {
        User usernuevo=userRepository.findByUsrEmail(email);
        if (usernuevo!=null){
            return  false;
        }
        return  true;
    }

    @Override
    public User findByUsrEmailAndUsrPassword(String email, String username) {
        return userRepository.findByUsrEmailAndUsrPassword(email,username);
    }


    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAllUsers() {

    }

    @Override
    public boolean isUserExist(String email) {
        User usernuevo=userRepository.findByUsrEmail(email);
        if (usernuevo!=null){
            System.out.println("User "+usernuevo.getUsrEmail());
            return  true;
        }
        return  false;
    }
}
