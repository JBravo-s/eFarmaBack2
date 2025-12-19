package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ID_LABORATORIO", nullable = false)
    private Laboratorio laboratorio;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_FABRICACION", nullable = false)
    private TipoFabricacion tipoFabricacion;

    @Column(name = "NOMBRE_PRODUCTO", length = 200, nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "PRECIO", nullable = false)
    private Double precio;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "REQUIERE_RECETA", nullable = false)
    private Boolean requiereReceta;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("producto")
    private List<Imagenes> imagenes;
}
