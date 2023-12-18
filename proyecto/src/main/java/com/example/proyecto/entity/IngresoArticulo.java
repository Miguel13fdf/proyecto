package com.example.proyecto.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IngresoArticulo")
public class IngresoArticulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingresoArticulo")
    private Long idIngresoArticulo;

    @Column(name = "fecha_ingreso")
    private Date fechaIngresoArticulo;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "id_bodega")
    private Bodega bodega;

	public Long getIdIngresoArticulo() {
		return idIngresoArticulo;
	}

	public void setIdIngresoArticulo(Long idIngresoArticulo) {
		this.idIngresoArticulo = idIngresoArticulo;
	}

	public Date getFechaIngresoArticulo() {
		return fechaIngresoArticulo;
	}

	public void setFechaIngresoArticulo(Date fechaIngresoArticulo) {
		this.fechaIngresoArticulo = fechaIngresoArticulo;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

    

}
