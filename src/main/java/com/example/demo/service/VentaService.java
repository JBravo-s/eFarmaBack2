package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Venta;
import com.example.demo.repository.VentaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @SuppressWarnings("null")
    public Venta findById(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void deleteById(Integer id) {
        ventaRepository.deleteById(id);
    }
}