package com.example.proyecto.dao;

import com.example.proyecto.entity.Articulo;

import java.util.List;

public interface IArticuloDao {
    List<Articulo> findAll();

    public void save(Articulo articulo);

    Articulo findOne(Long id);

    public  void delete(Long id);
}
