package com.example.demo.model;

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

// Un producto puede tener varios proveedores y un proveedor puede suministrar varios productos.

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Proveedores")
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "ID_PROVEEDOR", nullable = false)
    private Proveedor proveedor;
}