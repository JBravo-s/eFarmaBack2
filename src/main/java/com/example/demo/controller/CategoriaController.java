package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

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

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        List<Categoria> lista = categoriaService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id) {
        Categoria c = categoriaService.findById(id);
        if (c == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Categoria> getByNombre(@PathVariable String nombre) {
        Categoria categoria = categoriaService.findByNombreCategoria(nombre);
        if (categoria == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        return ResponseEntity.status(201).body(categoriaService.save(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        return ResponseEntity.ok(categoriaService.save(categoria));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Categoria> patch(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        return ResponseEntity.ok(categoriaService.save(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}