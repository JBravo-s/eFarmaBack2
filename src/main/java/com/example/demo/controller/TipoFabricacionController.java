package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.TipoFabricacion;
import com.example.demo.service.TipoFabricacionService;

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
@RequestMapping("/api/tipos-fabricacion")
public class TipoFabricacionController {

    @Autowired
    private TipoFabricacionService tipoFabricacionService;

    @GetMapping
    public ResponseEntity<List<TipoFabricacion>> getAll() {
        List<TipoFabricacion> lista = tipoFabricacionService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFabricacion> getById(@PathVariable Integer id) {
        TipoFabricacion t = tipoFabricacionService.findById(id);
        if (t == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<TipoFabricacion> getByNombre(@PathVariable String nombre) {
        TipoFabricacion t = tipoFabricacionService.findByNombre(nombre);
        if (t == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity<TipoFabricacion> create(@RequestBody TipoFabricacion tipo) {
        return ResponseEntity.status(201).body(tipoFabricacionService.save(tipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoFabricacion> update(@PathVariable Integer id, @RequestBody TipoFabricacion tipo) {
        tipo.setId(id);
        return ResponseEntity.ok(tipoFabricacionService.save(tipo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoFabricacion> patch(@PathVariable Integer id, @RequestBody TipoFabricacion tipo) {
        tipo.setId(id);
        return ResponseEntity.ok(tipoFabricacionService.save(tipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        tipoFabricacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
