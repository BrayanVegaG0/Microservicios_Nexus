package com.nexus.ms_transacciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(name = "SwitchTransaccion", description = "DTO para comunicación con el Switch")
public class SwitchTransaccionDTO {

    @JsonProperty("InstructionId")
    private String instructionId;

    @JsonProperty("EndToEndId")
    private String endToEndId;

    @JsonProperty("BancoOrigenCodigo")
    private String bancoOrigenCodigo;

    @JsonProperty("BancoDestinoCodigo")
    private String bancoDestinoCodigo;

    @JsonProperty("CuentaOrigen")
    private String cuentaOrigen;

    @JsonProperty("CuentaDestino")
    private String cuentaDestino;

    @JsonProperty("Monto")
    private BigDecimal monto;

    @JsonProperty("Moneda")
    private String moneda = "USD";

    @JsonProperty("Ordenante")
    private String ordenante; // Nuevo campo requerido por algunos switches, opcional aquí

    @JsonProperty("MensajeError")
    private String mensajeError;

    @JsonProperty("Estado")
    private String estado;
}