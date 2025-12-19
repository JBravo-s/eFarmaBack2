package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.MetodoEnvio;
import com.example.demo.service.MetodoEnvioService;

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
@RequestMapping("/api/metodos-envio")
public class MetodoEnvioController {

    @Autowired
    private MetodoEnvioService metodoEnvioService;

    @GetMapping
    public ResponseEntity<List<MetodoEnvio>> getAll() {
        List<MetodoEnvio> lista = metodoEnvioService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoEnvio> getById(@PathVariable Integer id) {
        MetodoEnvio m = metodoEnvioService.findById(id);
        if (m == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<MetodoEnvio> getByNombre(@PathVariable String nombre) {
        MetodoEnvio m = metodoEnvioService.findByNombre(nombre);
        if (m == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @PostMapping
    public ResponseEntity<MetodoEnvio> create(@RequestBody MetodoEnvio metodo) {
        return ResponseEntity.status(201).body(metodoEnvioService.save(metodo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoEnvio> update(@PathVariable Integer id, @RequestBody MetodoEnvio metodo) {
        metodo.setId(id);
        return ResponseEntity.ok(metodoEnvioService.save(metodo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MetodoEnvio> patch(@PathVariable Integer id, @RequestBody MetodoEnvio metodo) {
        metodo.setId(id);
        return ResponseEntity.ok(metodoEnvioService.save(metodo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        metodoEnvioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}