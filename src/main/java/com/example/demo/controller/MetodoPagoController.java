package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.MetodoPago;
import com.example.demo.service.MetodoPagoService;

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
@RequestMapping("/api/metodos-pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public ResponseEntity<List<MetodoPago>> getAll() {
        List<MetodoPago> lista = metodoPagoService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getById(@PathVariable Integer id) {
        MetodoPago m = metodoPagoService.findById(id);
        if (m == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<MetodoPago> getByNombre(@PathVariable String nombre) {
        MetodoPago m = metodoPagoService.findByNombre(nombre);
        if (m == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @PostMapping
    public ResponseEntity<MetodoPago> create(@RequestBody MetodoPago metodo) {
        return ResponseEntity.status(201).body(metodoPagoService.save(metodo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> update(@PathVariable Integer id, @RequestBody MetodoPago metodo) {
        metodo.setId(id);
        return ResponseEntity.ok(metodoPagoService.save(metodo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MetodoPago> patch(@PathVariable Integer id, @RequestBody MetodoPago metodo) {
        metodo.setId(id);
        return ResponseEntity.ok(metodoPagoService.save(metodo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        metodoPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}