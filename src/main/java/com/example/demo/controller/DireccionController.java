package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Direccion;
import com.example.demo.service.DireccionService;

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
@RequestMapping("/api/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> getAll() {
        List<Direccion> lista = direccionService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getById(@PathVariable Integer id) {
        Direccion d = direccionService.findById(id);
        if (d == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PostMapping
    public ResponseEntity<Direccion> create(@RequestBody Direccion direccion) {
        return ResponseEntity.status(201).body(direccionService.save(direccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> update(@PathVariable Integer id, @RequestBody Direccion direccion) {
        direccion.setId(id);
        return ResponseEntity.ok(direccionService.save(direccion));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Direccion> patch(@PathVariable Integer id, @RequestBody Direccion direccion) {
        direccion.setId(id);
        return ResponseEntity.ok(direccionService.save(direccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        direccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}