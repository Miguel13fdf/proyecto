package com.example.proyecto.dao;

import com.example.proyecto.entity.IngresoDetalle;

import java.util.List;

public interface IIngresoDetalleDao {
    List<IngresoDetalle> findAll();

    public void save(IngresoDetalle ingresoDetalle);

    IngresoDetalle findOne(Long id);

    public void delete(Long id);
}
