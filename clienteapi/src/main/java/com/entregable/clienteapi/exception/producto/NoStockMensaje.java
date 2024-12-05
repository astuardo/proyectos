package com.entregable.clienteapi.exception.producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoStockMensaje {

    private Integer codigoStado;
    private LocalDateTime tiempo;
    private String mensaje;
    private String descripcion;

}
