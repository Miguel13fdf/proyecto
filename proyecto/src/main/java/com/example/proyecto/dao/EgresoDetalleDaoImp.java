package com.example.proyecto.dao;

import com.example.proyecto.entity.EgresoDetalle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class EgresoDetalleDaoImp implements IEgresoDetalleDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<EgresoDetalle> findAll() {
        return entityManager.createQuery("SELECT ed FROM EgresoDetalle ed", EgresoDetalle.class).getResultList();
    }

    @Override
    @Transactional
    public void save(EgresoDetalle egresoDetalle) {
        entityManager.persist(egresoDetalle);
    }

    @Override
    public EgresoDetalle findOne(Long id) {
        return entityManager.find(EgresoDetalle.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        EgresoDetalle egresoDetalle = findOne(id);
        if (egresoDetalle != null) {
            entityManager.remove(egresoDetalle);
        }
    }
}
