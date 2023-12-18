package com.example.proyecto.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Bodega")
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<IngresoArticulo> getIngresoArticulos() {
		return ingresoArticulos;
	}

	public void setIngresoArticulos(List<IngresoArticulo> ingresoArticulos) {
		this.ingresoArticulos = ingresoArticulos;
	}

	public Long getIdBodega() {
		return idBodega;
	}
    
    
}
