package com.garritas.sgv.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    private String nombre;
    private String descripcion;
    private String estado;

    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    // Getters y setters
}