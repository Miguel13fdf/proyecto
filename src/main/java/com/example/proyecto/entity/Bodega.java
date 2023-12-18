package com.example.proyecto.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Bodega")
@Data
public class Bodega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @Column(name = "id_bodega")
    private Long idBodega;

    @Column(name = "Codigo")
    private Integer codigo;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Ubicacion")
    private String ubicacion;

    @OneToMany(mappedBy = "bodega")
    private List<Articulo> articulos;

    @OneToMany(mappedBy = "bodega")
    private List<IngresoArticulo> ingresoArticulos;

    public void setIdBodega(Long idBodega) {
        this.idBodega = idBodega;
    }

}
