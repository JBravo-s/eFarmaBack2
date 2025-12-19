package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Region;
import com.example.demo.service.RegionService;

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
@RequestMapping("/api/regiones")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getAll() {
        List<Region> lista = regionService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getById(@PathVariable Integer id) {
        Region r = regionService.findById(id);
        if (r == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(r);
    }

    @PostMapping
    public ResponseEntity<Region> create(@RequestBody Region region) {
        return ResponseEntity.status(201).body(regionService.save(region));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> update(@PathVariable Integer id, @RequestBody Region region) {
        region.setId(id);
        return ResponseEntity.ok(regionService.save(region));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Region> patch(@PathVariable Integer id, @RequestBody Region region) {
        region.setId(id);
        return ResponseEntity.ok(regionService.save(region));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        regionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}