package com.entregable.clienteapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="dni")
    private String dni;

    @Column(name="direccion")
    private String direccion;

    @Column(name="fnacimiento")
    private LocalDate fNacimiento;

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="pais")
    private String pais;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;

    public Cliente(String nombre, String apellido, String dni, String direccion, Empresa empresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.empresa = empresa;
    }

}
