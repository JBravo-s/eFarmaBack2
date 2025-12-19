package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.MetodoEnvio;
import com.example.demo.repository.MetodoEnvioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoEnvioService {

    @Autowired
    private MetodoEnvioRepository repository;

    public List<MetodoEnvio> findAll() {
        return repository.findAll();
    }

    @SuppressWarnings("null")
    public MetodoEnvio findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public MetodoEnvio save(MetodoEnvio metodo) {
        return repository.save(metodo);
    }

    public MetodoEnvio findByNombre(String nombre) {
        for (MetodoEnvio metodoEnvio : repository.findAll()) {
            if (metodoEnvio.getNombre().equalsIgnoreCase(nombre)) {
                return metodoEnvio;
            }
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}