package com.entregable.clienteapi.service;

import com.entregable.clienteapi.dto.ClienteDto;
import com.entregable.clienteapi.dto.FacturaDto;
import com.entregable.clienteapi.dto.FacturaRespuesta;
import com.entregable.clienteapi.entity.Cliente;

import java.util.List;

public interface ClienteService {

    //Get
    Cliente getCliente(Long id);

    List<Cliente> traerClientes();

    ClienteDto getClienteDto(Long id);

    //Post
    Cliente addCliente(Cliente cliente);

    //Put
    Cliente updCliente(Cliente cliente);

    //Delete
    String delCliente(Long id);

    List<FacturaDto> facturasDelCliente(Long clienteId);
}
