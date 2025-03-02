package com.ae4_jpa.gestorLibreria.controller;

import com.ae4_jpa.gestorLibreria.dao.LibreriaDAO;
import com.ae4_jpa.gestorLibreria.model.Libreria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LibreriaController {
    private final LibreriaDAO libreriaDAO;

    public LibreriaController(EntityManager em) {
        this.libreriaDAO = new LibreriaDAO(em);
    }

    public void createLibreria(Libreria libreria) {
        libreriaDAO.create(libreria);
    }

    public Libreria getLibreriaById(Long id) {
        return libreriaDAO.findById(id);
    }

    public List<Libreria> getAllLibrerias() {
        return libreriaDAO.findAll();
    }
}
