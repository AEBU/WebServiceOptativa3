package com.computronik.service;

import com.computronik.model.Orden;
import com.computronik.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexis on 16/01/2017.
 */
@Service("ordenService")
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;


    @Override
    public List<Orden> findByUserId(int userId) {
        return ordenRepository.findByUserId(userId);
    }

    @Override
    public List<Orden> findByUserIdId(int id) {
        return ordenRepository.findByUserId(id);
    }


}
