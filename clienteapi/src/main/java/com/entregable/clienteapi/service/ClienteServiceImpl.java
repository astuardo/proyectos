package com.entregable.clienteapi.service;

import com.entregable.clienteapi.dto.ClienteDto;
import com.entregable.clienteapi.dto.FacturaDto;
import com.entregable.clienteapi.entity.Cliente;
import com.entregable.clienteapi.exception.entidad.EntidadNoEncontradoException;
import com.entregable.clienteapi.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getCliente(Long id) {
        Cliente clienteAObtener = clienteRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradoException("Cliente no encontrado con el id: " + id));
        return clienteAObtener;
    }

    public List<Cliente> traerClientes() {
        return clienteRepository.findAll();
    }

    public ClienteDto getClienteDto(Long id) {
        Cliente clienteAObtener = this.clienteRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradoException("Cliente no encontrado con el id: " + id));
        ClienteDto clienteDto = new ClienteDto();
        LocalDate fechaNacimiento = clienteAObtener.getFNacimiento();
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        clienteDto.setNombre(clienteAObtener.getNombre());
        clienteDto.setApellido(clienteAObtener.getApellido());
        return clienteDto;
    }

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updCliente(Cliente cliente) {
        Cliente clienteUpd = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new EntidadNoEncontradoException("Cliente no encontrado con el id: " + cliente.getId()));;
        clienteUpd.setNombre(cliente.getNombre());
        return clienteRepository.save(cliente);
    }

    public String delCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradoException("Cliente no encontrado con el id: " + id));;
        clienteRepository.deleteById(id);
        return "Cliente Borrado: " + cliente.getNombre() + " " + cliente.getApellido();
    }

    @Override
    public List<FacturaDto> facturasDelCliente(Long clienteId) {
        Cliente cliente = this.clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntidadNoEncontradoException("Cliente no encontrado con el id: " + clienteId));
        return cliente.getFacturas()
                .stream()
                .map(f -> new FacturaDto(f.getNumero().toString(), f.getFecha(), f.getTipoFactura(), f.getTotalFacturado()))
                .collect(Collectors.toList());
    }

}
