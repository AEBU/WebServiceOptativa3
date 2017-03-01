package com.computronik.repository;

import com.computronik.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Alexis on 16/01/2017.
 */
public interface OrdenRepository extends JpaRepository<Orden, Integer> {

    //@Query("select o from Orden o inner join  User u on u.id=o.user_id where  o.user_id = ?1")
    //@Query("select o.ordenId,o.producto from Orden o where o.userId.id=?1")
    //@Query("select new Orden(o.ordenId,o.producto,o.userId) from Orden o where o.userId.id=?1")



    @Query("select new Map(o.ordNumero as ordNumero,o.ordFechaEmision as ordFechaEmision,o.ordProblema as ordProblema, o.ordEstado as fkEstCodigo,o.ordProducto as ordProducto) from Orden o where o.fkUserId.usrId=?1")
    List<Orden> findByUserId(int user_id);
}
