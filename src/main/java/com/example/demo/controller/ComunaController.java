package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Comuna;
import com.example.demo.service.ComunaService;

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
@RequestMapping("/api/comunas")
public class ComunaController {

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Comuna>> getAll() {
        List<Comuna> lista = comunaService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> getById(@PathVariable Integer id) {
        Comuna comuna = comunaService.findById(id);
        if (comuna == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(comuna);
    }

    @PostMapping
    public ResponseEntity<Comuna> create(@RequestBody Comuna comuna) {
        return ResponseEntity.status(201).body(comunaService.save(comuna));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> update(@PathVariable Integer id, @RequestBody Comuna comuna) {
        comuna.setId(id);
        return ResponseEntity.ok(comunaService.save(comuna));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Comuna> patch(@PathVariable Integer id, @RequestBody Comuna comuna) {
        comuna.setId(id);
        return ResponseEntity.ok(comunaService.save(comuna));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        comunaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}