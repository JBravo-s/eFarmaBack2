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

// Indica cuántas unidades de un producto se vendieron en una venta específica.

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProductosVenta")
public class ProductosVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "ID_VENTA", nullable = false)
    private Venta venta;
}