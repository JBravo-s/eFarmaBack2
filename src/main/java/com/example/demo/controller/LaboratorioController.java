package com.example.demo.controller;

import com.example.demo.model.Laboratorio;
import com.example.demo.service.LaboratorioService;

import java.util.List;

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
@RequestMapping("/api/marcas")
public class LaboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping
    public ResponseEntity<List<Laboratorio>> getAllMarcas() {
        List<Laboratorio> marcas = laboratorioService.findAll();
        if (marcas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> getMarcaById(@PathVariable Integer id) {
        Laboratorio laboratorio = laboratorioService.findById(id);
        if (laboratorio == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(laboratorio);
    }

    @PostMapping
    public ResponseEntity<Laboratorio> createMarca(@RequestBody Laboratorio laboratorio) {
        return ResponseEntity.status(201).body(laboratorioService.save(laboratorio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratorio> updateMarca(@PathVariable Integer id, @RequestBody Laboratorio laboratorio) {
        laboratorio.setId(id);
        return ResponseEntity.ok(laboratorioService.save(laboratorio));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Laboratorio> patchMarca(@PathVariable Integer id, @RequestBody Laboratorio laboratorio) {
        laboratorio.setId(id);
        return ResponseEntity.ok(laboratorioService.save(laboratorio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Integer id) {
        laboratorioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}