package com.entregable.clienteapi.exception.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntidadMensajeError {

    private Integer codigoStado;
    private LocalDateTime tiempo;
    private String mensaje;
    private String descripcion;

}
