package com.example.proyecto.dao;

import com.example.proyecto.entity.EgresoArticulo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class EgresoArticuloDaoImp implements IEgresoArticuloDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EgresoArticulo> findAll() {
        return entityManager.createQuery("SELECT ec FROM EgresoArticulo ec", EgresoArticulo.class).getResultList();
    }

    @Override
    @Transactional
    public void save(EgresoArticulo egresoArticulo) {
        entityManager.persist(egresoArticulo);
    }

    @Override
    public EgresoArticulo findOne(Long id) {
        return entityManager.find(EgresoArticulo.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        EgresoArticulo egresoArticulo = findOne(id);
        if (egresoArticulo != null) {
            entityManager.remove(egresoArticulo);
        }
    }
}
