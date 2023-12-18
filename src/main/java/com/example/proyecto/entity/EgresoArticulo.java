package com.example.proyecto.entity;



import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EgresoArticulo")
@Data
public class EgresoArticulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_egresoArticulo")
    private Long idEgresoArticulo;

    @Column(name = "FechaEgresoArticulo")
    private Date fechaEgresoArticulo;

    @ManyToOne
    @JoinColumn(name = "id_bodega")
    @ToString.Exclude
    private Bodega bodega;

}
