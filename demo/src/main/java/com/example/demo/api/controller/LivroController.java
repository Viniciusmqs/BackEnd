package com.example.demo.api.controller;

import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public ResponseEntity<List<LivroEntity>> listarTodos() {
        List<LivroEntity> lista = livroService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/incluir")
    public ResponseEntity<Void> incluir(@RequestBody LivroDTO request) {
        LivroEntity livroEntity = livroService.incluir(request);
        URI location = URI.create("/api/livro/" + livroEntity.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<LivroEntity> alterar(@PathVariable Long id, @RequestBody LivroDTO request) {
        LivroEntity entity = livroService.alterar(id, request);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<LivroEntity> livroFindById(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.livroFindById(id));
    }
}
