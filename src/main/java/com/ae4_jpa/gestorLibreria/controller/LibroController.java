package com.ae4_jpa.gestorLibreria.controller;

import com.ae4_jpa.gestorLibreria.dao.LibroDAO;
import com.ae4_jpa.gestorLibreria.model.Libro;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LibroController {
    private final LibroDAO libroDAO;

    public LibroController(EntityManager em) {
        this.libroDAO = new LibroDAO(em);
    }

    public void createLibro(Libro libro) {
        libroDAO.create(libro);
    }

    public Libro getLibroById(Long id) {
        return libroDAO.findById(id);
    }

    public List<Libro> getAllLibros() {
        return libroDAO.findAll();
    }

    public List<Libro> getLibrosByTitulo(String titulo) {
        return libroDAO.findByTitulo(titulo);
    }
}
