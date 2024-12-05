package com.entregable.clienteapi.controller;

import com.entregable.clienteapi.dto.ClienteDto;
import com.entregable.clienteapi.dto.FacturaDto;
import com.entregable.clienteapi.dto.FacturaRespuesta;
import com.entregable.clienteapi.entity.Cliente;
import com.entregable.clienteapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/getCliente/{id}")
    public Cliente getCliente(@PathVariable(value = "id") Long id) {
        return clienteService.getCliente(id);
    }

    @GetMapping("/traerClientes")
    public List<Cliente> getClientes() {
        return clienteService.traerClientes();
    }

    @GetMapping("/getClienteDto/{id}")
    public ClienteDto getClienteDto(@PathVariable(value = "id") Long id) {
        return clienteService.getClienteDto(id);
    }

    @GetMapping("/facturas/{clienteId}")
    public List<FacturaDto> getFacturasDelCliente(@PathVariable Long clienteId) {
        return clienteService.facturasDelCliente(clienteId);
    }

    @PostMapping("/addCliente")
    public Cliente addCliente(@Validated @RequestBody Cliente cliente){
        return clienteService.addCliente(cliente);
    }

    @PutMapping("/updCliente")
    public Cliente updCliente(@Validated @RequestBody Cliente cliente){
        return clienteService.updCliente(cliente);
    }

    @DeleteMapping("/delCliente/{id}")
    public String delCliente(@PathVariable("id") Long id){
        return clienteService.delCliente(id);
    }

}
