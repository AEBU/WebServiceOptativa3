package com.computronik.rest;

import com.computronik.model.DetalleOrden;
import com.computronik.model.Orden;
import com.computronik.service.DetalleOrdenServiceImpl;
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
 * Created by Alexis on 17/02/2017.
 */
@RestController
@RequestMapping(value = "/detordens")
public class DetalleOrdenRController {

    @Autowired
    private DetalleOrdenServiceImpl detalleOrdenServiceImpl;

    //Regresar detalles de una orden en especifico
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DetalleOrden>> getOrden(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        List<DetalleOrden> detailsordens= detalleOrdenServiceImpl.findByOrden(id);
        if (detailsordens.isEmpty()) {
            return new ResponseEntity<List<DetalleOrden>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<DetalleOrden>>(detailsordens, HttpStatus.OK);
    }
}
