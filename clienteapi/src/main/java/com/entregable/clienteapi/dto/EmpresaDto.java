package com.entregable.clienteapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpresaDto {

    @NotEmpty(message = "El nombre de la empresa es obligatorio")
    private String nombre;
    @NotEmpty(message = "La razon social de la empresa es obligatorio")
    private String rubro;

}
