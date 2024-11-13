package com.example.demo.api.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_LIVRO")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "ISBN", nullable = false)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", referencedColumnName = "ID")
    private AutorEntity autor;

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "ID")
    private CategoriaEntity categoria;
}
