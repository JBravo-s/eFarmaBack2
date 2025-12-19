package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

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
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> lista = usuarioService.findAll();
        if (lista.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        Usuario u = usuarioService.findById(id);
        if (u == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(u);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> patch(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}