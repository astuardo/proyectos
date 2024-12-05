package com.entregable.clienteapi.service;

import com.entregable.clienteapi.dto.ClienteDto;
import com.entregable.clienteapi.dto.FacturaDto;
import com.entregable.clienteapi.dto.FacturaRespuesta;

public interface FacturaService {

    FacturaDto facturaPorId(Long clienteId);

    FacturaRespuesta registroCompra(ClienteDto cliente);

}
