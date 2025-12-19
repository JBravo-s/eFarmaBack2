package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Laboratorio;
import com.example.demo.repository.LaboratorioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository LaboratorioRepository;

    public void deleteById(Integer id) {
        LaboratorioRepository.deleteById(id);
    }

    public List<Laboratorio> findAll() {
        return LaboratorioRepository.findAll();
    }

    @SuppressWarnings("null")
    public Laboratorio findById(Integer id) {
        return LaboratorioRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Laboratorio save(Laboratorio Laboratorio) {
        return LaboratorioRepository.save(Laboratorio);
    }
}