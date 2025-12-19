package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

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
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        List<Producto> lista = productoService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Integer id) {
        Producto p = productoService.findById(id);
        if (p == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        return ResponseEntity.status(201).body(productoService.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setId(id);
        return ResponseEntity.ok(productoService.save(producto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Producto> patch(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setId(id);
        return ResponseEntity.ok(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}