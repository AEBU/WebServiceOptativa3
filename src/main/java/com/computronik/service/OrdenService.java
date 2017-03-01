package com.computronik.service;

import com.computronik.model.Orden;

import java.util.List;

/**
 * Created by Alexis on 16/01/2017.
 */
public interface OrdenService {
    List<Orden> findByUserId(int userId);
    List<Orden> findByUserIdId(int id);
}
