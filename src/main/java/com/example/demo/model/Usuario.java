package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación ManyToOne con ROL (ID_ROL FK)
    @ManyToOne
    @JoinColumn(name = "ID_ROL", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "ID_DIRECCION", nullable = false)
    private Direccion direccion;

    @Column(name = "RUT", length = 15)
    private String rut;

    @Column(name = "CONTACTO", length = 255)
    private String contacto;

    @Column(name = "CORREO", unique = true, nullable = false, length = 255)
    private String correo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "CONTRASENA", nullable = false, length = 255)
    private String contrasenaHash;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

}
