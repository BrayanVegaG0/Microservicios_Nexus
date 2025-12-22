package com.nexus.ms_transacciones.mapper;

import com.nexus.ms_transacciones.dto.RespuestaTransferenciaDTO;
import com.nexus.ms_transacciones.dto.SolicitudTransferenciaDTO;
import com.nexus.ms_transacciones.dto.SwitchTransaccionDTO;
import com.nexus.ms_transacciones.model.Transaccion;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-22T02:20:58-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class TransaccionMapperImpl implements TransaccionMapper {

    @Override
    public Transaccion solicitudToEntity(SolicitudTransferenciaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Transaccion transaccion = new Transaccion();

        transaccion.setCuentaOrigen( dto.getCuentaOrigen() );
        transaccion.setCuentaDestino( dto.getCuentaDestino() );
        transaccion.setMonto( dto.getMonto() );
        transaccion.setDescripcion( dto.getDescripcion() );

        transaccion.setEstado( "PENDING" );
        transaccion.setRolTransaccion( "DEBITO" );

        return transaccion;
    }

    @Override
    public SwitchTransaccionDTO entityToSwitchDto(Transaccion transaccion) {
        if ( transaccion == null ) {
            return null;
        }

        SwitchTransaccionDTO switchTransaccionDTO = new SwitchTransaccionDTO();

        switchTransaccionDTO.setInstructionId( transaccion.getInstructionId() );
        switchTransaccionDTO.setEndToEndId( transaccion.getReferencia() );
        switchTransaccionDTO.setBancoOrigenCodigo( transaccion.getBancoOrigen() );
        switchTransaccionDTO.setBancoDestinoCodigo( transaccion.getBancoDestino() );
        switchTransaccionDTO.setCuentaOrigen( transaccion.getCuentaOrigen() );
        switchTransaccionDTO.setCuentaDestino( transaccion.getCuentaDestino() );
        switchTransaccionDTO.setMonto( transaccion.getMonto() );
        switchTransaccionDTO.setEstado( transaccion.getEstado() );
        switchTransaccionDTO.setMensajeError( transaccion.getMensajeError() );

        switchTransaccionDTO.setMoneda( "USD" );

        return switchTransaccionDTO;
    }

    @Override
    public Transaccion switchDtoToEntity(SwitchTransaccionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Transaccion transaccion = new Transaccion();

        transaccion.setInstructionId( dto.getInstructionId() );
        transaccion.setReferencia( dto.getEndToEndId() );
        transaccion.setBancoOrigen( dto.getBancoOrigenCodigo() );
        transaccion.setBancoDestino( dto.getBancoDestinoCodigo() );
        transaccion.setCuentaOrigen( dto.getCuentaOrigen() );
        transaccion.setCuentaDestino( dto.getCuentaDestino() );
        transaccion.setMonto( dto.getMonto() );
        transaccion.setDescripcion( dto.getMensajeError() );
        transaccion.setMensajeError( dto.getMensajeError() );

        transaccion.setEstado( "PENDING" );
        transaccion.setRolTransaccion( "CREDITO" );

        return transaccion;
    }

    @Override
    public RespuestaTransferenciaDTO entityToRespuestaDto(Transaccion transaccion) {
        if ( transaccion == null ) {
            return null;
        }

        Integer idTransaccion = null;
        LocalDateTime fechaHora = null;
        String mensaje = null;
        String estado = null;

        idTransaccion = transaccion.getTransaccionId();
        fechaHora = transaccion.getFechaEjecucion();
        mensaje = transaccion.getDescripcion();
        estado = transaccion.getEstado();

        RespuestaTransferenciaDTO respuestaTransferenciaDTO = new RespuestaTransferenciaDTO( idTransaccion, estado, mensaje, fechaHora );

        return respuestaTransferenciaDTO;
    }
}
