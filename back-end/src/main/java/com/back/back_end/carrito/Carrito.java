package com.back.back_end.carrito;

import java.time.LocalDateTime;

import com.back.back_end.productos.Productos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "carrito", schema = "cafeteria")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "id_usuario", nullable = false)
    // private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha_creacion")
    private LocalDateTime fecha;

    @Column(name = "estado", length = 50)
    private String estado;

    @PrePersist
    protected void onAction(){
        this.fecha = LocalDateTime.now();
    }
}
