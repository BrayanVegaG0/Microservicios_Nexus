package com.nexus.ms_clientes.mapper;

import com.nexus.ms_clientes.dto.PersonaDTO;
import com.nexus.ms_clientes.dto.RegistroClientePersonaDTO;
import com.nexus.ms_clientes.model.Persona;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-21T18:24:34-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public Persona toEntity(RegistroClientePersonaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setNumeroIdentificacion( dto.getCedula() );
        persona.setApellidos( dto.getApellidos() );
        persona.setDireccion( dto.getDireccion() );
        persona.setFechaNacimiento( dto.getFechaNacimiento() );
        persona.setNombres( dto.getNombres() );

        persona.setTipoCliente( "P" );
        persona.setEstado( "ACTIVO" );
        persona.setFechaRegistro( LocalDate.now() );
        persona.setTipoIdentificacion( "CEDULA" );

        return persona;
    }

    @Override
    public PersonaDTO toDTO(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaDTO.PersonaDTOBuilder personaDTO = PersonaDTO.builder();

        personaDTO.apellidos( persona.getApellidos() );
        personaDTO.clienteId( persona.getClienteId() );
        personaDTO.estado( persona.getEstado() );
        personaDTO.nombres( persona.getNombres() );
        personaDTO.numeroIdentificacion( persona.getNumeroIdentificacion() );

        return personaDTO.build();
    }
}
