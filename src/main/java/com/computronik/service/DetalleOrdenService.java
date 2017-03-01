package com.computronik.service;

import com.computronik.model.DetalleOrden;

import java.util.List;

/**
 * Created by Alexis on 17/02/2017.
 */
public interface DetalleOrdenService {

    List<DetalleOrden> findByOrden(int ordNumero);
}
