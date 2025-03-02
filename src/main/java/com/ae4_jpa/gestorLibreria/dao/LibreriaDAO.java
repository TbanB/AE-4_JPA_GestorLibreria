package com.ae4_jpa.gestorLibreria.dao;

import com.ae4_jpa.gestorLibreria.model.Libreria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LibreriaDAO {
    private final EntityManager em;

    public LibreriaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Libreria libreria) {
        em.getTransaction().begin();
        em.persist(libreria);
        em.getTransaction().commit();
    }

    public Libreria findById(Long id) {
        return em.find(Libreria.class, id);
    }

    public List<Libreria> findAll() {
        String jpql = "SELECT l FROM Libreria l";
        return em.createQuery(jpql, Libreria.class).getResultList();
    }
}
