package com.example.proyecto.dao;

import com.example.proyecto.entity.Bodega;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


    @Repository
    public class BodegaDaoImp implements IBodegaDao {

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public List<Bodega> findAll() {
            return entityManager.createQuery("SELECT b FROM Bodega b", Bodega.class).getResultList();
        }

        @Override
        @Transactional
        public void save(Bodega bodega) {
            entityManager.persist(bodega);
        }

        @Override
        public Bodega findOne(Long id) {
            return entityManager.find(Bodega.class, id);
        }

        @Override
        @Transactional
        public void delete(Long id) {
            Bodega bodega = findOne(id);
            if (bodega != null) {
                entityManager.remove(bodega);
            }
        }


    }
