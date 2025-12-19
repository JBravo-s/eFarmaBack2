package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.TipoFabricacion;
import com.example.demo.repository.TipoFabricacionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoFabricacionService {

    @Autowired
    private TipoFabricacionRepository repository;

    public List<TipoFabricacion> findAll() {
        return repository.findAll();
    }

    @SuppressWarnings("null")
    public TipoFabricacion findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public TipoFabricacion save(TipoFabricacion tipo) {
        return repository.save(tipo);
    }

    public TipoFabricacion findByNombre(String nombre) {
        for (TipoFabricacion tipoFabricacion : repository.findAll()) {
            if (tipoFabricacion.getNombre().equalsIgnoreCase(nombre)) {
                return tipoFabricacion;
            }
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}