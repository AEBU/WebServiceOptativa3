package com.computronik.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alexis on 16/01/2017.
 */

@Entity
@Data
public class Orden {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ord_numero", nullable = false)
    private int ordNumero;
    @ManyToOne
    @JoinColumn(name = "usrId")
    private User  fkUserId;
    private String ordProducto;
    private String ordFechaEmision;
    private String ordProblema;
    private String ordEstado;

}
