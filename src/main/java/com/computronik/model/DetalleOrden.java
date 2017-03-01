package com.computronik.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Alexis on 17/02/2017.
 */
@Entity
@Data
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "det_numero", nullable = false)
    private int detNumero;
    private Double detPrecioTotal;
    @ManyToOne
    @JoinColumn(name = "ordNumero")
    private Orden fkOrdNumero;
    private String detServicio;

}
