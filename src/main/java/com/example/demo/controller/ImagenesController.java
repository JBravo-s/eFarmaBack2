package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Imagenes;
import com.example.demo.service.ImagenesService;

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
@RequestMapping("/api/imagenes")
public class ImagenesController {

    @Autowired
    private ImagenesService imagenesService;

    @GetMapping
    public ResponseEntity<List<Imagenes>> getAll() {
        List<Imagenes> lista = imagenesService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagenes> getById(@PathVariable Integer id) {
        Imagenes i = imagenesService.findById(id);
        if (i == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(i);
    }

    @PostMapping
    public ResponseEntity<Imagenes> create(@RequestBody Imagenes imagen) {
        return ResponseEntity.status(201).body(imagenesService.save(imagen));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagenes> update(@PathVariable Integer id, @RequestBody Imagenes imagen) {
        imagen.setId(id);
        return ResponseEntity.ok(imagenesService.save(imagen));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Imagenes> patch(@PathVariable Integer id, @RequestBody Imagenes imagen) {
        imagen.setId(id);
        return ResponseEntity.ok(imagenesService.save(imagen));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        imagenesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}