package com.example.proyecto.dao;
import com.example.proyecto.entity.IngresoArticulo;

import java.util.List;

public interface IIngresoArticuloDao {
    List<IngresoArticulo> findAll();

    void save(IngresoArticulo ingresoArticulo);

    IngresoArticulo findOne(Long id);

    void delete(Long id);
}
