package com.example.demo.api.controller;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/listar")
    public ResponseEntity<List<AutorEntity>> listarTodos() {
        List<AutorEntity> lista = autorService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/incluir")
    public ResponseEntity<Void> incluir(@RequestBody AutorDTO request) {
        AutorEntity autorEntity = autorService.incluir(request);
        URI location = URI.create("/api/autor/" + autorEntity.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<AutorEntity> alterar(@PathVariable Long id, @RequestBody AutorDTO request) {
        AutorEntity entity = autorService.alterar(id, request);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<AutorEntity> autorFindById(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.autorFindById(id));
    }
}
