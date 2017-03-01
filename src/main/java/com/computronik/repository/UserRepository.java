package com.computronik.repository;

import com.computronik.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexis on 09/01/2017.
 */
public interface UserRepository extends JpaRepository <User, Integer> {

    User findByUsrEmailAndUsrPassword(String username, String email);
    User findByUsrEmail(String email);
}
