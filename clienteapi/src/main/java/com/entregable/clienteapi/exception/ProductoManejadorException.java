package com.entregable.clienteapi.exception;

import com.entregable.clienteapi.exception.producto.NoStockException;
import com.entregable.clienteapi.exception.producto.NoStockMensaje;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ProductoManejadorException {

    @ExceptionHandler(value = {NoStockException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public NoStockMensaje noStockDisponible(NoStockException ex,
                                              WebRequest request) {
        log.error("Error: {}", ex.getMessage());
        return new NoStockMensaje(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
    }

}
