package com.entregable.clienteapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="facturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long numero;

    @Column(name="fecha")
    private LocalDateTime fecha;

    @Column(name="tipo_factura")
    private String tipoFactura;

    @Column(name="total_facturado")
    private Integer totalFacturado;

    @ManyToOne
    private Cliente cliente;

    public Factura(LocalDateTime fecha, String tipoFactura, Integer totalFacturado, Cliente cliente) {
        this.fecha = fecha;
        this.tipoFactura = tipoFactura;
        this.totalFacturado = totalFacturado;
        this.cliente = cliente;
    }

}
