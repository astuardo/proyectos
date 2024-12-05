package com.entregable.clienteapi.exception.producto;

public class NoStockException extends RuntimeException{

    public NoStockException(String message) {
        super(message);
    }
}
