package com.entregable.clienteapi.controller;

import com.entregable.clienteapi.dto.ClienteDto;
import com.entregable.clienteapi.dto.FacturaDto;
import com.entregable.clienteapi.dto.FacturaRespuesta;
import com.entregable.clienteapi.service.FacturaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class FacturaController {

    @Autowired
    private FacturaServiceImp facturaService;

    @GetMapping("/factura/{facturaId}")
    public FacturaDto getFactura(@PathVariable Long facturaId) {
        return facturaService.facturaPorId(facturaId);
    }

    @PostMapping("/factura-producto-registro")
    public FacturaRespuesta registroCompra(@Validated @RequestBody ClienteDto clienteDto){
        return facturaService.registroCompra(clienteDto);
    }

}
