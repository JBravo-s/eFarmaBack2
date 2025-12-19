package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Direccion;
import com.example.demo.repository.DireccionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    @SuppressWarnings("null")
    public Direccion findById(Integer id) {
        return direccionRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public void deleteById(Integer id) {
        direccionRepository.deleteById(id);
    }
}