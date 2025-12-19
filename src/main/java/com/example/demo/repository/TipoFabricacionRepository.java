package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TipoFabricacion;

@Repository
public interface TipoFabricacionRepository extends JpaRepository<TipoFabricacion, Integer>{
    
}
