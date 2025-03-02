package com.ae4_jpa.gestorLibreria.dao;

import com.ae4_jpa.gestorLibreria.model.Libro;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LibroDAO {
    private final EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public Libro findById(Long id) {
        return em.find(Libro.class, id);
    }

    public List<Libro> findAll() {
        String jpql = "SELECT l FROM Libro l";
        return em.createQuery(jpql, Libro.class).getResultList();
    }

    public List<Libro> findByTitulo(String titulo) {
        String jpql = "SELECT l FROM Libro l WHERE l.titulo LIKE :titulo";
        return em.createQuery(jpql, Libro.class)
                .setParameter("titulo", "%" + titulo + "%")
                .getResultList();
    }
}
