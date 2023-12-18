package com.example.proyecto.entity;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IngresoDetalle")
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

	public Long getIdIngresoDetalle() {
		return idIngresoDetalle;
	}

	public void setIdIngresoDetalle(Long idIngresoDetalle) {
		this.idIngresoDetalle = idIngresoDetalle;
	}

	public IngresoArticulo getIngresoArticulo() {
		return ingresoArticulo;
	}

	public void setIngresoArticulo(IngresoArticulo ingresoArticulo) {
		this.ingresoArticulo = ingresoArticulo;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Integer getCantidadIngresada() {
		return cantidadIngresada;
	}

	public void setCantidadIngresada(Integer cantidadIngresada) {
		this.cantidadIngresada = cantidadIngresada;
	}

	public Double getPrecioComprado() {
		return precioComprado;
	}

	public void setPrecioComprado(Double precioComprado) {
		this.precioComprado = precioComprado;
	}

	public Double getCostoPromedio() {
		return costoPromedio;
	}

	public void setCostoPromedio(Double costoPromedio) {
		this.costoPromedio = costoPromedio;
	}


    
}
