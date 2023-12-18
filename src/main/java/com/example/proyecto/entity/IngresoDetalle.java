package com.example.proyecto.entity;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IngresoDetalle")
@Data
public class IngresoDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso_detalle")
    private Long idIngresoDetalle;

    @ManyToOne
    @JoinColumn(name = "id_ingresoArticulo")
    private IngresoArticulo ingresoArticulo;

    @ManyToOne
    @JoinColumn(name = "idArticulo")
    private Articulo articulo;

    @Column(name = "cantidadIngresada")
    private Integer cantidadIngresada;

    @Column(name = "precioComprado")
    private Double precioComprado;

    @Column(name = "costoPromedio")
    private Double costoPromedio;


}
