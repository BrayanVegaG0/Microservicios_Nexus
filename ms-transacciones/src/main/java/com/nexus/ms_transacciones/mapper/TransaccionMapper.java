package com.nexus.ms_transacciones.mapper;

import com.nexus.ms_transacciones.dto.*;
import com.nexus.ms_transacciones.model.Transaccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransaccionMapper {

    @Mapping(target = "transaccionId", ignore = true)
    @Mapping(target = "estado", constant = "PENDING")
    @Mapping(target = "rolTransaccion", constant = "DEBITO")
    @Mapping(target = "bancoOrigen", ignore = true)
    @Mapping(target = "bancoDestino", ignore = true)
    @Mapping(target = "instructionId", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "mensajeError", ignore = true)
    @Mapping(target = "fechaEjecucion", ignore = true)
    @Mapping(target = "referencia", ignore = true)
    Transaccion solicitudToEntity(SolicitudTransferenciaDTO dto);

    // Entidad -> Switch JSON
    @Mapping(target = "instructionId", source = "instructionId")
    @Mapping(target = "endToEndId", source = "referencia")
    @Mapping(target = "bancoOrigenCodigo", source = "bancoOrigen")
    @Mapping(target = "bancoDestinoCodigo", source = "bancoDestino")
    @Mapping(target = "cuentaOrigen", source = "cuentaOrigen")
    @Mapping(target = "cuentaDestino", source = "cuentaDestino")
    @Mapping(target = "monto", source = "monto")
    @Mapping(target = "estado", source = "estado")
    // Ignored or Defaulted
    @Mapping(target = "moneda", constant = "USD")
    @Mapping(target = "ordenante", ignore = true)
    @Mapping(target = "mensajeError", source = "mensajeError")
    SwitchTransaccionDTO entityToSwitchDto(Transaccion transaccion);

    // Switch JSON -> Entidad (Entrada)
    @Mapping(target = "transaccionId", ignore = true)
    @Mapping(target = "instructionId", source = "instructionId")
    @Mapping(target = "referencia", source = "endToEndId")
    @Mapping(target = "bancoOrigen", source = "bancoOrigenCodigo")
    @Mapping(target = "bancoDestino", source = "bancoDestinoCodigo")
    @Mapping(target = "cuentaOrigen", source = "cuentaOrigen")
    @Mapping(target = "cuentaDestino", source = "cuentaDestino")
    @Mapping(target = "monto", source = "monto")
    @Mapping(target = "estado", constant = "PENDING") // Always pending when received
    @Mapping(target = "descripcion", source = "mensajeError") // Just to store msg
    @Mapping(target = "rolTransaccion", constant = "CREDITO")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "fechaEjecucion", ignore = true)
    @Mapping(target = "mensajeError", source = "mensajeError")
    Transaccion switchDtoToEntity(SwitchTransaccionDTO dto);

    // Entidad -> Respuesta Cliente
    @Mapping(target = "idTransaccion", source = "transaccionId")
    @Mapping(target = "fechaHora", source = "fechaEjecucion")
    @Mapping(target = "mensaje", source = "descripcion")
    RespuestaTransferenciaDTO entityToRespuestaDto(Transaccion transaccion);
}