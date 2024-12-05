package com.entregable.clienteapi.controller;

import com.entregable.clienteapi.entity.Producto;
import com.entregable.clienteapi.repository.ProductoRepository;
import com.entregable.clienteapi.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/getProducto/{id}")
    public Producto getProducto(@PathVariable("id") Long id) {
        return productoService.getProducto(id);
    }

    @GetMapping("/traeProductos")
    public List<Producto> getProducto() {
        return productoService.traeProductos();
    }

    @PostMapping("/addProducto")
    public Producto addProducto(@Validated @RequestBody Producto producto) {
        return productoService.addProducto(producto);
    }

    @PutMapping("/updProducto")
    public Producto updEmpresa(@Validated @RequestBody Producto producto) {
        return productoService.updProducto(producto);
    }

    @DeleteMapping("/delProducto/{id}")
    public String delProducto(@PathVariable("id") Long id) {
        return productoService.delProducto(id);
    }

    @PutMapping("/resProducto")
    public String resProducto(@Validated @RequestBody Producto producto) {
        return productoService.resProducto(producto);
    }
}
