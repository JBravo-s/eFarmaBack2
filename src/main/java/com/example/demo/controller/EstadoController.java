package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Estado;
import com.example.demo.service.EstadoService;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> getAll() {
        List<Estado> lista = estadoService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getById(@PathVariable Integer id) {
        Estado estado = estadoService.findById(id);
        if (estado == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(estado);
    }

    @PostMapping
    public ResponseEntity<Estado> create(@RequestBody Estado estado) {
        return ResponseEntity.status(201).body(estadoService.save(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Integer id, @RequestBody Estado estado) {
        estado.setId(id);
        return ResponseEntity.ok(estadoService.save(estado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estado> patch(@PathVariable Integer id, @RequestBody Estado estado) {
        estado.setId(id);
        return ResponseEntity.ok(estadoService.save(estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        estadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}