package com.computronik.rest;

import com.computronik.model.User;
import com.computronik.service.UserService;
import com.computronik.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Alexis on 09/01/2017.
 */

@RestController
@RequestMapping(value = "/app")
public class UserRController {

    @Autowired
    private UserServiceImpl userServiceImpl;




    //-------------------Retrieve a User with usernema and password--------------------------------------------------------

    @RequestMapping(value = "/user/{email}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByE(@PathVariable("email") String email, @PathVariable("password") String password) {
        System.out.println("Fetching User with id " + email);
        User user = userServiceImpl.findByUsrEmailAndUsrPassword(email,password);
        if (user == null) {
            System.out.println("User with id " + email + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //-------------------Create a User--------------------------------------------------------
    @RequestMapping(value = "/userpost/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsrEmail());

        if (userServiceImpl.isUserExist(user.getUsrEmail())) {
            System.out.println("A User with name " + user.getUsrEmail() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userServiceImpl.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUsrId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
