package com.ae4_jpa.gestorLibreria.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "librerias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libreria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;

    @ManyToMany(mappedBy = "librerias")
    private Set<Libro> libros = new HashSet<>();
}