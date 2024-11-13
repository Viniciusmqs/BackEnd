package com.example.demo.api.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private Long autorId;
    private Long categoriaId;
}
