package com.example.proyecto.dao;

import com.example.proyecto.entity.Articulo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ArticuloDaoImp implements IArticuloDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Articulo> findAll() {
        return entityManager.createQuery("SELECT a FROM Articulo a", Articulo.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        entityManager.persist(articulo);
    }

    @Override
    public Articulo findOne(Long id) {
        return entityManager.find(Articulo.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Articulo articulo = findOne(id);
        if (articulo != null) {
            entityManager.remove(articulo);
        }
    }
}
