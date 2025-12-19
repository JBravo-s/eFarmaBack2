package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Imagenes;
import com.example.demo.repository.ImagenesRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImagenesService {

    @Autowired
    private ImagenesRepository imagenesRepository;

    public List<Imagenes> findAll() {
        return imagenesRepository.findAll();
    }

    @SuppressWarnings("null")
    public Imagenes findById(Integer id) {
        return imagenesRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Imagenes save(Imagenes imagen) {
        return imagenesRepository.save(imagen);
    }

    public void deleteById(Integer id) {
        imagenesRepository.deleteById(id);
    }
}