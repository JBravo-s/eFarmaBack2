package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.model.Venta;
import com.example.demo.service.VentaService;

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
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAll() {
        List<Venta> lista = ventaService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getById(@PathVariable Integer id) {
        Venta venta = ventaService.findById(id);
        if (venta == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(venta);
    }

    // Get de fecha actual de creacion con LocalDate
    @PostMapping
    public ResponseEntity<Venta> create(@RequestBody Venta venta) {
        venta.setFechaCreacion(LocalDateTime.now());
        return ResponseEntity.status(201).body(ventaService.save(venta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> update(@PathVariable Integer id, @RequestBody Venta venta) {
        venta.setId(id);
        return ResponseEntity.ok(ventaService.save(venta));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Venta> patch(@PathVariable Integer id, @RequestBody Venta venta) {
        venta.setId(id);
        return ResponseEntity.ok(ventaService.save(venta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ventaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}