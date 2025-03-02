package com.ae4_jpa.gestorLibreria.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "libros")
@Data
@ToString(exclude = {"autores", "editorial"})
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;

    @Temporal(TemporalType.DATE)
    private Date fechaEdicion;

    @ManyToMany
    @JoinTable(
            name = "autor_libro",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "libreria_libro",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "libreria_id")
    )
    private Set<Libreria> librerias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
}
