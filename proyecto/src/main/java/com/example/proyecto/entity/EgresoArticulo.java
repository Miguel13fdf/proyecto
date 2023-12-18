package com.example.proyecto.entity;



import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EgresoArticulo")
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

	public Long getIdEgresoArticulo() {
		return idEgresoArticulo;
	}

	public void setIdEgresoArticulo(Long idEgresoArticulo) {
		this.idEgresoArticulo = idEgresoArticulo;
	}

	public Date getFechaEgresoArticulo() {
		return fechaEgresoArticulo;
	}

	public void setFechaEgresoArticulo(Date fechaEgresoArticulo) {
		this.fechaEgresoArticulo = fechaEgresoArticulo;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

    
}
