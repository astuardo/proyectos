package com.entregable.clienteapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacturaDto {

    private String numero;
    private LocalDateTime fecha;
    private String tipoFactura;
    private Integer totalFactura;
    private ClienteDto cliente;
    private List<DetalleFacturaDto> detalleFactura;
    private EmpresaDto empresa;

    public FacturaDto(String numero, LocalDateTime fecha, String tipoFactura, Integer totalFactura) {
        this.numero = numero;
        this.fecha = fecha;
        this.tipoFactura = tipoFactura;
        this.totalFactura = totalFactura;
    }
}
