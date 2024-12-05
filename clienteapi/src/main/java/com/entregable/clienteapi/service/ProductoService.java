package com.entregable.clienteapi.service;

import com.entregable.clienteapi.entity.Producto;

import java.util.List;

public interface ProductoService {

    //Get
    Producto getProducto(Long id);
    List<Producto> traeProductos();
    //Put
    Producto updProducto(Producto producto);
    //Add
    Producto addProducto(Producto producto);
    //Delete
    String delProducto(Long id);
    //Restar
    String resProducto(Producto producto);
}
