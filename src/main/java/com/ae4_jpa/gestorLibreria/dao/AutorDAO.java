package com.ae4_jpa.gestorLibreria.dao;

import com.ae4_jpa.gestorLibreria.model.Autor;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AutorDAO {
    private final EntityManager em;

    public AutorDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Autor autor) {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public Autor findById(Long id) {
        return em.find(Autor.class, id);
    }

    public List<Autor> findAll() {
        String jpql = "SELECT a FROM Autor a";
        return em.createQuery(jpql, Autor.class).getResultList();
    }

    public List<Autor> findByNombre(String nombre) {
        String jpql = "SELECT a FROM Autor a WHERE a.nombre = :nombre";
        return em.createQuery(jpql, Autor.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }
}
