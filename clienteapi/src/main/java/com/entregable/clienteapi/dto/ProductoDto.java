package com.entregable.clienteapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoDto {

    private Long productoId;
    @NotEmpty(message = "El nombre del producto no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "La descripcion del producto no puede estar vacia")
    private String descripcion;
    @NotNull(message = "El precio del producto no puede ser nulo")
    private Integer precioUnitario;
    @NotNull(message = "La cantidad del producto no puede ser nula")
    @Min(value = 1, message = "La cantidad del producto debe ser mayor a 0")
    private Integer cantidad;

    public ProductoDto(String nombre, String descripcion, Integer precioUnitario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }
}
