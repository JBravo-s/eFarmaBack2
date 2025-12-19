package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CALLE", length = 150, nullable = false)
    private String calle;

    @Column(name = "NUMERO", length = 20, nullable = false)
    private String numero;

    @Column(name = "DEPTO", length = 20)
    private String depto;

    @Column(name = "BLOCK", length = 20)
    private String block;

    // FK hacia Comuna
    @ManyToOne
    @JoinColumn(name = "ID_COMUNA", nullable = false)
    private Comuna comuna;
}