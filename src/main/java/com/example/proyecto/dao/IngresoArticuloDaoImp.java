package com.example.proyecto.dao;

import com.example.proyecto.entity.IngresoArticulo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class IngresoArticuloDaoImp implements IIngresoArticuloDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<IngresoArticulo> findAll() {
        return entityManager.createQuery("SELECT ic FROM IngresoArticulo ic", IngresoArticulo.class).getResultList();
    }

    @Override
    @Transactional
    public void save(IngresoArticulo ingresoArticulo) {
        entityManager.persist(ingresoArticulo);
    }

    @Override
    public IngresoArticulo findOne(Long id) {
        return entityManager.find(IngresoArticulo.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        IngresoArticulo ingresoArticulo = findOne(id);
        if (ingresoArticulo != null) {
            entityManager.remove(ingresoArticulo);
        }
    }
}
