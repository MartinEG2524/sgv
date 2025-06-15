package com.garritas.sgv.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;

    private String tipo;

    private String descripcion;

    private BigDecimal precio;

    private String estado;

    // Getters y Setters
}
