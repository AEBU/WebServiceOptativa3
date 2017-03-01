package com.computronik.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Alexis on 09/01/2017.
 */

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int usrId;

    private String usrEmail;
    private String usrPassword;//password
    private String usrPerfil;




}