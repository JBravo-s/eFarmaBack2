package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @SuppressWarnings("null")
    public Usuario findById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @SuppressWarnings("null")
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}