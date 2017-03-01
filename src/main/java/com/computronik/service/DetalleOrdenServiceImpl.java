package com.computronik.service;

import com.computronik.model.DetalleOrden;
import com.computronik.repository.DetalleOrdenRepository;
import com.computronik.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexis on 17/02/2017.
 */
@Service("detailService")
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public List<DetalleOrden> findByOrden(int ordNumero) {
        return detalleOrdenRepository.findByOrden(ordNumero);
    }
}
