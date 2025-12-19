package com.example.demo.model;

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

// Un producto puede pertenecer a varias categorías y una categoría puede contener varios productos.

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProductosCategoria")
public class ProductosCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK hacia Producto
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto producto;

    // FK hacia Categoria
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria categoria;
}