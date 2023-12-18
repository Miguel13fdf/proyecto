package com.example.proyecto.dao;

import com.example.proyecto.entity.EgresoDetalle;

import java.util.List;

public interface IEgresoDetalleDao {
    List<EgresoDetalle> findAll();

    public void save(EgresoDetalle egresoDetalle);

    EgresoDetalle findOne(Long id);

    public void delete(Long id);
}
