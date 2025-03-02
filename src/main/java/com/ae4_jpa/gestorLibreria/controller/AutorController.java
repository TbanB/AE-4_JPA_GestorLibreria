package com.ae4_jpa.gestorLibreria.controller;

import com.ae4_jpa.gestorLibreria.dao.AutorDAO;
import com.ae4_jpa.gestorLibreria.model.Autor;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AutorController {
    private final AutorDAO autorDAO;

    public AutorController(EntityManager em) {
        this.autorDAO = new AutorDAO(em);
    }

    public void createAutor(Autor autor) {
        autorDAO.create(autor);
    }

    public Autor getAutorById(Long id) {
        return autorDAO.findById(id);
    }

    public List<Autor> getAllAutores() {
        return autorDAO.findAll();
    }

    public List<Autor> getAutoresByNombre(String nombre) {
        return autorDAO.findByNombre(nombre);
    }
}
