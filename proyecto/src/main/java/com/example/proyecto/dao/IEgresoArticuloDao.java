package com.example.proyecto.dao;

import com.example.proyecto.entity.EgresoArticulo;

import java.util.List;

public interface IEgresoArticuloDao {
    List<EgresoArticulo> findAll();

    public void save(EgresoArticulo egresoArticulo);

    EgresoArticulo findOne(Long id);

    public void delete(Long id);
}
