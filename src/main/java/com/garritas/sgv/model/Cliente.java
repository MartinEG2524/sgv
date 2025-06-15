package com.garritas.sgv.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String nombres;
    private String apellidos;

    @Column(unique = true)
    private Integer dni;

    private String correo;
    private String direccion;
    private String sexo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private Integer celular;
    private String pais;
    private String provincia;
    private String distrito;
    private String estado;

    // Getters y setters
}
