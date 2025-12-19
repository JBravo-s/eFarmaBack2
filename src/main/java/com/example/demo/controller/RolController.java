package com.example.demo.controller;

import com.example.demo.model.Rol;
import com.example.demo.service.RolService;

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
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.findAll();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer id) {
        Rol rol = rolService.findById(id);
        if (rol == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rol);
    }

    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol nuevo = rolService.save(rol);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Integer id, @RequestBody Rol rol) {
        rol.setId(id);
        Rol actualizado = rolService.save(rol);
        return ResponseEntity.ok(actualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Rol> patchRol(@PathVariable Integer id, @RequestBody Rol rol) {
        rol.setId(id);
        Rol actualizado = rolService.save(rol);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}