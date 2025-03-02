package com.ae4_jpa.gestorLibreria.controller;

import com.ae4_jpa.gestorLibreria.dao.EditorialDAO;
import com.ae4_jpa.gestorLibreria.model.Editorial;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EditorialController {
    private final EditorialDAO editorialDAO;

    public EditorialController(EntityManager em) {
        this.editorialDAO = new EditorialDAO(em);
    }

    public void createEditorial(Editorial editorial) {
        editorialDAO.create(editorial);
    }

    public Editorial getEditorialById(Long id) {
        return editorialDAO.findById(id);
    }

    public List<Editorial> getAllEditoriales() {
        return editorialDAO.findAll();
    }
}
