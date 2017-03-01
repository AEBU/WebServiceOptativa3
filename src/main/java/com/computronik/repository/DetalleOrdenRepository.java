package com.computronik.repository;

import com.computronik.model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Alexis on 17/02/2017.
 */
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden,Integer> {


    @Query("select new Map(d.detNumero as detNumero,d.detPrecioTotal as detPrecioTotal,d.detServicio as detServicio) from DetalleOrden d where d.fkOrdNumero.ordNumero=?1")
    List<DetalleOrden> findByOrden(int ordNumero);
}
