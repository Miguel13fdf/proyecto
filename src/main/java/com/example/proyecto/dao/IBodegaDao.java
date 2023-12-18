package com.example.proyecto.dao;

import com.example.proyecto.entity.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IBodegaDao  {

    List<Bodega> findAll();
    public void save(Bodega bodega);
    Bodega findOne(Long id);
    public void delete(Long id);

}
