package com.example.proyecto.dao;

import com.example.proyecto.entity.IngresoDetalle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class IngresoDetalleDaoImp implements IIngresoDetalleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<IngresoDetalle> findAll() {
        return entityManager.createQuery("SELECT id FROM IngresoDetalle id", IngresoDetalle.class).getResultList();
    }



    @Override
    @Transactional
    public void save(IngresoDetalle ingresoDetalle) {
        entityManager.persist(ingresoDetalle);
    }

    @Override
    public IngresoDetalle findOne(Long id) {
        return entityManager.find(IngresoDetalle.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        IngresoDetalle ingresoDetalle = findOne(id);
        if (ingresoDetalle != null) {
            entityManager.remove(ingresoDetalle);
        }
    }
}
