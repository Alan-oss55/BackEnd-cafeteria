package com.back.back_end.DetalleVenta.com;

import com.back.back_end.productos.Productos;
import com.back.back_end.ventas.Ventas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalles_ventas", schema="cafeteria")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)         
    private Ventas venta;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio", nullable = false)
    private Long precio;
}
