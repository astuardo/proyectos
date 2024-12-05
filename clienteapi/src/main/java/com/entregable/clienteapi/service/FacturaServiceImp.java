package com.entregable.clienteapi.service;

import com.entregable.clienteapi.dto.*;
import com.entregable.clienteapi.entity.Cliente;
import com.entregable.clienteapi.entity.Empresa;
import com.entregable.clienteapi.entity.Factura;
import com.entregable.clienteapi.entity.Producto;
import com.entregable.clienteapi.exception.entidad.EntidadNoEncontradoException;
import com.entregable.clienteapi.exception.factura.FacturaNoEncontradaException;
import com.entregable.clienteapi.exception.producto.NoStockException;
import com.entregable.clienteapi.repository.ClienteRepository;
import com.entregable.clienteapi.repository.EmpresaRepository;
import com.entregable.clienteapi.repository.FacturaRepository;
import com.entregable.clienteapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImp implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;


    @Override
    public FacturaDto facturaPorId(Long facturaId) {
        Factura f = this.facturaRepository.findById(facturaId)
                .orElseThrow(() -> new FacturaNoEncontradaException("No se encontro la factura con el id: " + facturaId));
        return new FacturaDto(f.getNumero().toString(), f.getFecha(), f.getTipoFactura(), f.getTotalFacturado());
    }

    @Override
    public FacturaRespuesta registroCompra(ClienteDto clienteDto) {
        Cliente cliente = this.clienteRepository.findById(clienteDto.getClienteId())
                .orElseGet(() -> {
                            Empresa empresa = this.empresaRepository.findById(1L)
                                    .orElseThrow(() -> new EntidadNoEncontradoException("No se encontro la empresa"));
                            return this.clienteRepository.save(new Cliente(clienteDto.getNombre(),
                                    clienteDto.getApellido(),
                                    clienteDto.getDni(),
                                    clienteDto.getDireccion(), empresa));
                        }

                );

        List<DetalleFacturaDto> listaDetalleFacturaDto = clienteDto.getProductos()
                .stream()
                .map(productoDto -> {
                    Producto producto = this.productoRepository.findById(productoDto.getProductoId())
                            .orElseThrow();
                    if (producto.getStock() == 0 || productoDto.getCantidad() > producto.getStock()) {
                        throw new NoStockException("No hay stock suficiente o la cantidad no esta disponible");
                    }
                    return new DetalleFacturaDto(new ProductoDto(producto.getNombre(), producto.getDescripcion(), producto.getPrecio()),
                            producto.getStock(), productoDto.getCantidad());
                }).collect(Collectors.toList());

        int totalFactura = clienteDto.getProductos()
                .stream()
                .map(ProductoDto::getCantidad)
                .mapToInt(Integer::intValue)
                .sum();

        FacturaDto facturaDto = new FacturaDto();
        facturaDto.setNumero(UUID.fromString(UUID.randomUUID().toString()).toString());
        facturaDto.setFecha(LocalDateTime.now());
        facturaDto.setTipoFactura("A");
        facturaDto.setTotalFactura(totalFactura);
        facturaDto.setCliente(new ClienteDto(cliente.getNombre(), cliente.getApellido(), cliente.getDni(), cliente.getDireccion()));
        facturaDto.setDetalleFactura(listaDetalleFacturaDto);
        facturaDto.setEmpresa(new EmpresaDto(cliente.getEmpresa().getNombre(), cliente.getEmpresa().getRubro()));

        Factura facturaGuardada = this.facturaRepository.save(new Factura(facturaDto.getFecha(), facturaDto.getTipoFactura(), facturaDto.getTotalFactura(), cliente));

        facturaDto.setNumero(facturaGuardada.getNumero().toString());

        return new FacturaRespuesta(facturaDto);
    }


}
