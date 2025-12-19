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

// Clase ESTADO de la VENTA

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOMBRE", length = 50, unique = true, nullable = false)
    private String nombre; // 'Pendiente', 'Enviado', 'Entregado'
}
