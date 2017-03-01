package com.computronik.rest;

import com.computronik.model.Orden;
import com.computronik.model.User;
import com.computronik.service.OrdenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alexis on 16/01/2017.
 */

@RestController
@RequestMapping(value = "/apps")
public class OrdenRController {


    @Autowired
    private OrdenServiceImpl ordenServiceImpl;


    //-------------------Retrieve All Orders--------------------------------------------------------
    @RequestMapping(value = "/ordens/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Orden>> getOrden(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        List<Orden> ordens= ordenServiceImpl.findByUserId(id);
        if (ordens.isEmpty()) {
            return new ResponseEntity<List<Orden>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Orden>>(ordens, HttpStatus.OK);
    }
}
