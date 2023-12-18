package com.example.proyecto.entity;



import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Articulo")
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

	public Integer getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(Integer codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Integer getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(Integer stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public Integer getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(Integer stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public Integer getStockActual() {
		return stockActual;
	}

	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}

	public Integer getCostoPromedio() {
		return costoPromedio;
	}

	public void setCostoPromedio(Integer costoPromedio) {
		this.costoPromedio = costoPromedio;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Long getIdArticulo() {
		return idArticulo;
	}

}
