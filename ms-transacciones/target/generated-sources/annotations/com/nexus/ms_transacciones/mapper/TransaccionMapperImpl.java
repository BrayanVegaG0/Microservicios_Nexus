package com.nexus.ms_transacciones.mapper;

import com.nexus.ms_transacciones.dto.RespuestaTransferenciaDTO;
import com.nexus.ms_transacciones.dto.SolicitudTransferenciaDTO;
import com.nexus.ms_transacciones.dto.SwitchTransaccionDTO;
import com.nexus.ms_transacciones.model.Transaccion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-21T18:24:37-0500",
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

        transaccion.setIdBancoDestino( dto.getBancoDestinoId() );
        transaccion.setCuentaDestino( dto.getCuentaDestino() );
        transaccion.setCuentaOrigen( dto.getCuentaOrigen() );
        transaccion.setDescripcion( dto.getDescripcion() );
        transaccion.setMonto( dto.getMonto() );

        transaccion.setEstado( "PENDING" );
        transaccion.setRolTransaccion( "DEBITO" );
        transaccion.setIdBancoOrigen( 2 );

        return transaccion;
    }

    @Override
    public SwitchTransaccionDTO entityToSwitchDto(Transaccion transaccion) {
        if ( transaccion == null ) {
            return null;
        }

        SwitchTransaccionDTO switchTransaccionDTO = new SwitchTransaccionDTO();

        switchTransaccionDTO.setIdInstruccion( transaccion.getInstructionId() );
        switchTransaccionDTO.setEndToEnd( transaccion.getReferencia() );
        switchTransaccionDTO.setEstadoActual( transaccion.getEstado() );
        switchTransaccionDTO.setMensaje( transaccion.getDescripcion() );
        switchTransaccionDTO.setCuentaDestino( transaccion.getCuentaDestino() );
        switchTransaccionDTO.setCuentaOrigen( transaccion.getCuentaOrigen() );
        switchTransaccionDTO.setIdBancoDestino( transaccion.getIdBancoDestino() );
        switchTransaccionDTO.setIdBancoOrigen( transaccion.getIdBancoOrigen() );
        switchTransaccionDTO.setMonto( transaccion.getMonto() );

        return switchTransaccionDTO;
    }

    @Override
    public Transaccion switchDtoToEntity(SwitchTransaccionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Transaccion transaccion = new Transaccion();

        transaccion.setInstructionId( dto.getIdInstruccion() );
        transaccion.setReferencia( dto.getEndToEnd() );
        transaccion.setEstado( dto.getEstadoActual() );
        transaccion.setDescripcion( dto.getMensaje() );
        transaccion.setCuentaDestino( dto.getCuentaDestino() );
        transaccion.setCuentaOrigen( dto.getCuentaOrigen() );
        transaccion.setIdBancoDestino( dto.getIdBancoDestino() );
        transaccion.setIdBancoOrigen( dto.getIdBancoOrigen() );
        transaccion.setMonto( dto.getMonto() );

        transaccion.setRolTransaccion( "CREDITO" );

        return transaccion;
    }

    @Override
    public RespuestaTransferenciaDTO entityToRespuestaDto(Transaccion transaccion) {
        if ( transaccion == null ) {
            return null;
        }

        RespuestaTransferenciaDTO.RespuestaTransferenciaDTOBuilder respuestaTransferenciaDTO = RespuestaTransferenciaDTO.builder();

        respuestaTransferenciaDTO.idTransaccion( transaccion.getTransaccionId() );
        respuestaTransferenciaDTO.fechaHora( transaccion.getFechaEjecucion() );
        respuestaTransferenciaDTO.mensaje( transaccion.getDescripcion() );
        respuestaTransferenciaDTO.estado( transaccion.getEstado() );

        return respuestaTransferenciaDTO.build();
    }
}
