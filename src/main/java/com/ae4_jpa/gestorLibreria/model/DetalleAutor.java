package com.ae4_jpa.gestorLibreria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_autor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleAutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String biografia;
    private String fotoUrl;

    @OneToOne
    @JoinColumn(name = "autor_id", unique = true)
    private Autor autor;
}

