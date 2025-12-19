package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Proveedor;
import com.example.demo.service.ProveedorService;

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
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getAll() {
        List<Proveedor> lista = proveedorService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getById(@PathVariable Integer id) {
        Proveedor p = proveedorService.findById(id);
        if (p == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Proveedor> create(@RequestBody Proveedor proveedor) {
        return ResponseEntity.status(201).body(proveedorService.save(proveedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> update(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        proveedor.setId(id);
        return ResponseEntity.ok(proveedorService.save(proveedor));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Proveedor> patch(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        proveedor.setId(id);
        return ResponseEntity.ok(proveedorService.save(proveedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        proveedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}