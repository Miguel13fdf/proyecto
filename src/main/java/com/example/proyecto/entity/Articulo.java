package com.example.proyecto.entity;



import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Articulo")
@Data
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Long idArticulo;

    @Column(name = "CodigoArticulo")
    private Integer codigoArticulo;

    @Column(name = "NombreArticulo")
    private String nombreArticulo;

    @Column(name = "Clasificacion")
    private String clasificacion;

    @Column(name = "StockMinimo")
    private Integer stockMinimo;

    @Column(name = "StockMaximo")
    private Integer stockMaximo;

    @Column(name = "StockActual")
    private Integer stockActual;

    @Column(name = "CostoPromedio")
    private Integer costoPromedio;

    @ManyToOne
    @JoinColumn(name = "id_bodega")
    @ToString.Exclude
    private Bodega bodega;

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

}
