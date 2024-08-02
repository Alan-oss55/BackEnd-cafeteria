package com.back.back_end.ventas;

import java.time.LocalDateTime;

import com.back.back_end.usuarios.Usuarios;

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

@Getter
@Setter
@Entity
@Table(name= "ventas", schema = "cafeteria")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "estado", nullable = false)
    private String estado;

    @PrePersist
    protected void onAction(){
        this.fechaVenta = LocalDateTime.now();
    }
}
