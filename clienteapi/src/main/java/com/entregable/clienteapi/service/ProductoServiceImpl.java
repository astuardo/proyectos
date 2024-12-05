package com.entregable.clienteapi.service;

import com.entregable.clienteapi.entity.Producto;
import com.entregable.clienteapi.exception.entidad.EntidadNoEncontradoException;
import com.entregable.clienteapi.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public Producto getProducto(Long id) {
        Producto productoAObtener = productoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradoException("Producto no encontrado con el id: " + id));
        return productoAObtener;
    }

    public List<Producto> traeProductos() {
        return productoRepository.findAll();
    }

    public Producto updProducto(Producto producto) {
        Producto productoUpd = productoRepository.findById(producto.getId())
                .orElseThrow(() -> new EntidadNoEncontradoException("Producto no encontrado con el id: " + producto.getId()));
        productoUpd.setNombre(producto.getNombre());
        productoUpd.setDescripcion(producto.getDescripcion());
        productoUpd.setPrecio(producto.getPrecio());
        productoUpd.setStock(producto.getStock());
        return productoRepository.save(producto);
    }

    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public String delProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradoException("Producto no encontrado con el id: " + id));
        productoRepository.deleteById(id);
        return "Producto Borrado: " + producto.getNombre();
    }

    public String resProducto(Producto producto) {
        Producto resProducto = productoRepository.findById(producto.getId())
                .orElseThrow(() -> new EntidadNoEncontradoException("Producto no encontrado con el id: " + producto.getId()));
        if (resProducto.getStock() > 0) {
            int cantAnterior = resProducto.getStock();
            int resta = cantAnterior - 1;
            resProducto.setStock(resta);
            productoRepository.save(resProducto);
            return "Ud sacó: " + resProducto.getNombre() + ". La cantidad actual es: " + resta + " y la cantidad anterior era: " + cantAnterior;
        } else {
            return "No se puede restar más de la cantidad en stock (" + resProducto.getStock() + ")";
        }
    }
}
