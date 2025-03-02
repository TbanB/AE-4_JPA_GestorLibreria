package com.ae4_jpa.gestorLibreria.dao;

import com.ae4_jpa.gestorLibreria.model.Editorial;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EditorialDAO {
    private final EntityManager em;

    public EditorialDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Editorial editorial) {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public Editorial findById(Long id) {
        return em.find(Editorial.class, id);
    }

    public List<Editorial> findAll() {
        String jpql = "SELECT e FROM Editorial e";
        return em.createQuery(jpql, Editorial.class).getResultList();
    }
}