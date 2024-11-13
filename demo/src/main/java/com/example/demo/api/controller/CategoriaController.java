package com.example.demo.api.controller;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaEntity>> listarTodos() {
        List<CategoriaEntity> lista = categoriaService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/incluir")
    public ResponseEntity<Void> incluir(@RequestBody CategoriaDTO request) {
        CategoriaEntity categoriaEntity = categoriaService.incluir(request);
        URI location = URI.create("/api/categoria/" + categoriaEntity.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<CategoriaEntity> alterar(@PathVariable Long id, @RequestBody CategoriaDTO request) {
        CategoriaEntity entity = categoriaService.alterar(id, request);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriaEntity> categoriaFindById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.categoriaFindById(id));
    }
}
