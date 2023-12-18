package com.example.proyecto.entity;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "EgresoDetalle")
@Data
public class EgresoDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_egreso_detalle")
    private Integer idEgresoDetalle;

    @ManyToOne
    @JoinColumn(name = "id_egreso")
    private EgresoArticulo egresoArticulo;

    @ManyToOne
    @JoinColumn(name = "id_articulo")
    private Articulo articulo;

    @Column(name = "cantidadEgreso")
    private Integer cantidadEgreso;

}
