package com.ae4_jpa.gestorLibreria.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @ManyToMany(mappedBy = "autores")
    private Set<Libro> libros = new HashSet<>();

    @OneToOne(mappedBy = "autor", cascade = CascadeType.ALL)
    private DetalleAutor detalleAutor;
}
