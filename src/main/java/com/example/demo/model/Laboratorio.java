package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Laboratorio")
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID_LABORATORIO PK

    @Column(name = "NOMBRE", length = 150, nullable = false)
    private String nombre;
}
